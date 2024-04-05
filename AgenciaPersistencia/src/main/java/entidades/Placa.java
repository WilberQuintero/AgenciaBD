
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import jdk.jfr.BooleanFlag;

/**
 *
 * @author Usuario
 */
@Entity
@Table (name = "placas")
@DiscriminatorValue ("placa")
public class Placa extends Tramite implements Serializable {

    
    @Column(name = "numPlaca", nullable = false, length = 7)
    private String numPlaca;
    
    @Column(name = "estado", nullable = false)
    @Enumerated (EnumType.STRING)
    private Estado estado;

    
    @Column (name = "discapacitado", nullable = false)
    private Boolean discapacitado;
    
    @Column (name = "fechaEntrega")
    @Temporal (TemporalType.DATE)
    private Calendar fechaEntrega;
            
    //Atributo que dice si lla entego la placa o aun no.
    @Column (name = "entrego", nullable = false)
    private Boolean entrego;
    
    @ManyToOne //(cascade = CascadeType.)
    @JoinColumn(name="id_vehiculo",nullable=false)
    private Vehiculo vehiculo;

    public Placa() {
    }

    public Placa(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public Placa(Float costo, Persona persona) {
        super(costo, persona);
    }

    public Placa(String numPlaca, Boolean discapacitado, Boolean entrego, Float costo, Persona persona) {
        super(costo, persona);
        this.numPlaca = numPlaca;
        this.estado = Estado.VIGENTE;
        this.discapacitado = discapacitado;
        this.entrego = entrego;
    }
    
    

    public Placa(String numPlaca, Boolean discapacitado, Boolean entrego, Vehiculo vehiculo, Float costo, Persona persona) {
        super(costo, persona);
        this.numPlaca = numPlaca;
        this.estado = Estado.VIGENTE;
        this.discapacitado = discapacitado;
        this.entrego = entrego;
        this.vehiculo = vehiculo;
    }

    public Placa(String numPlaca, Estado estado, Boolean discapacitado, Calendar fechaEntrega, Boolean entrego, Vehiculo vehiculo, Float costo, Persona persona) {
        super(costo, persona);
        this.numPlaca = numPlaca;
        this.estado = estado;
        this.discapacitado = discapacitado;
        this.fechaEntrega = fechaEntrega;
        this.entrego = entrego;
        this.vehiculo = vehiculo;
    }
    
    public Placa(Estado estado, Boolean discapacitado, Calendar fechaEntrega, Boolean entrego, Vehiculo vehiculo, Long id, Float costo, Persona persona) {
        super(costo, persona);
        this.estado = estado;
        this.discapacitado = discapacitado;
        this.fechaEntrega = fechaEntrega;
        this.entrego = entrego;
        this.vehiculo = vehiculo;
    }
    
    

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Boolean getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    public Boolean getEntrego() {
        return entrego;
    }

    public void setEntrego(Boolean entrego) {
        this.entrego = entrego;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Calendar getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Calendar fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        return "Placa{" + "numPlaca=" + numPlaca + ", estado=" + estado + ", discapacitado=" + discapacitado + ", fechaEntrega=" + fechaEntrega + ", entrego=" + entrego + ", vehiculo=" + vehiculo + '}';
    }
    
}
