
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wilber
 */
@Entity
@Table (name = "tramites")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn (name = "tipo_tramite", discriminatorType = DiscriminatorType.STRING)
public class Tramite implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_expedicion")
    @Temporal (TemporalType.DATE)
    private Calendar fechaExpedicion;
        
    @Column(name="costo")
    private Float costo;
   
    @ManyToOne //(cascade = CascadeType.)
    @JoinColumn(name="id_persona",nullable=false)
    private Persona persona;
      

    public Tramite() {
    }

    public Tramite(Float costo) {
        this.costo = costo;
    }
    
    

    public Tramite(Float costo, Persona persona) {
        this.fechaExpedicion = Calendar.getInstance();
        this.costo = costo;
        this.persona = persona;
    }

    public Tramite(Long id, Float costo, Persona persona) {
        this.fechaExpedicion = Calendar.getInstance();
        this.id = id;
        this.costo = costo;
        this.persona = persona;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", fechaExpedicion=" + fechaExpedicion + ", costo=" + costo + ", persona=" + persona + '}';
    }
    
    
   
}
