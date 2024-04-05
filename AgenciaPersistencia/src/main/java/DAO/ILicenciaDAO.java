
package DAO;

import entidades.Estado;
import entidades.Licencia;
import entidades.Persona;
import entidades.TipoLicencia;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Wilber
 */
public interface ILicenciaDAO {
    public Licencia agregar(Licencia licencia);
    public Licencia consultarPorFolio(Licencia licecnia);
    public Licencia consultarPorId(Licencia licencia);
    public Licencia desactivar(Licencia licencia);
    public List<Licencia> consultarLicenciasPersona(Persona persona);
    public void cerrarConexion();
}
