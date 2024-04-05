package DAO;

import entidades.Licencia;
import entidades.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Wilber
 */
public class PersonaDAO implements IPersonaDAO {

    private CriteriaBuilder cb;

    public PersonaDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        cb = em.getCriteriaBuilder();
    }

    @Override
    public Persona obtenerPersona(Persona persona) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Persona> criteria = cb.createQuery(Persona.class);
            Root<Persona> root = criteria.from(Persona.class);

            Predicate predicate = cb.equal(root.get("rfc"), persona.getRfc());
            criteria.select(root).where(predicate);

            TypedQuery<Persona> query = em.createQuery(criteria);

            Persona personaConsultada = query.getSingleResult();
            em.getTransaction().commit();
            return personaConsultada;
        } catch (NoResultException e) {
            // No se encontró ninguna persona con el RFC proporcionado
            return null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Deshacer la transacción si aún está activa
            }
            em.close(); // Cerrar EntityManager
            emf.close(); // Cerrar EntityManagerFactory
        }
    }

    @Override
    public Persona obtenerPersonaPorRFC(Persona persona) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        Persona perso = null;
        String rfc = persona.getRfc();
        try {
            em.getTransaction().begin();
            TypedQuery<Persona> query = em.createQuery("Select p from Persona p where p.rfc = :rfc", Persona.class);
            query.setParameter("rfc", rfc);
            perso = query.getSingleResult();
            em.getTransaction().commit();
        } catch (NoResultException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
        return perso;
    }

    @Override
    public Persona obtenerPersonaPorCURP(Persona persona) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        Persona perso = null;
        String curp = persona.getRfc();
        try {
            em.getTransaction().begin();
            TypedQuery<Persona> query = em.createQuery("Select p from Persona p where p.curp = :curp", Persona.class);
            query.setParameter("curp", curp);
            perso = query.getSingleResult();
            em.getTransaction().commit();
        } catch (NoResultException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
        return perso;
    }

    @Override
   public List<Persona> buscarPersonasPorNombre(String nombre, String apellidoP, String apellidoM) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
    EntityManager em = emf.createEntityManager();

    try {
        em.getTransaction().begin();
        String query = "SELECT p FROM Persona p WHERE "
                + "LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')) "
                + "AND LOWER(p.apellidoP) LIKE LOWER(CONCAT('%', :apellidoP, '%')) "
                + "AND LOWER(p.apellidoM) LIKE LOWER(CONCAT('%', :apellidoM, '%'))";

        TypedQuery<Persona> typedQuery = em.createQuery(query, Persona.class);
        typedQuery.setParameter("nombre", nombre);
        typedQuery.setParameter("apellidoP", apellidoP);
        typedQuery.setParameter("apellidoM", apellidoM);

        List<Persona> personasConsultadas = typedQuery.getResultList();
        em.getTransaction().commit();
        return personasConsultadas;
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
    public List<Persona> buscarPersonasPorAnioNacimiento(int anioNacimiento) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
    EntityManager em = emf.createEntityManager();

    try {
        em.getTransaction().begin();
        String query = "SELECT p FROM Persona p WHERE EXTRACT(YEAR FROM p.fechaNac) = :anioNacimiento";
        TypedQuery<Persona> typedQuery = em.createQuery(query, Persona.class);
        typedQuery.setParameter("anioNacimiento", anioNacimiento);
        List<Persona> personasConsultadas = typedQuery.getResultList();
        em.getTransaction().commit();
        return personasConsultadas;
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
    public void incercionMasiva() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        String incercion = "insert into personas (nombre, apellido_paterno, apellido_materno, fecha_nacimiento, telefono, rfc, curp, discapacitado) values\n"
                + "			('Juan', 'González', 'Sánchez', '1988-06-15','5551234567','GOSJ880615123', 'GOSJ880615HDFNDR09', true),\n"
                + "			('María', 'Rodríguez', 'Pérez', '1995-03-25','5559876543','ROPM950325987', 'ROPM950325MDFDRR07', false),\n"
                + "			('Carlos', 'López', 'García', '1980-11-10','5552345678','LOGC801110234', 'LOGC801110HDFPRS05', false),\n"
                + "			('Ana', 'Martínez', 'Hernández', '1976-09-03', '5558765432','MAHA760903876', 'MAHA760903MDFTRN02', false),\n"
                + "			('José', 'García', 'Martínez', '1990-07-20','5553456789','GAMJ900720345', 'GAMJ900720HDFRJS08', false),\n"
                + "			('Laura', 'Díaz', 'Sánchez', '1983-04-12','5556543210','DISL830412654', 'DISL830412MDFZLR00', true),\n"
                + "			('Manuel', 'Reyes', 'Rodríguez', '1979-02-05','5554567890','RERM790205456', 'RERM790205HDFYLJ08', true),\n"
                + "			('Gabriela', 'Cruz', 'Ramírez5', '1985-10-18','5557890123', 'CURR851018789', 'CURR851018MDFZBG00', false),\n"
                + "			('Miguel', 'Flores', 'González', '1992-12-30','5558901234','FOGM921230890', 'FOGM921230HDFLGL03', false),\n"
                + "			('Patricia', 'Ortizo', 'López', '1987-07-08','5559012345','LOLP870708901', 'LOLP870708MDFRTT05', false),\n"
                + "                     ('Daniel', 'Hernández', 'Martínez', '1993-09-15', '5551112233', 'HEMA930915111', 'HEMA930915HDFDNL08', true),\n"
                + "			('Sofía', 'Gómez', 'Pérez', '1986-05-20', '5552223344', 'GOPP860520222', 'GOPP860520MDFSPG02', false),\n"
                + "			('Javier', 'Sánchez', 'González', '1975-03-10', '5553334455', 'SAGJ750310333', 'SAGJ750310HDFJVR09', false),\n"
                + "			('Elena', 'García', 'Fernández', '1982-12-05', '5554445566', 'GAFE821205444', 'GAFE821205MDFGRN07', false),\n"
                + "			('Francisco', 'Martínez', 'López', '1991-08-25', '5555556677', 'MALF910825555', 'MALF910825HDFLPM01', true),\n"
                + "			('Carmen', 'Rodríguez', 'Sánchez', '1980-04-03', '5556667788', 'ROSC800403666', 'ROSC800403MDFCNM06', true),\n"
                + "			('Diego', 'Pérez', 'González', '1977-01-20', '5557778899', 'PEGD770120777', 'PEGD770120HDFZPD03', false),\n"
                + "			('Isabel', 'Fernández', 'López', '1988-11-10', '5558889900', 'FELI881110888', 'FELI881110MDFRZL08', false),\n"
                + "			('Alejandro', 'González', 'Martínez', '1994-07-15', '5559990011', 'GOMA940715999', 'GOMA940715HDFGLJ05', false),\n"
                + "			('Paula', 'López', 'Gómez', '1981-06-08', '5550001122', 'LOGP810608000', 'LOGP810608MDFLPG09', false);";

        try {
            em.getTransaction().begin();
            em.createNativeQuery(incercion).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public Licencia consultarUltimaLicenciaPersona(Persona persona) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            TypedQuery<Licencia> query = em.createQuery(
                    "SELECT l FROM Licencia l JOIN l.persona p WHERE p = :persona  order by l.id desc ",
                    Licencia.class
            );

            query.setParameter("persona", persona);
            query.setMaxResults(1);
            Licencia licencia = query.getSingleResult();

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

}
