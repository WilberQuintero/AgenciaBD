/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.agenciapersistencia;

import DAO.LicenciaDAO;
import DAO.PersonaDAO;
import DAO.PlacaDAO;
import DAO.AutomovilDAO;
import entidades.Automovil;
import entidades.Estado;
import entidades.Licencia;
import entidades.Persona;
import entidades.Placa;
import entidades.TipoLicencia;
import entidades.Vehiculo;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author Wilber
 */
public class AgenciaPersistencia {

    public static void main(String[] args) {
        
        Calendar fecha = Calendar.getInstance();
        PersonaDAO p = new PersonaDAO();
        PlacaDAO pla = new PlacaDAO();
        Persona per = new Persona("GOSJ880615123");
        //("Juan", "Sánchez", "González", fecha, "5551234567", "GOSJ880615123", "GOSJ880615HDFNDR09", true);
        Persona perso = p.obtenerPersonaPorRFC(per);
        
        AutomovilDAO v = new AutomovilDAO();
        Automovil auto = new  Automovil(4, 4, "Jeep", "Cherokee", "123456789uytresc", "Rojo", 2004, perso);
        Vehiculo vehicu = new Vehiculo("123456789uytresc");
        //Vehiculo vehiculo = v.consultarVehiculoPorSerie(vehicu);
        
        
        Placa placaBuscada = new Placa("UXI-594");
        Placa buena = pla.consultarPorNumPlaca(placaBuscada);
        Automovil carro = v.consultarPorSerie(auto);
        Persona persona1 = carro.getPersona();
        
//        Placa placa = new Placa("GRD-347", Estado.VIGENTE, persona1.getDiscapacitado(),
//                null, Boolean.FALSE, vehiculo, 1000F, persona1);
        System.out.println("Es primera vez: " + v.esPrimeraVez(carro));
        //System.out.println("Costo: " + pla.agregar(placa));
        //System.out.println("Placa: " + pla.consultarPorNumPlaca(placa));
        Vehiculo vehiculo = (Vehiculo) v.consultarVehiculoPorSerie(vehicu);
        System.out.println("Vehiculo: " + vehiculo );
        
        //pla.consultarPorId(placa);
//        System.out.println(buena);
//        System.out.println("por id: " + pla.consultarPorId(placaBuscada));
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//        EntityManager em = emf.createEntityManager();
//        
//        buena.setEstado(Estado.VIGENTE);
//        em.getTransaction().begin();
//        em.merge(buena);
//        em.getTransaction().commit();
        
//        pla.consultarPorNumPlaca(placa);
//        
        
        //System.out.println(pla.entregar(placaBuscada));
        
        //pla.desactivar(buena);
        
        
        
//        pla.agregar(placa);

        
        //v.agregar(auto);
        
        //Licencia y persona
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//        EntityManager em = emf.createEntityManager();
//        PersonaDAO p = new PersonaDAO();
//        LicenciaDAO l = new LicenciaDAO();
//        Calendar fecha = Calendar.getInstance();
//        fecha.set(1988, Calendar.JUNE, 15);
//        Persona per = new Persona("Juan", "Sánchez", "González", fecha, "5551234567", "GOSJ880615123", "GOSJ880615HDFNDR09", true);
//        Persona perso = p.obtenerPersonaPorRFC(per);
//        Licencia lic = new Licencia(1, 1300F, TipoLicencia.AUTOMOVIL,perso);
//        Licencia lic2 = new Licencia(2, 2300F, TipoLicencia.AUTOMOVIL,perso);
//        Licencia lic3 = new Licencia(3, 3000F, TipoLicencia.AUTOMOVIL,perso);
//        Licencia lice = new Licencia("XQTYjFr25p");
//        Licencia lic4 = l.consultarPorFolio(new Licencia("huLroXGSVG"));
//        lic4.setFechaVigencia(fecha);
//        em.getTransaction().begin();
//        em.merge(lic4);
//        em.getTransaction().commit();
////        l.desactivar(lic4);
////        System.out.println(l.consultarPorFolio(new Licencia("XQTYjFr25p")));
//        //System.out.println(l.consultarLicenciasPersona(perso));
//        //p.incercionMasiva();
//        
////        em.getTransaction().begin();
////        p.agregarPersonas();
////        em.getTransaction().commit();
////        
////        em.close();
////        emf.close();

        
    }
}
