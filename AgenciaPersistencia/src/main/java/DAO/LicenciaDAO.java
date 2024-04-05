
package DAO;

import entidades.Estado;
import entidades.Licencia;
import entidades.Persona;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Wilber
 */
public class LicenciaDAO implements ILicenciaDAO {

//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//    EntityManager em = emf.createEntityManager();

    @Override
    public Licencia agregar(Licencia licencia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        
        Licencia licenciaNueva = licencia;
        String folioAleatorio = this.generarFolioAleatorio(10);
        licenciaNueva.setFolio(folioAleatorio);

        em.getTransaction().begin();
        em.persist(licencia);
        em.getTransaction().commit();
        
        em.close();
        emf.close();

        return licencia;
    }

    @Override
    public Licencia consultarPorFolio(Licencia licencia) {
        String folio = licencia.getFolio();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            TypedQuery<Licencia> query = em.createQuery("Select l from Licencia l where l.folio = :folio", Licencia.class);
            query.setParameter("folio", licencia.getFolio());
            licencia = query.getSingleResult();
            em.getTransaction().commit();
            return licencia;
        } catch (NoResultException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();

            }
            return null;
        } finally {
            em.close();
            emf.close();

        }

    }

    @Override
    public Licencia consultarPorId(Licencia licencia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        Long id = licencia.getId();
        try {
            em.getTransaction().begin();
            TypedQuery<Licencia> query = em.createQuery("Select l from Licencia l where l.id = :id", Licencia.class);
            query.setParameter("id", id);
            licencia = query.getSingleResult();
            em.getTransaction().commit();
            return licencia;

        } catch (NoResultException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();

            }
            return null;
        } finally {
            em.close();
            emf.close();

        }
    }

    @Override
    public Licencia desactivar(Licencia licencia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        Estado estado = null;
        Licencia licenciaBuscada = this.consultarPorFolio(licencia);
        try {
            em.getTransaction().begin();
            licenciaBuscada.setEstado(estado.INACTIVO);
            em.merge(licenciaBuscada);
            em.getTransaction().commit();
            Licencia licenciaActualizada = this.consultarPorId(licenciaBuscada);
            return licenciaActualizada;
        } catch (NoResultException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();

            }
            return null;
        } finally {
            em.close();
            emf.close();

        }
    }

    @Override
    public List<Licencia> consultarLicenciasPersona(Persona persona) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            TypedQuery<Licencia> query = em.createQuery(
                    "SELECT l FROM Licencia l JOIN l.persona p WHERE p = :persona",
                    Licencia.class
            );

            query.setParameter("persona", persona);
            List<Licencia> listaLicencias = query.getResultList();

            em.getTransaction().commit();

            return listaLicencias;
        } catch (NoResultException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        } finally {
            em.close();
            emf.close();
        }

    }

    @Override
    public void cerrarConexion() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
    
    private String generarFolioAleatorio(int longitud) {
        // Caracteres válidos para el folio
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Crear un objeto Random
        Random random = new Random();

        // Crear una cadena para almacenar el folio generado
        StringBuilder folio = new StringBuilder();

        // Generar el folio aleatorio
        for (int i = 0; i < longitud; i++) {
            // Obtener un índice aleatorio dentro del rango de caracteres
            int indice = random.nextInt(caracteres.length());

            // Agregar el carácter correspondiente al folio
            folio.append(caracteres.charAt(indice));
        }

        // Devolver el folio generado como una cadena
        return folio.toString();
    }

}
