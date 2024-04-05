
package dto;

import entidades.Persona;
import java.util.Calendar;

/**
 *
 * @author Wilber
 */
public class PersonaDTO {
    
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Calendar fechaNac;
    private String telefono;
    private String rfc;
    private String curp;
    private Boolean discapacitado;

    public PersonaDTO() {
    }
    
    public PersonaDTO(String rfc) {
        this.rfc = rfc;
    }

    public PersonaDTO(String nombre, String apellidoP, String apellidoM) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public PersonaDTO(String nombre, String apellidoP, String apellidoM, Calendar fechaNac, String telefono, String rfc, String curp, Boolean discapacitado) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.rfc = rfc;
        this.curp = curp;
        this.discapacitado = discapacitado;
    }

   

    public PersonaDTO(Persona persona) {
        this.nombre = persona.getNombre();
        this.apellidoP = persona.getApellidoP();
        this.apellidoM = persona.getApellidoM();
        this.fechaNac = persona.getFechaNac();
        this.telefono = persona.getTelefono();
        this.rfc = persona.getRfc();
        this.curp = persona.getCurp();
        this.discapacitado = persona.getDiscapacitado();
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
        return "PersonaDTO{" + "nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", fechaNac=" + fechaNac + ", telefono=" + telefono + ", rfc=" + rfc + ", curp=" + curp + ", discapacitado=" + discapacitado + '}';
    }

    

    
   

}
