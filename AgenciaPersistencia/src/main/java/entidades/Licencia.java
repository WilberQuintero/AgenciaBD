package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wilber
 */
@Entity
@Table(name = "licencias")
@DiscriminatorValue("licencia")
public class Licencia extends Tramite implements Serializable{

    @Column (name = "folio",unique = true)
    private String folio;
    
    @Column(name = "estado", nullable = false)
    @Enumerated (EnumType.STRING)
    private Estado estado;

    @Column(name = "anios", nullable = false)
    private Integer anios;

    @Column(name = "fecha_vigencia", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar fechaVigencia;

    @Column(name = "tipo", nullable = false)
    private TipoLicencia tipo;

    public Licencia() {
    }
    public Licencia(String folio) {
        this.folio = folio;
    }

    public Licencia(Integer anios, Float costo, TipoLicencia tipo, Persona persona) {
        super(costo, persona);
        this.folio = folio;
        this.estado = Estado.ACTIVO;
        this.anios = anios;
        this.tipo = tipo;
        
        Calendar fechaExpedicion = this.getFechaExpedicion();
        Calendar fechaVigencia = (Calendar) fechaExpedicion.clone();
        fechaVigencia.add(Calendar.YEAR, anios);
        
        this.fechaVigencia = fechaVigencia;
    }

    public Licencia(Integer anios, TipoLicencia tipo, Float costo) {
        super(costo);
        this.anios = anios;
        this.tipo = tipo;
        
        Calendar fechaExpedicion = this.getFechaExpedicion();
        Calendar fechaVigencia = (Calendar) fechaExpedicion.clone();
        fechaVigencia.add(Calendar.YEAR, anios);
        
        this.fechaVigencia = fechaVigencia;
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
        return "Licencia{" + "folio=" + folio + ", estado=" + estado + ", anios=" + anios + ", fechaVigencia=" + fechaVigencia + ", tipo=" + tipo + '}';
    }

}
