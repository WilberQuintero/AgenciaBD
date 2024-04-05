
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "automoviles")
@DiscriminatorValue("automovil")
public class Automovil extends Vehiculo implements Serializable {

    @Column (name = "numPuertas", nullable = false)
    private Integer numPuertas;

    @Column (name = "cilindraje", nullable = false)
    private Integer cilindrage;

    public Automovil() {
    }

    public Automovil(String serie) {
        super(serie);
    }

    public Automovil(Integer numPuertas, Integer cilindrage, String marca, String linea, String serie, String color, Integer modelo, Persona persona) {
        super(marca, linea, serie, color, modelo, persona);
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
        return "Automovil{"+ "Serie=" + this.getSerie() + ", Marca=" + this.getMarca() + ", Linea=" + this.getLinea()+ 
                ", Modelo=" + this.getModelo() + ", Color=" + this.getColor()+ ", numPuertas=" + 
                numPuertas + ", cilindrage=" + cilindrage + '}';
    }
    
}
