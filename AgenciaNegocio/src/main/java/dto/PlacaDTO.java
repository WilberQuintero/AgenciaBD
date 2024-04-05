
package dto;

import entidades.Estado;
import entidades.Vehiculo;
import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class PlacaDTO extends TramiteDTO{
    
    private String numPlaca;
    private Estado estado;
    private boolean discapacitado;
    private Calendar fechaEntrega;
    private boolean entrego; // atributo que dice si ya entego la placa o aun no.
    private Vehiculo vehiculo;
    

    public PlacaDTO() {
    }

    public PlacaDTO(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public PlacaDTO(Float costo, PersonaDTO persona) {
        super(costo, persona);
        
    }

    public PlacaDTO(String numPlaca, Estado estado, boolean discapacitado, boolean entrego, Vehiculo vehiculo, Float costo, PersonaDTO persona) {
        super(costo, persona);
        this.numPlaca = numPlaca;
        this.estado = estado;
        this.discapacitado = discapacitado;
        this.entrego = entrego;
        this.vehiculo = vehiculo;
    }

    
    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean isDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    public boolean isEntrego() {
        return entrego;
    }

    public void setEntrego(boolean entrego) {
        this.entrego = entrego;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Calendar getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Calendar fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        return "PlacaDTO{" + "numPlaca=" + numPlaca + ", estado=" + estado + ", discapacitado=" + discapacitado + ", fechaEntrega=" + fechaEntrega + ", entrego=" + entrego + ", vehiculo=" + vehiculo + '}';
    }
    
}
