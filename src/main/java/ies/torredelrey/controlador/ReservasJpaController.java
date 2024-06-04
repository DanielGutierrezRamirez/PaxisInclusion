/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.torredelrey.controlador;

import ies.torredelrey.controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ies.torredelrey.modelo.Actividad;
import ies.torredelrey.modelo.Reservas;
import ies.torredelrey.modelo.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 34662
 */
public class ReservasJpaController implements Serializable {

    public boolean existeReserva(String dni, String nombreActividad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("SELECT COUNT(r) FROM Reservas r WHERE r.dniUsuario = :dni AND r.nombreActividad = :nombreActividad");
            query.setParameter("dni", dni);
            query.setParameter("nombreActividad", nombreActividad);
            Long count = (Long) query.getSingleResult();
            return count > 0;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public ReservasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reservas reservas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad idActividad = reservas.getIdActividad();
            if (idActividad != null) {
                idActividad = em.getReference(idActividad.getClass(), idActividad.getId());
                reservas.setIdActividad(idActividad);
            }
            Usuarios usuarios = reservas.getUsuarios();
            if (usuarios != null) {
                usuarios = em.getReference(usuarios.getClass(), usuarios.getId());
                reservas.setUsuarios(usuarios);
            }
            em.persist(reservas);
            if (idActividad != null) {
                idActividad.getReservasCollection().add(reservas);
                idActividad = em.merge(idActividad);
            }
            if (usuarios != null) {
                usuarios.getReservasCollection().add(reservas);
                usuarios = em.merge(usuarios);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reservas reservas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reservas persistentReservas = em.find(Reservas.class, reservas.getId());
            Actividad idActividadOld = persistentReservas.getIdActividad();
            Actividad idActividadNew = reservas.getIdActividad();
            Usuarios usuariosOld = persistentReservas.getUsuarios();
            Usuarios usuariosNew = reservas.getUsuarios();
            if (idActividadNew != null) {
                idActividadNew = em.getReference(idActividadNew.getClass(), idActividadNew.getId());
                reservas.setIdActividad(idActividadNew);
            }
            if (usuariosNew != null) {
                usuariosNew = em.getReference(usuariosNew.getClass(), usuariosNew.getId());
                reservas.setUsuarios(usuariosNew);
            }
            reservas = em.merge(reservas);
            if (idActividadOld != null && !idActividadOld.equals(idActividadNew)) {
                idActividadOld.getReservasCollection().remove(reservas);
                idActividadOld = em.merge(idActividadOld);
            }
            if (idActividadNew != null && !idActividadNew.equals(idActividadOld)) {
                idActividadNew.getReservasCollection().add(reservas);
                idActividadNew = em.merge(idActividadNew);
            }
            if (usuariosOld != null && !usuariosOld.equals(usuariosNew)) {
                usuariosOld.getReservasCollection().remove(reservas);
                usuariosOld = em.merge(usuariosOld);
            }
            if (usuariosNew != null && !usuariosNew.equals(usuariosOld)) {
                usuariosNew.getReservasCollection().add(reservas);
                usuariosNew = em.merge(usuariosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reservas.getId();
                if (findReservas(id) == null) {
                    throw new NonexistentEntityException("The reservas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reservas reservas;
            try {
                reservas = em.getReference(Reservas.class, id);
                reservas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reservas with id " + id + " no longer exists.", enfe);
            }
            Actividad idActividad = reservas.getIdActividad();
            if (idActividad != null) {
                idActividad.getReservasCollection().remove(reservas);
                idActividad = em.merge(idActividad);
            }
            Usuarios usuarios = reservas.getUsuarios();
            if (usuarios != null) {
                usuarios.getReservasCollection().remove(reservas);
                usuarios = em.merge(usuarios);
            }
            em.remove(reservas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reservas> findReservasEntities() {
        return findReservasEntities(true, -1, -1);
    }

    public List<Reservas> findReservasEntities(int maxResults, int firstResult) {
        return findReservasEntities(false, maxResults, firstResult);
    }

    private List<Reservas> findReservasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reservas.class));
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

    public Reservas findReservas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reservas.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reservas> rt = cq.from(Reservas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Reservas> findAllReservas() {
        return findReservasEntities(true, -1, -1);
    }
    
}
