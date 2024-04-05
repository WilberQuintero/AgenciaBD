/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Automovil;
import entidades.Persona;
import entidades.Placa;
import entidades.Vehiculo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IPlacaDAO {
    public Placa agregar(Placa placa);
    
    public Placa consultarPorNumPlaca(Placa placa);
    
    public Placa consultarPorId (Placa placa);
    
    public Placa desactivar(Placa placa);
    
    public List<Placa> consultarPlacasPersona(Persona persona);
    
    public Placa entregar(Placa placa);
}
