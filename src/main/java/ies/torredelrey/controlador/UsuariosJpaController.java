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
 * @author Daniel Gutierrez Ramirez
 * 
 * Controlador JPA para la entidad Usuarios.
 * Proporciona métodos para crear, editar, eliminar y buscar usuarios, así como verificar la existencia de un usuario.
 * @version 1.0
 */
public class UsuariosJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    /**
     * Constructor que recibe una fábrica de entidades.
     * 
     * @param emf La fábrica de entidades para manejar las operaciones JPA.
     */
    public UsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Obtiene el EntityManager para manejar las operaciones JPA.
     * 
     * @return El EntityManager.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Busca un usuario por su DNI.
     * 
     * @param dni El DNI del usuario.
     * @return El usuario encontrado o null si no existe.
     */
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

    /**
     * Crea un nuevo usuario.
     * 
     * @param usuarios El usuario a crear.
     */
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

    /**
     * Edita un usuario existente.
     * 
     * @param usuarios El usuario a editar.
     * @throws IllegalOrphanException Si hay reservas huérfanas no permitidas.
     * @throws NonexistentEntityException Si el usuario no existe.
     * @throws Exception Si ocurre un error durante la edición.
     */
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

    /**
     * Elimina un usuario por su ID.
     * 
     * @param id El ID del usuario a eliminar.
     * @throws IllegalOrphanException Si hay reservas huérfanas no permitidas.
     * @throws NonexistentEntityException Si el usuario no existe.
     */
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

    /**
     * Encuentra todas las entidades de usuarios.
     * 
     * @return Una lista de todos los usuarios.
     */
    public List<Usuarios> findUsuariosEntities() {
        return findUsuariosEntities(true, -1, -1);
    }

    /**
     * Encuentra un subconjunto de entidades de usuarios.
     * 
     * @param maxResults El número máximo de resultados.
     * @param firstResult El primer resultado a devolver.
     * @return Una lista de usuarios.
     */
    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        return findUsuariosEntities(false, maxResults, firstResult);
    }

    /**
     * Encuentra las entidades de usuarios.
     * 
     * @param all Si se deben devolver todas las entidades.
     * @param maxResults El número máximo de resultados.
     * @param firstResult El primer resultado a devolver.
     * @return Una lista de usuarios.
     */
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

    /**
     * Encuentra un usuario por su ID.
     * 
     * @param id El ID del usuario.
     * @return El usuario encontrado.
     */
    public Usuarios findUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el número total de usuarios.
     * 
     * @return El número de usuarios.
     */
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

    /**
     * Encuentra todos los usuarios.
     * 
     * @return Una lista de todos los usuarios.
     */
    public List<Usuarios> findAllUsuarios() {
        return findUsuariosEntities(true, -1, -1);
    }
}