
package com.mycompany.agencianegocio;

import DAO.PersonaDAO;
import DAO.PlacaDAO;
import bo.ConsultasBO;
import bo.RegistroLicenciasBO;
import dto.LicenciaDTO;
import dto.PersonaDTO;
import dto.PlacaDTO;
import entidades.Licencia;
import entidades.Persona;
import entidades.TipoLicencia;
import java.util.List;

/**
 *
 * @author Wilber
 */

public class AgenciaNegocio {

    public static void main(String[] args) {
        
         PersonaDAO personaDAO = new PersonaDAO();
         ConsultasBO consultas = new ConsultasBO();
        // Supongamos que tienes un nombre, apellido paterno y apellido materno válidos para probar
        String nombre = "Juan";
        String apellidoPaterno = "González";
        String apellidoMaterno = "";

        List<LicenciaDTO> historialLicencias = consultas.obtenerHistorialLicenciasNombre(nombre, apellidoPaterno, apellidoMaterno);
        // Mostramos el historial de licencias
        for (LicenciaDTO licenciaDTO : historialLicencias) {
            System.out.println(licenciaDTO);
        }
    }
        
    }

       
    

