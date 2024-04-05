
package DAO;

import entidades.Automovil;
import entidades.Estado;
import entidades.Persona;
import entidades.Placa;
import entidades.Vehiculo;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
public class PlacaDAO implements IPlacaDAO {

    @Override
    public Placa agregar(Placa placa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        Placa PlacaNueva = placa;
        String numAleatorio = this.generarPlacaNumAleatorio(7);
        PlacaNueva.setNumPlaca(numAleatorio);

        em.getTransaction().begin();
        em.persist(placa);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return placa;
    }

    @Override
    public Placa consultarPorNumPlaca(Placa placa) {
        String numPlaca = placa.getNumPlaca();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            TypedQuery<Placa> query = em.createQuery("Select p from Placa p where p.numPlaca = :numPlaca", Placa.class);
            query.setParameter("numPlaca", placa.getNumPlaca());
            placa = query.getSingleResult();
            em.getTransaction().commit();
            return placa;
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
    public Placa consultarPorId (Placa placa) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        Long id = placa.getId();
        try {
            em.getTransaction().begin();
            TypedQuery<Placa> query = em.createQuery("SELECT p FROM Placa p WHERE p.id = :id", Placa.class);
            query.setParameter("id", id);
            placa = query.getSingleResult();
            em.getTransaction().commit();
            return placa;

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
    public Placa desactivar(Placa placa) {

       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        Estado estado = null;
        Placa placaBuscada = this.consultarPorNumPlaca(placa);
        try {
            placaBuscada.setEstado(estado.CADUCO);
            em.getTransaction().begin();
            em.merge(placaBuscada);
            em.getTransaction().commit();
            Placa placaActualizada = this.consultarPorId(placaBuscada);
            return placaBuscada;
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
    public Placa entregar(Placa placa) {

       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        Estado estado = null;
        Calendar fechaEntrega = Calendar.getInstance();
        Placa placaBuscada = this.consultarPorNumPlaca(placa);
        try {
            placaBuscada.setFechaEntrega(fechaEntrega);
            placaBuscada.setEntrego(true);
            placaBuscada.setEstado(Estado.INACTIVO);
            em.getTransaction().begin();
            em.merge(placaBuscada);
            em.getTransaction().commit();
            Placa placaActualizada = this.consultarPorId(placaBuscada);
            return placaActualizada;
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
    public List<Placa> consultarPlacasPersona(Persona persona) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            TypedQuery<Placa> query = em.createQuery(
                    "SELECT l FROM Placa l JOIN l.vehiculo v JOIN v.persona p WHERE p = :persona",
                    Placa.class
            );

            query.setParameter("persona", persona);
            List<Placa> listaPlacas = query.getResultList();

            em.getTransaction().commit();

            return listaPlacas;
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
    
    
    
    public String generarPlacaNumAleatorio(int longitud) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            char letra = letras.charAt(random.nextInt(letras.length()));
            sb.append(letra);
        }
        
        int numeros = random.nextInt(1000);
        String numerosStr = String.format("%03d", numeros);
        
        return sb.toString() + "-" + numerosStr;
        
    }

//    
//    /**
//     * METODO PARA VER SI ES LA PRIMERA VEZ QUE SE SOLICITA UNA PLACA.
//     * @param automovil
//     * @return 
//     */
////    @Override
////    public boolean esPrimeraVez(Automovil automovil) {
////        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
////        EntityManager em = emf.createEntityManager();
////
////        try {
////            TypedQuery<Automovil> query = em.createQuery("SELECT a FROM Automovil a WHERE a.serie = :serie", Automovil.class);
////            query.setParameter("automovil", automovil);
////            Automovil automovilConsultado = query.getSingleResult();
////
////            if(automovilConsultado.getSerie() != null){
////                return false;
////                
////            }
////            else{
////                return true;
////            }
////        } finally {
////            em.close();
////            emf.close();
////        }
////    }
    
}
