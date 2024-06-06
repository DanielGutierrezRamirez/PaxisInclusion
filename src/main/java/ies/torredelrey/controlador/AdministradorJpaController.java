package ies.torredelrey.controlador;

import ies.torredelrey.controlador.exceptions.NonexistentEntityException;
import ies.torredelrey.modelo.Administrador;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * 
 * @author Daniel Gutierrez Ramirez
 * 
 * Controlador JPA para la entidad Administrador.
 * Proporciona métodos para crear, editar, eliminar y buscar administradores.
 * @version 1.0
 */
public class AdministradorJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    /**
     * Constructor que recibe una fábrica de entidades.
     * 
     * @param emf La fábrica de entidades para manejar las operaciones JPA.
     */
    public AdministradorJpaController(EntityManagerFactory emf) {
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
     * Crea un nuevo administrador.
     * 
     * @param administrador El administrador a crear.
     */
    public void create(Administrador administrador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(administrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edita un administrador existente.
     * 
     * @param administrador El administrador a editar.
     * @throws NonexistentEntityException Si el administrador no existe.
     * @throws Exception Si ocurre un error durante la edición.
     */
    public void edit(Administrador administrador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            administrador = em.merge(administrador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = administrador.getId();
                if (findAdministrador(id) == null) {
                    throw new NonexistentEntityException("The administrador with id " + id + " no longer exists.");
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
     * Elimina un administrador por su ID.
     * 
     * @param id El ID del administrador a eliminar.
     * @throws NonexistentEntityException Si el administrador no existe.
     */
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador administrador;
            try {
                administrador = em.getReference(Administrador.class, id);
                administrador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administrador with id " + id + " no longer exists.", enfe);
            }
            em.remove(administrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Encuentra todas las entidades de administrador.
     * 
     * @return Una lista de todos los administradores.
     */
    public List<Administrador> findAdministradorEntities() {
        return findAdministradorEntities(true, -1, -1);
    }

    /**
     * Encuentra un subconjunto de entidades de administrador.
     * 
     * @param maxResults El número máximo de resultados.
     * @param firstResult El primer resultado a devolver.
     * @return Una lista de administradores.
     */
    public List<Administrador> findAdministradorEntities(int maxResults, int firstResult) {
        return findAdministradorEntities(false, maxResults, firstResult);
    }

    /**
     * Encuentra las entidades de administrador.
     * 
     * @param all Si se deben devolver todas las entidades.
     * @param maxResults El número máximo de resultados.
     * @param firstResult El primer resultado a devolver.
     * @return Una lista de administradores.
     */
    private List<Administrador> findAdministradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administrador.class));
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
     * Encuentra un administrador por su ID.
     * 
     * @param id El ID del administrador.
     * @return El administrador encontrado.
     */
    public Administrador findAdministrador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administrador.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el conteo total de administradores.
     * 
     * @return El número total de administradores.
     */
    public int getAdministradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administrador> rt = cq.from(Administrador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
