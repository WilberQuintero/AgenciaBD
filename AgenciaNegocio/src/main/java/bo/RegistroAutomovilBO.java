package bo;

import DAO.IPersonaDAO;
import DAO.IPlacaDAO;
import DAO.IAutomovilDAO;
import DAO.PersonaDAO;
import DAO.PlacaDAO;
import DAO.AutomovilDAO;
import dto.AutomovilDTO;
import dto.LicenciaDTO;
import dto.PersonaDTO;
import dto.VehiculoDTO;
import entidades.Automovil;
import entidades.Licencia;
import entidades.Persona;
import entidades.Vehiculo;
import guardado.General;
import guardado.Transferencia;
import iBo.IRegistroAutomovilBO;

/**
 *
 * @author Wilber
 */
public class RegistroAutomovilBO implements IRegistroAutomovilBO {

    private IPersonaDAO personaDAO;
    private IAutomovilDAO automovilDAO;
    private Transferencia datos;

    public RegistroAutomovilBO() {
        personaDAO = new PersonaDAO();
        automovilDAO = new AutomovilDAO();
        datos = General.transferencia;

    }

    @Override
    public Transferencia getDatos() {
        return datos;
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

    public Vehiculo convertirDTOAEntidad(VehiculoDTO vehiculoDTO) {
        Persona persona = null;
        if(vehiculoDTO.getPersonaDTO() != null){
            Persona per = new Persona();
        PersonaDTO personaDTO = vehiculoDTO.getPersonaDTO();
        per.setNombre(personaDTO.getNombre());
        per.setApellidoP(personaDTO.getApellidoP());
        per.setApellidoM(personaDTO.getApellidoM());
        per.setFechaNac(personaDTO.getFechaNac());
        per.setTelefono(personaDTO.getTelefono());
        per.setRfc(personaDTO.getRfc());
        per.setCurp(personaDTO.getCurp());
        per.setDiscapacitado(personaDTO.getDiscapacitado());
        persona = per;
            
        }
        else{
            Persona per = new Persona("1");
            persona = per;
        }
        
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setSerie(vehiculoDTO.getSerie());
        vehiculo.setColor(vehiculoDTO.getColor());
        vehiculo.setLinea(vehiculoDTO.getLinea());
        vehiculo.setMarca(vehiculoDTO.getMarca());
        vehiculo.setModelo(vehiculoDTO.getModelo());     
        vehiculo.setPersona(persona);
      
        return vehiculo;
    }

    public VehiculoDTO convertirEntidadADTO(Vehiculo vehiculo) {

        if (vehiculo != null && vehiculo.getPersona() != null) {
            Persona persona = vehiculo.getPersona();
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setNombre(persona.getNombre());
            personaDTO.setApellidoP(persona.getApellidoP());
            personaDTO.setApellidoM(persona.getApellidoM());
            personaDTO.setFechaNac(persona.getFechaNac());
            personaDTO.setTelefono(persona.getTelefono());
            personaDTO.setRfc(persona.getRfc());
            personaDTO.setCurp(persona.getCurp());
            personaDTO.setDiscapacitado(persona.getDiscapacitado());

            VehiculoDTO vehiculoDTO = new VehiculoDTO();

            vehiculoDTO.setSerie(vehiculo.getSerie());
            vehiculoDTO.setColor(vehiculo.getColor());
            vehiculoDTO.setLinea(vehiculo.getLinea());
            vehiculoDTO.setMarca(vehiculo.getMarca());
            vehiculoDTO.setModelo(vehiculo.getModelo());
            vehiculoDTO.setPersonaDTO(personaDTO);

            return vehiculoDTO;
        }
        return null;
    }

    public Automovil convertirDTOAEntidad(AutomovilDTO automovilDTO) {
        Persona persona = null;
        if(automovilDTO.getPersonaDTO() != null){
            Persona per = new Persona();
        PersonaDTO personaDTO = automovilDTO.getPersonaDTO();
        per.setNombre(personaDTO.getNombre());
        per.setApellidoP(personaDTO.getApellidoP());
        per.setApellidoM(personaDTO.getApellidoM());
        per.setFechaNac(personaDTO.getFechaNac());
        per.setTelefono(personaDTO.getTelefono());
        per.setRfc(personaDTO.getRfc());
        per.setCurp(personaDTO.getCurp());
        per.setDiscapacitado(personaDTO.getDiscapacitado());
        persona = per;
            
        }
        else{
            Persona per = new Persona("1");
            persona = per;
        }
        
        Automovil automovil = new Automovil();
        automovil.setCilindrage(automovilDTO.getCilindrage());
        automovil.setColor(automovilDTO.getColor());
        automovil.setLinea(automovilDTO.getLinea());
        automovil.setMarca(automovilDTO.getMarca());
        automovil.setModelo(automovilDTO.getModelo());
        automovil.setNumPuertas(automovilDTO.getNumPuertas());
        automovil.setSerie(automovilDTO.getSerie());
        automovil.setPersona(persona);
      
        return automovil;
    }

    public AutomovilDTO convertirEntidadADTO(Automovil automovil) {

        if (automovil != null && automovil.getPersona() != null) {
            Persona persona = automovil.getPersona();
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setNombre(persona.getNombre());
            personaDTO.setApellidoP(persona.getApellidoP());
            personaDTO.setApellidoM(persona.getApellidoM());
            personaDTO.setFechaNac(persona.getFechaNac());
            personaDTO.setTelefono(persona.getTelefono());
            personaDTO.setRfc(persona.getRfc());
            personaDTO.setCurp(persona.getCurp());
            personaDTO.setDiscapacitado(persona.getDiscapacitado());

            AutomovilDTO automovilDTO = new AutomovilDTO();

            automovilDTO.setCilindrage(automovil.getCilindrage());
            automovilDTO.setColor(automovil.getColor());
            automovilDTO.setLinea(automovil.getLinea());
            automovilDTO.setMarca(automovil.getMarca());
            automovilDTO.setModelo(automovil.getModelo());
            automovilDTO.setNumPuertas(automovil.getNumPuertas());
            automovilDTO.setPersonaDTO(personaDTO);

            return automovilDTO;
        }
        return null;

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

    public AutomovilDTO obtenerAutomovilDTO(AutomovilDTO automovilDTO) {
        Automovil automovilBuscado = this.obtenerAutomovilEnt(automovilDTO);
        AutomovilDTO automovilConver = this.convertirEntidadADTO(automovilBuscado);
        return automovilConver;
    }

    public Automovil obtenerAutomovilEnt(AutomovilDTO automovilDTO) {
        Automovil automovil = this.convertirDTOAEntidad(automovilDTO);
        Automovil automovilBuscado = automovilDAO.consultarPorSerie(automovil);
        return automovilBuscado;

    }

    public Vehiculo obtenerVehiculoEnt(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = this.convertirDTOAEntidad(vehiculoDTO);
        Vehiculo vehiculoBuscado = automovilDAO.consultarVehiculoPorSerie(vehiculo);
        return vehiculoBuscado;
    }

    public VehiculoDTO obtenerVehiculoDTO(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculoBuscado = this.obtenerVehiculoEnt(vehiculoDTO);
        VehiculoDTO vehiculoConver = this.convertirEntidadADTO(vehiculoBuscado);
        return vehiculoConver;
    }

    @Override
    public AutomovilDTO registrarAutomovil(AutomovilDTO automovilDTO, PersonaDTO personaDTO) {

        Persona personaBuscada = this.obtenerPersonaEnt(personaDTO);

        if (personaBuscada == null) {
            return null;
        }

        Automovil nuevoAutomovil = new Automovil(automovilDTO.getNumPuertas(), automovilDTO.getCilindrage(), automovilDTO.getMarca(),
                automovilDTO.getLinea(), automovilDTO.getSerie(), automovilDTO.getColor(), automovilDTO.getModelo(), personaBuscada);
        Automovil automovilRegistrado = automovilDAO.agregar(nuevoAutomovil);
        return convertirEntidadADTO(automovilRegistrado);
    }
    
    @Override
    public boolean esPrimeraVez(Automovil automovil) {
        Automovil automovilBuscado = automovilDAO.consultarPorSerie(automovil);
        return automovilDAO.esPrimeraVez(automovilBuscado);
    }

}
