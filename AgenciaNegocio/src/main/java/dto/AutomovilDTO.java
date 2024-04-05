/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Usuario
 */
public class AutomovilDTO extends VehiculoDTO{
    
    private Integer numPuertas;
    private Integer cilindrage;

    public AutomovilDTO() {
    }

    public AutomovilDTO(String serie) {
        super(serie);
    }

    public AutomovilDTO(Integer numPuertas, Integer cilindrage, String serie, String marca, String linea, String color, Integer modelo, PersonaDTO personaDTO) {
        super(serie, marca, linea, color, modelo, personaDTO);
        this.numPuertas = numPuertas;
        this.cilindrage = cilindrage;
    }

    public Integer getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(Integer numPuertas) {
        this.numPuertas = numPuertas;
    }

    public Integer getCilindrage() {
        return cilindrage;
    }

    public void setCilindrage(Integer cilindrage) {
        this.cilindrage = cilindrage;
    }

    @Override
    public String toString() {
        return "AutomovilDTO{" + "numPuertas=" + numPuertas + ", cilindrage=" + cilindrage + '}';
    }
    
}
