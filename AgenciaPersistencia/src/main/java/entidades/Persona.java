package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wilber
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false, length = 255)
    private String apellidoP;

    @Column(name = "apellido_materno", nullable = true, length = 255)
    private String apellidoM;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar fechaNac;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "rfc", nullable = false, length = 16, unique = true)
    private String rfc;

    @Column(name = "curp", nullable = false, length = 20, unique = true)
    private String curp;

    @Column(name = "discapacitado", nullable = false)
    private Boolean discapacitado;

    

    public Persona() {
    }

    public Persona(String rfc) {
        this.rfc = rfc;
    }

    public Persona(String nombre, String apellidoP, String apellidoM, Calendar fechaNac, String telefono, String rfc, String curp, Boolean discapacitado) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.rfc = rfc;
        this.curp = curp;
        this.discapacitado = discapacitado;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Calendar getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Calendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Boolean getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", fechaNac=" + fechaNac + ", telefono=" + telefono + ", rfc=" + rfc + ", curp=" + curp + ", discapacitado=" + discapacitado + '}';
    }

   

   

    
    
   }