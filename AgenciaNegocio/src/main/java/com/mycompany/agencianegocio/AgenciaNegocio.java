
package com.mycompany.agencianegocio;

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
        
         ConsultasBO consultasBO = new ConsultasBO(); // Suponiendo que ConsultasBO es la clase que contiene el método obtenerHistorialLicenciasAnioNacimiento
        
        // Supongamos que deseas obtener el historial de licencias para personas nacidas en el año 1990
        int anioNacimiento = 1988;
        
        // Llama al método para obtener el historial de licencias por año de nacimiento
        List<LicenciaDTO> licenciasPorAnio = consultasBO.obtenerHistorialLicenciasAnioNacimiento(anioNacimiento);
        
        // Verifica si se encontraron licencias y muestra la información
        if (licenciasPorAnio != null && !licenciasPorAnio.isEmpty()) {
            System.out.println("Historial de licencias para personas nacidas en el año " + anioNacimiento + ":");
            for (LicenciaDTO licenciaDTO : licenciasPorAnio) {
                System.out.println("Folio: " + licenciaDTO.getFolio() + ", Estado: " + licenciaDTO.getEstado() + ", Tipo: " + licenciaDTO.getTipo());
                System.out.println("Fecha de Vigencia: " + licenciaDTO.getFechaVigencia() + ", Costo: " + licenciaDTO.getCosto());
                System.out.println("Persona: " + licenciaDTO.getPersona().getNombre() + " " +licenciaDTO.getPersona().getApellidoP() + " " +licenciaDTO.getPersona().getApellidoM());
                System.out.println("---------------------------------------");
            }
        } else {
            System.out.println("No se encontraron licencias para personas nacidas en el año " + anioNacimiento);
        }

       }  
    }

