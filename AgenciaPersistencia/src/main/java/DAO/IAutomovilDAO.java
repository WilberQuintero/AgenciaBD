/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Automovil;
import entidades.Vehiculo;

/**
 *
 * @author Usuario
 */
public interface IAutomovilDAO {
    public Automovil agregar(Automovil automovil);
    public Automovil consultarPorSerie(Automovil automovil);
    public boolean esPrimeraVez(Automovil automovil);
    public Vehiculo consultarVehiculoPorSerie(Vehiculo vehiculo);
    
    
    
}
