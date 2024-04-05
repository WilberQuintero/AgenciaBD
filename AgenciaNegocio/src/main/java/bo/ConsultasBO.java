package bo;

import DAO.ILicenciaDAO;
import DAO.IPersonaDAO;
import DAO.IPlacaDAO;
import DAO.LicenciaDAO;
import DAO.PersonaDAO;
import DAO.PlacaDAO;
import dto.LicenciaDTO;
import dto.PersonaDTO;
import dto.PlacaDTO;
import entidades.Licencia;
import entidades.Persona;
import entidades.Placa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wilber
 */
public class ConsultasBO {

    private IPersonaDAO personaDAO;
    private ILicenciaDAO licenciaDAO;
    private IPlacaDAO placaDAO;

    public ConsultasBO() {
        personaDAO = new PersonaDAO();
        licenciaDAO = new LicenciaDAO();
        placaDAO = new PlacaDAO();
    }

    public List<LicenciaDTO> obtenerHistorialLicenciasAnioNacimiento(int anioNacimiento) {
        List<Persona> personas = personaDAO.buscarPersonasPorAnioNacimiento(anioNacimiento);
        List<LicenciaDTO> licenciasDTOs = new ArrayList<>();

        for (Persona persona : personas) {
            LicenciaDAO licenciaDAO = new LicenciaDAO();
            List<Licencia> licencias = licenciaDAO.consultarLicenciasPersona(persona);
            for (Licencia licencia : licencias) {
                LicenciaDTO licenciaDTO = new LicenciaDTO(
                    licencia.getFolio(),
                    licencia.getEstado(),
                    licencia.getAnios(),
                    licencia.getFechaVigencia(),
                    licencia.getTipo(),
                    licencia.getCosto(),
                    new PersonaDTO(persona)
                );
                licenciasDTOs.add(licenciaDTO);
            }
        }

        return licenciasDTOs;
    }
    
    public List<LicenciaDTO> obtenerHistorialLicenciasPorCURP(String curp) {
        Persona persona = personaDAO.obtenerPersonaPorCURP(new Persona(curp));
        List<LicenciaDTO> licenciasDTOs = new ArrayList<>();

        if (persona != null) {
            LicenciaDAO licenciaDAO = new LicenciaDAO();
            List<Licencia> licencias = licenciaDAO.consultarLicenciasPersona(persona);
            for (Licencia licencia : licencias) {
                LicenciaDTO licenciaDTO = new LicenciaDTO(
                    licencia.getFolio(),
                    licencia.getEstado(),
                    licencia.getAnios(),
                    licencia.getFechaVigencia(),
                    licencia.getTipo(),
                    licencia.getCosto(),
                    new PersonaDTO(persona)
                );
                licenciasDTOs.add(licenciaDTO);
            }
        }

        return licenciasDTOs;
    }
    
    public List<LicenciaDTO> obtenerHistorialLicenciasNombre(String nombre, String apellidoP, String apellidoM) {
    List<Persona> personas = personaDAO.buscarPersonasPorNombre(nombre, apellidoP, apellidoM);
    List<LicenciaDTO> licenciasDTOs = new ArrayList<>();

    for (Persona persona : personas) {
        LicenciaDAO licenciaDAO = new LicenciaDAO();
        List<Licencia> licencias = licenciaDAO.consultarLicenciasPersona(persona);
        for (Licencia licencia : licencias) {
            LicenciaDTO licenciaDTO = new LicenciaDTO(
                licencia.getFolio(),
                licencia.getEstado(),
                licencia.getAnios(),
                licencia.getFechaVigencia(),
                licencia.getTipo(),
                licencia.getCosto(),
                new PersonaDTO(persona)
            );
            licenciasDTOs.add(licenciaDTO);
        }
    }

    return licenciasDTOs;
}
    
    
     public List<PlacaDTO> obtenerHistorialPlacasAnioNacimiento(int anioNacimiento) {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas = personaDAO.buscarPersonasPorAnioNacimiento(anioNacimiento);
        List<PlacaDTO> placasDTOs = new ArrayList<>();

        for (Persona persona : personas) {
            PlacaDAO placaDAO = new PlacaDAO();
            List<Placa> placas = placaDAO.consultarPlacasPersona(persona);
            for (Placa placa : placas) {
                PlacaDTO placaDTO = new PlacaDTO(
                    placa.getNumPlaca(),
                    placa.getEstado(),
                    placa.getDiscapacitado(),
                    placa.getEntrego(),
                    placa.getVehiculo(),
                    placa.getCosto(),
                    new PersonaDTO(persona)
                );
                placasDTOs.add(placaDTO);
            }
        }

        return placasDTOs;
    }
     
