/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.torredelrey.controlador;

import ies.torredelrey.controlador.exceptions.IllegalOrphanException;
import ies.torredelrey.controlador.exceptions.NonexistentEntityException;
import ies.torredelrey.modelo.Actividad;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ies.torredelrey.modelo.Reservas;
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
 * clase ActividadJpaController
 * Proporciona métodos para crear, editar, eliminar y buscar actividades.
 * @version 1.0
 */

public class ActividadJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    /**
     * Constructor que recibe una fábrica de entidades.
     * 
     * @param emf La fábrica de entidades para manejar las operaciones JPA.
     */
    public ActividadJpaController(EntityManagerFactory emf) {
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
     * Encuentra todas las actividades.
     * 
     * @return Una lista de todas las actividades.
     */
    public List<Actividad> findAllActividades() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Actividades.findAll");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Encuentra una actividad por su nombre.
     * 
     * @param NombreActividad El nombre de la actividad.
     * @return La actividad encontrada, o null si no se encuentra.
     */
    public Actividad findByNombre(String NombreActividad) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Actividad.findByNombreActividad");
            query.setParameter("nombreActividad", NombreActividad);
            return (Actividad) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Crea una nueva actividad.
     * 
     * @param actividad La actividad a crear.
     */
    public void create(Actividad actividad) {
        if (actividad.getReservasCollection() == null) {
            actividad.setReservasCollection(new ArrayList<Reservas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Reservas> attachedReservasCollection = new ArrayList<Reservas>();
            for (Reservas reservasCollectionReservasToAttach : actividad.getReservasCollection()) {
                reservasCollectionReservasToAttach = em.getReference(reservasCollectionReservasToAttach.getClass(), reservasCollectionReservasToAttach.getId());
                attachedReservasCollection.add(reservasCollectionReservasToAttach);
            }
            actividad.setReservasCollection(attachedReservasCollection);
            em.persist(actividad);
            for (Reservas reservasCollectionReservas : actividad.getReservasCollection()) {
                Actividad oldIdActividadOfReservasCollectionReservas = reservasCollectionReservas.getIdActividad();
                reservasCollectionReservas.setIdActividad(actividad);
                reservasCollectionReservas = em.merge(reservasCollectionReservas);
                if (oldIdActividadOfReservasCollectionReservas != null) {
                    oldIdActividadOfReservasCollectionReservas.getReservasCollection().remove(reservasCollectionReservas);
                    oldIdActividadOfReservasCollectionReservas = em.merge(oldIdActividadOfReservasCollectionReservas);
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
     * Edita una actividad existente.
     * 
     * @param actividad La actividad a editar.
     * @throws IllegalOrphanException Si se encuentran registros huérfanos.
     * @throws NonexistentEntityException Si la actividad no existe.
     * @throws Exception Si ocurre un error durante la edición.
     */
    public void edit(Actividad actividad) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad persistentActividad = em.find(Actividad.class, actividad.getId());
            Collection<Reservas> reservasCollectionOld = persistentActividad.getReservasCollection();
            Collection<Reservas> reservasCollectionNew = actividad.getReservasCollection();
            List<String> illegalOrphanMessages = null;
            for (Reservas reservasCollectionOldReservas : reservasCollectionOld) {
                if (!reservasCollectionNew.contains(reservasCollectionOldReservas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reservas " + reservasCollectionOldReservas + " since its idActividad field is not nullable.");
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
            actividad.setReservasCollection(reservasCollectionNew);
            actividad = em.merge(actividad);
            for (Reservas reservasCollectionNewReservas : reservasCollectionNew) {
                if (!reservasCollectionOld.contains(reservasCollectionNewReservas)) {
                    Actividad oldIdActividadOfReservasCollectionNewReservas = reservasCollectionNewReservas.getIdActividad();
                    reservasCollectionNewReservas.setIdActividad(actividad);
                    reservasCollectionNewReservas = em.merge(reservasCollectionNewReservas);
                    if (oldIdActividadOfReservasCollectionNewReservas != null && !oldIdActividadOfReservasCollectionNewReservas.equals(actividad)) {
                        oldIdActividadOfReservasCollectionNewReservas.getReservasCollection().remove(reservasCollectionNewReservas);
                        oldIdActividadOfReservasCollectionNewReservas = em.merge(oldIdActividadOfReservasCollectionNewReservas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = actividad.getId();
                if (findActividad(id) == null) {
                    throw new NonexistentEntityException("The actividad with id " + id + " no longer exists.");
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
     * Elimina una actividad por su ID.
     * 
     * @param id El ID de la actividad a eliminar.
     * @throws IllegalOrphanException Si se encuentran registros huérfanos.
     * @throws NonexistentEntityException Si la actividad no existe.
     */
    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad actividad;
            try {
                actividad = em.getReference(Actividad.class, id);
                actividad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The actividad with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Reservas> reservasCollectionOrphanCheck = actividad.getReservasCollection();
            for (Reservas reservasCollectionOrphanCheckReservas : reservasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Actividad (" + actividad + ") cannot be destroyed since the Reservas " + reservasCollectionOrphanCheckReservas + " in its reservasCollection field has a non-nullable idActividad field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(actividad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Encuentra todas las entidades de actividad.
     * 
     * @return Una lista de todas las actividades.
     */
    public List<Actividad> findActividadEntities() {
        return findActividadEntities(true, -1, -1);
    }

    /**
     * Encuentra un subconjunto de entidades de actividad.
     * 
     * @param maxResults El número máximo de resultados.
     * @param firstResult El primer resultado a devolver.
     * @return Una lista de actividades.
     */
    public List<Actividad> findActividadEntities(int maxResults, int firstResult) {
        return findActividadEntities(false, maxResults, firstResult);
    }

    /**
     * Encuentra las entidades de actividad.
     * 
     * @param all Si se deben devolver todas las entidades.
     * @param maxResults El número máximo de resultados.
     * @param firstResult El primer resultado a devolver.
     * @return Una lista de actividades.
     */
    private List<Actividad> findActividadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Actividad.class));
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
     * Encuentra una actividad por su ID.
     * 
     * @param id El ID de la actividad.
     * @return La actividad encontrada.
     */
    public Actividad findActividad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Actividad.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el conteo total de actividades.
     * 
     * @return El número total de actividades.
     */
    public int getActividadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Actividad> rt = cq.from(Actividad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    /**
     * Elimina una reserva por su ID y actualiza el número de plazas de la actividad asociada.
     * 
     * @param id El ID de la reserva.
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void destroy(Long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Reservas reserva = em.getReference(Reservas.class, id);
            Actividad actividad = reserva.getIdActividad();
            if (actividad != null) {
                actividad.incrementarPlazas(1);
                em.merge(actividad);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Encuentra todas las reservas.
     * 
     * @return Una lista de todas las reservas.
     */
    public List<Reservas> findAllReservas() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Reservas r", Reservas.class).getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Encuentra todas las actividades.
     * 
     * @return Una lista de todas las actividades.
     */
    public List<Actividad> findAllActividad() {
        return findActividadEntities(true, -1, -1);
    }
}
