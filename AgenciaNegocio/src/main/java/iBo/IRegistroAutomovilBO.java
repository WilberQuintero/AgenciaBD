/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iBo;

import dto.AutomovilDTO;
import dto.PersonaDTO;
import entidades.Automovil;
import guardado.Transferencia;

/**
 *
 * @author willi
 */
public interface IRegistroAutomovilBO {
    public AutomovilDTO registrarAutomovil(AutomovilDTO automovilDTO, PersonaDTO personaDTO);
    public boolean esPrimeraVez(Automovil automovil);
    public Transferencia getDatos();
    
}
