package DAO;

import entidades.Licencia;
import entidades.Persona;
import java.util.List;

/**
 *
 * @author Wilber
 */
public interface IPersonaDAO {

    public Persona obtenerPersona(Persona persona);

    public Persona obtenerPersonaPorRFC(Persona Persona);

    public Persona obtenerPersonaPorCURP(Persona persona);

    public List<Persona> buscarPersonasPorNombre(String nombre, String apellidoP, String apellidoM);

    public List<Persona> buscarPersonasPorAnioNacimiento(int anioNacimiento);

    public void incercionMasiva();

    public Licencia consultarUltimaLicenciaPersona(Persona persona);

    public void cerrarConexion();
}
