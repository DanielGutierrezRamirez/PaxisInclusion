/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.torredelrey.controlador;

import ies.torredelrey.controlador.exceptions.IllegalOrphanException;
import ies.torredelrey.controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ies.torredelrey.modelo.Reservas;
import ies.torredelrey.modelo.Usuarios;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author 34662
 */
public class UsuariosJpaController implements Serializable {
    



    public Usuarios findUsuariosByDni(String dni) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Usuarios.findByDni");
            query.setParameter("dni", dni);
            return (Usuarios) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public UsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuarios usuarios) {
        if (usuarios.getReservasCollection() == null) {
            usuarios.setReservasCollection(new ArrayList<Reservas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Reservas> attachedReservasCollection = new ArrayList<Reservas>();
            for (Reservas reservasCollectionReservasToAttach : usuarios.getReservasCollection()) {
                reservasCollectionReservasToAttach = em.getReference(reservasCollectionReservasToAttach.getClass(), reservasCollectionReservasToAttach.getId());
                attachedReservasCollection.add(reservasCollectionReservasToAttach);
            }
            usuarios.setReservasCollection(attachedReservasCollection);
            em.persist(usuarios);
            for (Reservas reservasCollectionReservas : usuarios.getReservasCollection()) {
                Usuarios oldUsuariosOfReservasCollectionReservas = reservasCollectionReservas.getUsuarios();
                reservasCollectionReservas.setUsuarios(usuarios);
                reservasCollectionReservas = em.merge(reservasCollectionReservas);
                if (oldUsuariosOfReservasCollectionReservas != null) {
                    oldUsuariosOfReservasCollectionReservas.getReservasCollection().remove(reservasCollectionReservas);
                    oldUsuariosOfReservasCollectionReservas = em.merge(oldUsuariosOfReservasCollectionReservas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuarios usuarios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios persistentUsuarios = em.find(Usuarios.class, usuarios.getId());
            Collection<Reservas> reservasCollectionOld = persistentUsuarios.getReservasCollection();
            Collection<Reservas> reservasCollectionNew = usuarios.getReservasCollection();
            List<String> illegalOrphanMessages = null;
            for (Reservas reservasCollectionOldReservas : reservasCollectionOld) {
                if (!reservasCollectionNew.contains(reservasCollectionOldReservas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reservas " + reservasCollectionOldReservas + " since its usuarios field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Reservas> attachedReservasCollectionNew = new ArrayList<Reservas>();
            for (Reservas reservasCollectionNewReservasToAttach : reservasCollectionNew) {
                reservasCollectionNewReservasToAttach = em.getReference(reservasCollectionNewReservasToAttach.getClass(), reservasCollectionNewReservasToAttach.getId());
                attachedReservasCollectionNew.add(reservasCollectionNewReservasToAttach);
            }
            reservasCollectionNew = attachedReservasCollectionNew;
            usuarios.setReservasCollection(reservasCollectionNew);
            usuarios = em.merge(usuarios);
            for (Reservas reservasCollectionNewReservas : reservasCollectionNew) {
                if (!reservasCollectionOld.contains(reservasCollectionNewReservas)) {
                    Usuarios oldUsuariosOfReservasCollectionNewReservas = reservasCollectionNewReservas.getUsuarios();
                    reservasCollectionNewReservas.setUsuarios(usuarios);
                    reservasCollectionNewReservas = em.merge(reservasCollectionNewReservas);
                    if (oldUsuariosOfReservasCollectionNewReservas != null && !oldUsuariosOfReservasCollectionNewReservas.equals(usuarios)) {
                        oldUsuariosOfReservasCollectionNewReservas.getReservasCollection().remove(reservasCollectionNewReservas);
                        oldUsuariosOfReservasCollectionNewReservas = em.merge(oldUsuariosOfReservasCollectionNewReservas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarios.getId();
                if (findUsuarios(id) == null) {
                    throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarios;
            try {
                usuarios = em.getReference(Usuarios.class, id);
                usuarios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Reservas> reservasCollectionOrphanCheck = usuarios.getReservasCollection();
            for (Reservas reservasCollectionOrphanCheckReservas : reservasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the Reservas " + reservasCollectionOrphanCheckReservas + " in its reservasCollection field has a non-nullable usuarios field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuarios> findUsuariosEntities() {
        return findUsuariosEntities(true, -1, -1);
    }

    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        return findUsuariosEntities(false, maxResults, firstResult);
    }

    private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuarios findUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Usuarios> findAllUsuarios() {
        return findUsuariosEntities(true, -1, -1);

    }
    
}
