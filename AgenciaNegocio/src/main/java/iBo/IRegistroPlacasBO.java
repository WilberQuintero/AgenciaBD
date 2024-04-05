/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iBo;

import dto.PersonaDTO;
import dto.PlacaDTO;
import guardado.Transferencia;

/**
 *
 * @author willi
 */
public interface IRegistroPlacasBO {
    public PlacaDTO registrarPlaca(PlacaDTO placaDTO, PersonaDTO personaDTO);
    public Transferencia getDatos();
    public void datosGuardadosANull();
    public PlacaDTO desactivarPlaca(PlacaDTO placaDTO);
    public PlacaDTO entregar(PlacaDTO placaDTO);
    
}
