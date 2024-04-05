package bo;


import DAO.ILicenciaDAO;
import DAO.IPersonaDAO;
import DAO.LicenciaDAO;
import DAO.PersonaDAO;
import dto.LicenciaDTO;
import dto.PersonaDTO;

import entidades.Licencia;
import entidades.Persona;
import entidades.TipoLicencia;
import guardado.General;
import guardado.Transferencia;
import iBo.IRegistroLicenciasBO;
import java.util.List;

/**
 *
 * @author Wilber
 */
public class RegistroLicenciasBO implements IRegistroLicenciasBO{

    private IPersonaDAO personaDAO;
    private ILicenciaDAO licenciaDAO;
//    private PersonaDTO personaDTO = null;
//    private LicenciaDTO licenciaDTO = null;
    private Transferencia datos;
    private int boton = 0;
    
    public RegistroLicenciasBO() {
        personaDAO = new PersonaDAO();
        licenciaDAO = new LicenciaDAO();
        datos = General.transferencia;
        
    }
   
    @Override
    public Licencia convertirDTOAEntidad(LicenciaDTO licenciaDTO) {
        Persona persona = null;
        if(licenciaDTO.getPersona() != null){
            Persona per = new Persona();
        PersonaDTO personaDTO = licenciaDTO.getPersona();
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
        

        Licencia licencia = new Licencia();
        licencia.setFolio(licenciaDTO.getFolio());
        licencia.setEstado(licenciaDTO.getEstado());
        licencia.setAnios(licenciaDTO.getAnios());
        licencia.setFechaVigencia(licenciaDTO.getFechaVigencia());
        licencia.setTipo(licenciaDTO.getTipo());
        licencia.setCosto(licenciaDTO.getCosto());
        licencia.setPersona(persona);

        return licencia;
    }
    
//    @Override
//    public LicenciaDTO convertirEntidadADTO(Licencia licencia) {
//        if(licencia.getPersona() != null){
//            Persona persona = licencia.getPersona();
//        PersonaDTO personaDTO = new PersonaDTO();
//        personaDTO.setNombre(persona.getNombre());
//        personaDTO.setApellidoP(persona.getApellidoP());
//        personaDTO.setApellidoM(persona.getApellidoM());
//        personaDTO.setFechaNac(persona.getFechaNac());
//        personaDTO.setTelefono(persona.getTelefono());
//        personaDTO.setRfc(persona.getRfc());
//        personaDTO.setCurp(persona.getCurp());
//        personaDTO.setDiscapacitado(persona.getDiscapacitado());
//
//        LicenciaDTO licenciaDTO = new LicenciaDTO();
//
//        licenciaDTO.setFolio(licencia.getFolio());
//        licenciaDTO.setEstado(licencia.getEstado());
//        licenciaDTO.setAnio(licencia.getAnios());
//        licenciaDTO.setFechaVigencia(licencia.getFechaVigencia());
//        licenciaDTO.setTipo(licencia.getTipo());
//        licenciaDTO.setCosto(licencia.getCosto());
//        licenciaDTO.setPersona(personaDTO);
//        
//        return licenciaDTO;    
//        }
//        return null; 
//    }
    
    @Override
    public LicenciaDTO convertirEntidadADTO(Licencia licencia) {
        if (licencia != null && licencia.getPersona() != null) {
            Persona persona = licencia.getPersona();
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setNombre(persona.getNombre());
            personaDTO.setApellidoP(persona.getApellidoP());
            personaDTO.setApellidoM(persona.getApellidoM());
            personaDTO.setFechaNac(persona.getFechaNac());
            personaDTO.setTelefono(persona.getTelefono());
            personaDTO.setRfc(persona.getRfc());
            personaDTO.setCurp(persona.getCurp());
            personaDTO.setDiscapacitado(persona.getDiscapacitado());

            LicenciaDTO licenciaDTO = new LicenciaDTO();

            licenciaDTO.setFolio(licencia.getFolio());
            licenciaDTO.setEstado(licencia.getEstado());
            licenciaDTO.setAnios(licencia.getAnios());
            licenciaDTO.setFechaVigencia(licencia.getFechaVigencia());
            licenciaDTO.setTipo(licencia.getTipo());
            licenciaDTO.setCosto(licencia.getCosto());
            licenciaDTO.setPersona(personaDTO);

            return licenciaDTO;
        }
        return null;
    }
    
    @Override
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
    
    @Override
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
    
    @Override
    public Persona obtenerPersonaEnt(PersonaDTO personaDTO){
        Persona persona = this.convertirDTOAEntidad(personaDTO);
        Persona personaBuscada = personaDAO.obtenerPersonaPorRFC(persona);
        return personaBuscada;
    }
    
    @Override
    public PersonaDTO obtenerPersonaDTO(PersonaDTO personaDTO){
        Persona personaBuscada = this.obtenerPersonaEnt(personaDTO);
        PersonaDTO personaConver = this.convertirEntidadADTO(personaBuscada);
//        this.personaDTO = personaConver;
        return personaConver;
    }
    
    @Override
    public LicenciaDTO obtenerLicenciDTO(LicenciaDTO licenciaDTO){
        Licencia licenciaBuscada = this.obtenerLicenciaEnt(licenciaDTO);
        LicenciaDTO licenciaConver = this.convertirEntidadADTO(licenciaBuscada);
//        this.licenciaDTO = licenciaConver;
        return licenciaConver;
    }
    
    @Override
    public Licencia obtenerLicenciaEnt(LicenciaDTO licenciaDTO){
        Licencia licencia = this.convertirDTOAEntidad(licenciaDTO);
        Licencia licenciaBuscada = licenciaDAO.consultarPorFolio(licencia);
        licenciaDAO.cerrarConexion();
        return licenciaBuscada;
        
    }
    
    @Override
    public void insercionMasiva(){
        personaDAO.incercionMasiva();
    }
    
    @Override
    public boolean validarRFC(PersonaDTO personaDTO){
        Persona persona = this.convertirDTOAEntidad(personaDTO);
        Persona personaBuscada = personaDAO.obtenerPersonaPorRFC(persona);
        
        if(personaBuscada != null){
            PersonaDTO personaConver = this.convertirEntidadADTO(personaBuscada);
//            this.personaDTO = personaConver;
            return true;
        }
        return false;
        
    }
    
    @Override
    public boolean validarFolio(LicenciaDTO licenciaDTO){
        Licencia licencia = this.convertirDTOAEntidad(licenciaDTO);
        Licencia licenciaBuscada = licenciaDAO.consultarPorFolio(licencia);
        
        if(licenciaBuscada != null){
            
            LicenciaDTO licenciaConver = this.convertirEntidadADTO(licenciaBuscada);
//            this.licenciaDTO = licenciaConver;
            return true;
        }
        return false;
        
    }
    
    @Override
    public LicenciaDTO registrarLicencia(LicenciaDTO licenciaDTO, PersonaDTO personaDTO) {
        
        //Persona persona = this.convertirDTOAEntidad(personaDTO);
        PersonaDTO personaClon = new PersonaDTO(personaDTO.getRfc());
        Persona personaBuscada = this.obtenerPersonaEnt(personaClon);
        if (personaBuscada == null) {
            return null;
        }
        float costo = calcularCostoLicencia(licenciaDTO, personaDTO);
        Licencia lice = this.convertirDTOAEntidad(licenciaDTO);
        Licencia nuevaLicencia = new Licencia(lice.getAnios(), costo, lice.getTipo(), personaBuscada);
        Licencia licenciaRegistrada = licenciaDAO.agregar(nuevaLicencia);
        return convertirEntidadADTO(licenciaRegistrada);
    }

    public Float calcularCostoLicencia(LicenciaDTO licenciaDTO, PersonaDTO personaDTO) {
        Float costo = 0.0F;
        switch (licenciaDTO.getTipo()) {
            case AUTOMOVIL -> {
                if (personaDTO.getDiscapacitado()) {
                    switch (licenciaDTO.getAnios()) {
                        case 1 ->
                            costo = 200.0f;
                        case 2 ->
                            costo = 500.0f;
                        case 3 ->
                            costo = 700.0f;
                        default -> {
                        }
                    }

                } else {
                    switch (licenciaDTO.getAnios()) {
                        case 1 ->
                            costo = 600.0f;
                        case 2 ->
                            costo = 900.0f;
                        case 3 ->
                            costo = 1100.0f;
                        default -> {
                        }
                    }

                }
            }

        }

        return costo;
    }
    
    @Override
    public LicenciaDTO consultarUltimaLicenciaPersona(PersonaDTO personaDTO){
        Persona persona = this.obtenerPersonaEnt(personaDTO);
        PersonaDAO personaDAO = new PersonaDAO();
        Licencia licenciaConsul = personaDAO.consultarUltimaLicenciaPersona(persona);
        LicenciaDTO licenciaConver = this.convertirEntidadADTO(licenciaConsul);
        return licenciaConver;
        
    }

    @Override
    public Transferencia getDatos() {
        return datos;
    }
    
    @Override
    public void datosGuardadosANull(){
        datos.setBoton(0);
        datos.setPersonaDTO(null);
        datos.setLicenciaDTO(null);
    }
    
    @Override
    public void desactivarLicencia(LicenciaDTO licenciaDTO){
        Licencia licencia = this.obtenerLicenciaEnt(licenciaDTO);
        licenciaDAO.desactivar(licencia);
    }
    
    
}