     public List<PlacaDTO> obtenerHistorialPlacasPorCURP(String curp) {
        Persona persona = personaDAO.obtenerPersonaPorCURP(new Persona(curp));
        List<PlacaDTO> placasDTOs = new ArrayList<>();

        if (persona != null) {
            PlacaDAO placaDAO = new PlacaDAO();
            List<Placa> placas = placaDAO.consultarPlacasPersona(persona);
            for (Placa placa : placas) {
                PlacaDTO placaDTO = new PlacaDTO(
                    placa.getNumPlaca(),
                    placa.getEstado(),
                    placa.getDiscapacitado(),
                    placa.getEntrego(),
                    placa.getVehiculo(),
                    placa.getCosto(),
                    new PersonaDTO(persona)
                );
                placasDTOs.add(placaDTO);
            }
        }

        return placasDTOs;
    }
    
    public List<PlacaDTO> obtenerHistorialPlacasNombre(String nombre, String apellidoP, String apellidoM) {
    List<Persona> personas = personaDAO.buscarPersonasPorNombre(nombre, apellidoP, apellidoM);
    List<PlacaDTO> placasDTOs = new ArrayList<>();

    for (Persona persona : personas) {
        PlacaDAO placaDAO = new PlacaDAO();
        List<Placa> placas = placaDAO.consultarPlacasPersona(persona);
        for (Placa placa : placas) {
            PlacaDTO placaDTO = new PlacaDTO(
                placa.getNumPlaca(),
                placa.getEstado(),
                placa.getDiscapacitado(),
                placa.getEntrego(),
                placa.getVehiculo(),
                placa.getCosto(),
                new PersonaDTO(persona)
            );
            placasDTOs.add(placaDTO);
        }
    }

    return placasDTOs;
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public List<LicenciaDTO> obtenerHistorialLicenciasPersona(PersonaDTO personaDTO) {
//        Persona persona = new Persona();
//        persona.setRfc(personaDTO.getRfc());
//        List<Licencia> licencias = licenciaDAO.consultarLicenciasPersona(persona);
//
//        List<LicenciaDTO> licenciasDTO = new ArrayList<>();
//        for (Licencia licencia : licencias) {
//            LicenciaDTO licenciaDTO = new LicenciaDTO(
//                    licencia.getFolio(),
//                    licencia.getEstado(),
//                    licencia.getAnios(),
//                    licencia.getFechaVigencia(),
//                    licencia.getTipo(),
//                    licencia.getCosto(),
//                    new PersonaDTO(persona)
//            );
//            licenciasDTO.add(licenciaDTO);
//        }
//
//        return licenciasDTO;
//    }
//
    public List<PlacaDTO> obtenerHistorialPlacasPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setRfc(personaDTO.getRfc());
        List<Placa> placas = placaDAO.consultarPlacasPersona(persona);

        List<PlacaDTO> placasDTO = new ArrayList<>();
        for (Placa placa : placas) {
            PlacaDTO placaDTO = new PlacaDTO(
                    placa.getNumPlaca(),
                    placa.getEstado(),
                    placa.getDiscapacitado(),
                    placa.getEntrego(),
                    placa.getVehiculo(),
                    placa.getCosto(),
                    new PersonaDTO(persona)
            );
            placasDTO.add(placaDTO);
        }

        return placasDTO;
    }
    
//    public List<PlacaDTO> obtenerPlacasPorCURP(String curp) {
//    Persona persona = personaDAO.obtenerPersonaPorCURP(new Persona(curp));
//    List<Placa> placas = placaDAO.consultarPlacasPersona(persona);
//
//    List<PlacaDTO> placasDTO = new ArrayList<>();
//    for (Placa placa : placas) {
//        PlacaDTO placaDTO = new PlacaDTO(
//                placa.getNumPlaca(),
//                placa.getEstado(),
//                placa.getDiscapacitado(),
//                placa.getEntrego(),
//                placa.getVehiculo(),
//                placa.getCosto(),
//                new PersonaDTO(persona)
//        );
//        placasDTO.add(placaDTO);
//    }
//
//    return placasDTO;
//}
//    
//public List<PlacaDTO> obtenerPlacasPorNombre(String nombre) {
//    Persona personaBuscada = new Persona();
//    personaBuscada.setNombre(nombre);
//    List<Persona> personas = personaDAO.buscarPersonasPorNombre(personaBuscada);
//    List<PlacaDTO> placasDTO = new ArrayList<>();
//
//    for (Persona persona : personas) {
//        List<Placa> placas = placaDAO.consultarPlacasPersona(persona);
//        for (Placa placa : placas) {
//            PlacaDTO placaDTO = new PlacaDTO(
//                    placa.getNumPlaca(),
//                    placa.getEstado(),
//                    placa.getDiscapacitado(),
//                    placa.getEntrego(),
//                    placa.getVehiculo(),
//                    placa.getCosto(),
//                    new PersonaDTO(persona)
//            );
//            placasDTO.add(placaDTO);
//        }
//    }
//
//    return placasDTO;
//}   
    
    
    













//    public List<PersonaDTO> buscarPersonasPorCURP(String curp) {
//        Persona persona = new Persona();
//        persona.setCurp(curp);
//        Persona personaConsultada = personaDAO.obtenerPersonaPorCURP(persona);
//
//        List<PersonaDTO> personasDTO = new ArrayList<>();
//        if (personaConsultada != null) {
//            PersonaDTO personaDTO = new PersonaDTO(
//                    personaConsultada.getNombre(),
//                    personaConsultada.getApellidoP(),
//                    personaConsultada.getApellidoM(),
//                    personaConsultada.getFechaNac(),
//                    personaConsultada.getTelefono(),
//                    personaConsultada.getRfc(),
//                    personaConsultada.getCurp(),
//                    personaConsultada.getDiscapacitado()
//            );
//            personasDTO.add(personaDTO);
//        }
//
//        return personasDTO;
//    }
    
    
    

//    public List<PersonaDTO> buscarPersonasPorNombre(String nombre) {
//        Persona persona = new Persona();
//        persona.setNombre(nombre);
//        List<Persona> personas = personaDAO.buscarPersonasPorNombre(persona);
//        List<PersonaDTO> personasDTO = new ArrayList<>();
//
//        for (Persona p : personas) {
//            PersonaDTO personaDTO = new PersonaDTO(
//                    p.getNombre(),
//                    p.getApellidoP(),
//                    p.getApellidoM(),
//                    p.getFechaNac(),
//                    p.getTelefono(),
//                    p.getRfc(),
//                    p.getCurp(),
//                    p.getDiscapacitado()
//            );
//            personasDTO.add(personaDTO);
//        }
//
//        return personasDTO;
//    }
//
//    public List<PersonaDTO> buscarPersonasPorAnioNacimiento(int anioNacimiento) {
//        List<Persona> personas = personaDAO.buscarPersonasPorAnioNacimiento(anioNacimiento);
//        List<PersonaDTO> personasDTO = new ArrayList<>();
//
//        for (Persona persona : personas) {
//            PersonaDTO personaDTO = new PersonaDTO(
//                    persona.getNombre(),
//                    persona.getApellidoP(),
//                    persona.getApellidoM(),
//                    persona.getFechaNac(),
//                    persona.getTelefono(),
//                    persona.getRfc(),
//                    persona.getCurp(),
//                    persona.getDiscapacitado()
//            );
//            personasDTO.add(personaDTO);
//        }
//
//        return personasDTO;
//    }
    
    
    

}
