
package dto;

import entidades.Estado;
import entidades.TipoLicencia;
import java.util.Calendar;

/**
 *
 * @author Wilber
 */
public class LicenciaDTO extends TramiteDTO{
       
    private String folio;
    private Estado estado;
    private Integer anios;
    private Calendar fechaVigencia;
    private TipoLicencia tipo;

    
    public LicenciaDTO() {
    }  
    
    public LicenciaDTO(TipoLicencia tipo, Integer anios) {
        this.tipo = tipo;
        this.anios = anios;
    }  
    
    public LicenciaDTO(String folio) {
        this.folio = folio;
    }  

    public LicenciaDTO(Integer anio, TipoLicencia tipo, Float costo) {
        super(costo);
        this.anios = anio;
        this.tipo = tipo;
    }
    
    

    public LicenciaDTO(Float costo, PersonaDTO persona, TipoLicencia tipoLicencia, Integer anios) {
        super(costo, persona);
        this.tipo = tipoLicencia;
        this.anios = anios;
    }
    
    
    
    public LicenciaDTO(String folio ,Estado estado, Integer anios, Calendar fechaVigencia, TipoLicencia tipo, Float costo, PersonaDTO persona) {
        super(costo, persona);
        this.folio = folio;
        this.estado = estado;
        this.anios = anios;
        this.fechaVigencia = fechaVigencia;
        this.tipo = tipo;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getAnios() {
        return anios;
    }

    public void setAnios(Integer anios) {
        this.anios = anios;
    }

    public Calendar getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Calendar fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public TipoLicencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoLicencia tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "LicenciaDTO{" + "folio=" + folio + ", estado=" + estado + ", anios=" + anios + ", fechaVigencia=" + fechaVigencia + ", tipo=" + tipo + '}';
    }



    

    
  }