
package dto;

import entidades.Persona;

/**
 *
 * @author Usuario
 */
public class VehiculoDTO {
    
    private String serie;
    private String marca;
    private String linea;
    private String color;
    private Integer modelo;
    private PersonaDTO personaDTO;

    public VehiculoDTO() {
    }

    public VehiculoDTO(String serie) {
        this.serie = serie;
    }

    public VehiculoDTO(String serie, String marca, String linea, String color, Integer modelo, PersonaDTO personaDTO) {
        this.serie = serie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.personaDTO = personaDTO;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }

    @Override
    public String toString() {
        return "VehiculoDTO{" + "serie=" + serie + ", marca=" + marca + ", linea=" + linea + ", color=" + color + ", modelo=" + modelo + ", personaDTO=" + personaDTO + '}';
    }
    
}
