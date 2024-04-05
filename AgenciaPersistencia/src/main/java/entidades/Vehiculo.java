
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Wilber
 */
@Entity
@Table (name = "vehiculos")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn (name = "tipo_vehiculo", discriminatorType = DiscriminatorType.STRING)
public class Vehiculo implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "serie", nullable = false, unique = true)
    private String serie;
    
    @Column (name = "marca", nullable = false)
    private String marca;
    
    @Column (name = "linea", nullable = false)
    private String linea;
    
    @Column (name = "color", nullable = false)
    private String color;
    
    @Column (name = "modelo", nullable = false)
    private Integer modelo;
    
    @ManyToOne //(cascade = CascadeType.)
    @JoinColumn(name="id_persona",nullable=false)
    private Persona persona;

    public Vehiculo() {
    }

    public Vehiculo(String serie) {
        this.serie = serie;
    }

    public Vehiculo(String marca, String linea, String serie, String color, Integer modelo, Persona persona) {
        this.marca = marca;
        this.linea = linea;
        this.serie = serie;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
    }
    
    

    public Vehiculo(Long id, String marca, String linea, String serie, String color, Integer modelo, Persona persona) {
        this.id = id;
        this.marca = marca;
        this.linea = linea;
        this.serie = serie;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", serie=" + serie + ", marca=" + marca + ", linea=" + linea + ", color=" + 
                color + ", modelo=" + modelo + ", persona=" + persona + '}';
    }

    
    
}
