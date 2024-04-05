/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DAO.IPersonaDAO;
import DAO.IPlacaDAO;
import DAO.IAutomovilDAO;
import DAO.PersonaDAO;
import DAO.PlacaDAO;
import DAO.AutomovilDAO;
import dto.PersonaDTO;
import dto.PlacaDTO;
import entidades.Automovil;
import entidades.Persona;
import entidades.Placa;
import entidades.Vehiculo;
import guardado.General;
import guardado.Transferencia;
import iBo.IRegistroPlacasBO;

/**
 *
 * @author Usuario
 */
public class RegistroPlacasBO implements IRegistroPlacasBO {

    private IPersonaDAO personaDAO;
    private IPlacaDAO placaDAO;
    private IAutomovilDAO automovilDAO;
    private Transferencia datos;
    private int boton = 0;

    public RegistroPlacasBO() {
        personaDAO = new PersonaDAO();
        placaDAO = new PlacaDAO();
        automovilDAO = new AutomovilDAO();
        datos = General.transferencia;

    }

    private PlacaDTO convertirEntidadADTO(Placa placa) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre(placa.getPersona().getNombre());
        personaDTO.setApellidoP(placa.getPersona().getApellidoP());
        personaDTO.setApellidoM(placa.getPersona().getApellidoM());
        personaDTO.setFechaNac(placa.getPersona().getFechaNac());
        personaDTO.setTelefono(placa.getPersona().getTelefono());
        personaDTO.setRfc(placa.getPersona().getRfc());
        personaDTO.setCurp(placa.getPersona().getCurp());
        personaDTO.setDiscapacitado(placa.getPersona().getDiscapacitado());

        PlacaDTO placaDTO = new PlacaDTO();

        placaDTO.setNumPlaca(placa.getNumPlaca());
        placaDTO.setEstado(placa.getEstado());
        placaDTO.setDiscapacitado(placa.getDiscapacitado());
        placaDTO.setEntrego(placa.getEntrego());
        placaDTO.setCosto(placa.getCosto());
        placaDTO.setPersona(personaDTO);

        return placaDTO;
    }

    private Placa convertirDTOAEntidad(PlacaDTO placaDTO) {
        Persona persona = null;
        if (placaDTO.getPersona() != null) {
            Persona per = new Persona();
            persona.setNombre(placaDTO.getPersona().getNombre());
            persona.setApellidoP(placaDTO.getPersona().getApellidoP());
            persona.setApellidoM(placaDTO.getPersona().getApellidoM());
            persona.setFechaNac(placaDTO.getPersona().getFechaNac());
            persona.setTelefono(placaDTO.getPersona().getTelefono());
            persona.setRfc(placaDTO.getPersona().getRfc());
            persona.setCurp(placaDTO.getPersona().getCurp());
            persona.setDiscapacitado(placaDTO.getPersona().getDiscapacitado());

        } else {
            Persona per = new Persona("1");
            persona = per;
        }

        Placa placa = new Placa();
        placa.setNumPlaca(placaDTO.getNumPlaca());
        placa.setEstado(placaDTO.getEstado());
        placa.setDiscapacitado(placaDTO.isDiscapacitado());
        placa.setEntrego(placaDTO.isEntrego());
        placa.setCosto(placaDTO.getCosto());
        placa.setFechaExpedicion(placaDTO.getFechaEntrega());
        placa.setPersona(persona);

        return placa;
    }

    public Persona convertirDTOAEntidad(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellidoP(personaDTO.getApellidoP());
        persona.setApellidoM(personaDTO.getApellidoM());
        persona.setFechaNac(personaDTO.getFechaNac());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setRfc(personaDTO.getRfc());
        persona.setCurp(personaDTO.getCurp());
        persona.setDiscapacitado(personaDTO.getDiscapacitado());

        return persona;
    }

    public PersonaDTO convertirEntidadADTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setApellidoP(persona.getApellidoP());
        personaDTO.setApellidoM(persona.getApellidoM());
        personaDTO.setFechaNac(persona.getFechaNac());
        personaDTO.setTelefono(persona.getTelefono());
        personaDTO.setRfc(persona.getRfc());
        personaDTO.setCurp(persona.getCurp());
        personaDTO.setDiscapacitado(persona.getDiscapacitado());

        return personaDTO;
    }

    public Persona obtenerPersonaEnt(PersonaDTO personaDTO) {
        Persona persona = this.convertirDTOAEntidad(personaDTO);
        Persona personaBuscada = personaDAO.obtenerPersonaPorRFC(persona);
        return personaBuscada;
    }

    public PersonaDTO obtenerPersonaDTO(PersonaDTO personaDTO) {
        Persona personaBuscada = this.obtenerPersonaEnt(personaDTO);
        PersonaDTO personaConver = this.convertirEntidadADTO(personaBuscada);
        return personaConver;
    }

    public PlacaDTO obtenerPlacaDTO(PlacaDTO placaDTO) {
        Placa placaBuscada = this.obtenerPlacaEnt(placaDTO);
        PlacaDTO placaConver = this.convertirEntidadADTO(placaBuscada);
        return placaConver;
    }

    public Placa obtenerPlacaEnt(PlacaDTO placaDTO) {
        Placa placa = this.convertirDTOAEntidad(placaDTO);
        Placa placaBuscada = placaDAO.consultarPorNumPlaca(placa);
        return placaBuscada;

    }

    @Override
    public PlacaDTO registrarPlaca(PlacaDTO placaDTO, PersonaDTO personaDTO) {

        Persona personaBuscada = this.obtenerPersonaEnt(personaDTO);
        if (personaBuscada == null) {
            return null;
        }
       
        Placa nuevaPlaca = new Placa(placaDTO.getNumPlaca(), placaDTO.isDiscapacitado(), placaDTO.isEntrego(),
                placaDTO.getVehiculo(), this.calcularCostoPlaca(placaDTO), personaBuscada);
        Placa placaRegistrada = placaDAO.agregar(nuevaPlaca);
        return convertirEntidadADTO(placaRegistrada);

    }

    public Float calcularCostoPlaca(PlacaDTO placaDTO) {
        Float costo;
        Placa placa = new Placa(placaDTO.getNumPlaca());
        Placa placaBuscada = placaDAO.consultarPorNumPlaca(placa);
        
        Automovil auto = new Automovil(placaBuscada.getVehiculo().getSerie());
        Automovil autoBuscado = automovilDAO.consultarPorSerie(auto);
        boolean esPrimeraVez = automovilDAO.esPrimeraVez(autoBuscado);

        if (esPrimeraVez) {
            costo = 1500.0f; // Primera vez
        } else {
            costo = 1000.0f; // Renovación
        }

        return costo;
    }

    @Override
    public Transferencia getDatos() {
        return datos;
    }

    @Override
    public void datosGuardadosANull() {
        datos.setBoton(0);
        datos.setPersonaDTO(null);
        datos.setVehiculoDTO(null);
        datos.setPlacaDTO(null);
    }

    @Override
    public PlacaDTO desactivarPlaca(PlacaDTO placaDTO) {
        Placa placa = this.obtenerPlacaEnt(placaDTO);
        placaDAO.desactivar(placa);
        return this.convertirEntidadADTO(placa);
    }
    
    @Override
    public PlacaDTO entregar(PlacaDTO placaDTO){
        Placa placa = this.obtenerPlacaEnt(placaDTO);
        placaDAO.entregar(placa);
        return this.convertirEntidadADTO(placa);
        
    }

}
