
package dto;

import java.util.Calendar;

/**
 *
 * @author Wilber
 */
public class TramiteDTO {
    
    private Long id;
    private Float costo;
    private PersonaDTO persona;
    
    
    public TramiteDTO() {
    }

    public TramiteDTO(Float costo, PersonaDTO persona) {
        this.costo = costo;
        this.persona = persona;
    }

    public TramiteDTO(Float costo) {
        this.costo = costo;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "TramiteDTO{" + "id=" + id + ", costo=" + costo + ", persona=" + persona + '}';
    }

    

    

    
}