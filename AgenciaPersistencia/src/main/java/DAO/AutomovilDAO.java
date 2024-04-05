
package DAO;

import entidades.Automovil;
import entidades.Placa;
import entidades.Vehiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
public class AutomovilDAO implements IAutomovilDAO {

    @Override
    public Automovil agregar(Automovil automovil) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        Automovil autoNuevo = automovil;

        em.getTransaction().begin();
        em.persist(autoNuevo);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return autoNuevo;
    }

    @Override
    public Automovil consultarPorSerie(Automovil automovil) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            TypedQuery<Automovil> query = em.createQuery("Select a from Automovil a where a.serie = :serie",
                    Automovil.class);
            query.setParameter("serie", automovil.getSerie());
            automovil = query.getSingleResult();
            em.getTransaction().commit();
            return automovil;
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
    public Vehiculo consultarVehiculoPorSerie(Vehiculo vehiculo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            TypedQuery<Vehiculo> query = em.createQuery("SELECT v FROM Vehiculo v WHERE v.serie = :serie", Vehiculo.class);
            query.setParameter("serie", vehiculo.getSerie());
            vehiculo = query.getSingleResult();
            em.getTransaction().commit();
            return vehiculo;
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

   

//    public Vehiculo consultarVehiculoPorSerie(Vehiculo vehiculo) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            TypedQuery<Vehiculo> query = em.createQuery("Select v from Vehiculo v where v.serie = :serie", 
//                    Vehiculo.class);
//            query.setParameter("serie", vehiculo.getSerie());
//            vehiculo = query.getSingleResult();
//            em.getTransaction().commit();
//            return vehiculo;
//        } catch (NoResultException e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            return null;
//        } finally {
//            em.close();
//            emf.close();
//        }
//    }
//    public Vehiculo consultarVehiculoPorSerie(Vehiculo vehiculo) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            TypedQuery<Vehiculo> query = em.createQuery("Select v from Vehiculo v where v.serie = :serie and TYPE(v) = Vehiculo", Vehiculo.class);
//            query.setParameter("serie", vehiculo.getSerie());
//            Vehiculo vehiculoConsultado = query.getSingleResult();
//            em.getTransaction().commit();
//            return vehiculoConsultado;
//        } catch (NoResultException e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//
//            }
//            return null;
//        } finally {
//            em.close();
//            emf.close();
//
//        }
//
//    }
    @Override
    public boolean esPrimeraVez(Automovil automovil) {

        Automovil automovilConsultado = this.consultarPorSerie(automovil);
        if (automovilConsultado.getSerie() != null) {
            return false;

        } else {
            return true;
        }
    }

}
