
package iBo;

import dto.LicenciaDTO;
import dto.PersonaDTO;
import entidades.Licencia;
import entidades.Persona;
import guardado.Transferencia;

/**
 *
 * @author Wilber
 */
public interface IRegistroLicenciasBO {
    public Licencia convertirDTOAEntidad(LicenciaDTO licenciaDTO);
    public LicenciaDTO convertirEntidadADTO(Licencia licencia);
    public Persona convertirDTOAEntidad(PersonaDTO personaDTO);
    public PersonaDTO convertirEntidadADTO(Persona persona);
    public Persona obtenerPersonaEnt(PersonaDTO personaDTO);
    public Licencia obtenerLicenciaEnt(LicenciaDTO licenciaDTO);
    public void insercionMasiva();
    public boolean validarRFC(PersonaDTO personaDTO);
    public boolean validarFolio(LicenciaDTO licenciaDTO);
    public PersonaDTO obtenerPersonaDTO(PersonaDTO personaDTO);
    public LicenciaDTO registrarLicencia(LicenciaDTO licenciaDTO, PersonaDTO personaDTO);
    public LicenciaDTO consultarUltimaLicenciaPersona(PersonaDTO personaDTO);
    public LicenciaDTO obtenerLicenciDTO(LicenciaDTO licenciaDTO);
    public Transferencia getDatos();
    public void datosGuardadosANull();
    public void desactivarLicencia(LicenciaDTO licenciaDTO);
    
    
}
