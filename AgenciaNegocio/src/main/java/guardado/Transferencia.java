/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guardado;

import dto.AutomovilDTO;
import dto.LicenciaDTO;
import dto.PersonaDTO;
import dto.PlacaDTO;
import dto.VehiculoDTO;

/**
 *
 * @author Usuario
 */
public class Transferencia {
    PersonaDTO personaDTO = new PersonaDTO();
    LicenciaDTO licenciaDTO = new LicenciaDTO();
    VehiculoDTO vehiculoDTO = new VehiculoDTO();
    AutomovilDTO automovilDTO = new AutomovilDTO();
    PlacaDTO placaDTO = new PlacaDTO();
    int boton = 0;

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }

    public LicenciaDTO getLicenciaDTO() {
        return licenciaDTO;
    }

    public void setLicenciaDTO(LicenciaDTO licenciaDTO) {
        this.licenciaDTO = licenciaDTO;
    }

    public int getBoton() {
        return boton;
    }

    public void setBoton(int boton) {
        this.boton = boton;
    }

    public VehiculoDTO getVehiculoDTO() {
        return vehiculoDTO;
    }

    public void setVehiculoDTO(VehiculoDTO vehiculoDTO) {
        this.vehiculoDTO = vehiculoDTO;
    }

    public AutomovilDTO getAutomovilDTO() {
        return automovilDTO;
    }

    public void setAutomovilDTO(AutomovilDTO automovilDTO) {
        this.automovilDTO = automovilDTO;
    }

    public PlacaDTO getPlacaDTO() {
        return placaDTO;
    }

    public void setPlacaDTO(PlacaDTO placaDTO) {
        this.placaDTO = placaDTO;
    }
    
}
