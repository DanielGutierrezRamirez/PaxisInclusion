/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.torredelrey.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Daniel Gutierrez Ramirez
 * 
 * clase Actividad
 * Representa una actividad en el sistema.
 * Esta clase es una entidad que se mapea a la tabla "actividad" en la base de datos.
 * Incluye campos para el ID de la actividad, nombre, número de plazas y reservas asociadas.
 * @version 1.0
 */

@Entity
@Table(name = "actividad")
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findById", query = "SELECT a FROM Actividad a WHERE a.id = :id"),
    @NamedQuery(name = "Actividad.findByNombreActividad", query = "SELECT a FROM Actividad a WHERE a.nombreActividad = :nombreActividad"),
    @NamedQuery(name = "Actividad.findByNumeroPlazas", query = "SELECT a FROM Actividad a WHERE a.numeroPlazas = :numeroPlazas")
})
public class Actividad implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * El identificador único para la actividad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    /**
     * El nombre de la actividad.
     */
    @Basic(optional = false)
    @Column(name = "nombre_actividad")
    private String nombreActividad;

    /**
     * El número de plazas disponibles para la actividad.
     */
    @Basic(optional = false)
    @Column(name = "numero_plazas")
    private int numeroPlazas;

    /**
     * La colección de reservas asociadas con esta actividad.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividad")
    private Collection<Reservas> reservasCollection;

    /**
     * Constructor por defecto.
     */
    public Actividad() {
    }

    /**
     * Constructor con parámetro id.
     * 
     * @param id El identificador único para la actividad.
     */
    public Actividad(Integer id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parámetros.
     * 
     * @param id El identificador único para la actividad.
     * @param nombreActividad El nombre de la actividad.
     * @param numeroPlazas El número de plazas disponibles para la actividad.
     */
    public Actividad(Integer id, String nombreActividad, int numeroPlazas) {
        this.id = id;
        this.nombreActividad = nombreActividad;
        this.numeroPlazas = numeroPlazas;
    }

    /**
     * Obtiene el identificador único para la actividad.
     * 
     * @return El identificador único para la actividad.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único para la actividad.
     * 
     * @param id El identificador único para la actividad.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la actividad.
     * 
     * @return El nombre de la actividad.
     */
    public String getNombreActividad() {
        return nombreActividad;
    }

    /**
     * Establece el nombre de la actividad.
     * 
     * @param nombreActividad El nombre de la actividad.
     */
    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    /**
     * Obtiene el número de plazas disponibles para la actividad.
     * 
     * @return El número de plazas disponibles para la actividad.
     */
    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    /**
     * Establece el número de plazas disponibles para la actividad.
     * 
     * @param numeroPlazas El número de plazas disponibles para la actividad.
     */
    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    /**
     * Obtiene la colección de reservas asociadas con esta actividad.
     * 
     * @return La colección de reservas asociadas con esta actividad.
     */
    public Collection<Reservas> getReservasCollection() {
        return reservasCollection;
    }

    /**
     * Establece la colección de reservas asociadas con esta actividad.
     * 
     * @param reservasCollection La colección de reservas asociadas con esta actividad.
     */
    public void setReservasCollection(Collection<Reservas> reservasCollection) {
        this.reservasCollection = reservasCollection;
    }

    /**
     * Incrementa el número de plazas disponibles.
     * 
     * @param numeroPlazas El número de plazas a incrementar.
     */
    public void incrementarPlazas(int numeroPlazas) { //para incrementar las plazas cuando eliminemos reservas
        this.numeroPlazas += numeroPlazas;
    }

    /**
     * Calcula el hash code para la entidad Actividad.
     * 
     * @return El hash code calculado.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara este objeto Actividad con otro objeto para verificar igualdad.
     * 
     * @param object El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // Nota: Este método no funcionará si los campos id no están establecidos.
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una cadena de texto que representa la entidad Actividad.
     * 
     * @return Una cadena de texto que representa la entidad Actividad.
     */
    @Override
    public String toString() {
        return "ies.torredelrey.modelo.Actividad[ id=" + id + " ]";
    }   
}