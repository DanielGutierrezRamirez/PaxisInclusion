/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.torredelrey.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Daniel Gutierrez Ramirez
 * Representa un administrador en el sistema.
 * Esta clase es una entidad que se mapea a la tabla "administrador" en la base de datos.
 * Incluye campos para el ID del administrador, dni, nombre, apellidos, email y contraseña.
 * @version 1.0
 */
@Entity
@Table(name = "administrador")
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findById", query = "SELECT a FROM Administrador a WHERE a.id = :id"),
    @NamedQuery(name = "Administrador.findByDni", query = "SELECT a FROM Administrador a WHERE a.dni = :dni"),
    @NamedQuery(name = "Administrador.findByNombre", query = "SELECT a FROM Administrador a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Administrador.findByApellidos", query = "SELECT a FROM Administrador a WHERE a.apellidos = :apellidos"),
    @NamedQuery(name = "Administrador.findByEmail", query = "SELECT a FROM Administrador a WHERE a.email = :email"),
    @NamedQuery(name = "Administrador.findByContraseña", query = "SELECT a FROM Administrador a WHERE a.contraseña = :contraseña")
})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;

    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "contraseña")
    private String contraseña;

    /**
     * Constructor por defecto.
     */
    public Administrador() {
    }

    /**
     * Constructor con el id.
     * 
     * @param id El ID del administrador.
     */
    public Administrador(Integer id) {
        this.id = id;
    }

    /**
     * Constructor con todos los campos.
     * 
     * @param id El ID del administrador.
     * @param dni El DNI del administrador.
     * @param nombre El nombre del administrador.
     * @param apellidos Los apellidos del administrador.
     * @param email El email del administrador.
     * @param contraseña La contraseña del administrador.
     */
    public Administrador(Integer id, String dni, String nombre, String apellidos, String email, String contraseña) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el ID del administrador.
     * 
     * @return El ID del administrador.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID del administrador.
     * 
     * @param id El ID del administrador.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el DNI del administrador.
     * 
     * @return El DNI del administrador.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del administrador.
     * 
     * @param dni El DNI del administrador.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del administrador.
     * 
     * @return El nombre del administrador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del administrador.
     * 
     * @param nombre El nombre del administrador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del administrador.
     * 
     * @return Los apellidos del administrador.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del administrador.
     * 
     * @param apellidos Los apellidos del administrador.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el email del administrador.
     * 
     * @return El email del administrador.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del administrador.
     * 
     * @param email El email del administrador.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del administrador.
     * 
     * @return La contraseña del administrador.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del administrador.
     * 
     * @param contraseña La contraseña del administrador.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Calcula el hashcode de la entidad.
     * 
     * @return El valor hashcode para la entidad.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara esta entidad con otra para verificar igualdad.
     * 
     * @param object El objeto a comparar.
     * @return true si los objetos son iguales, de lo contrario false.
     */
    @Override
    public boolean equals(Object object) {
        // Nota: este método no funcionará si los campos id no están establecidos.
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en cadena de la entidad.
     * 
     * @return Una cadena que representa la entidad.
     */
    @Override
    public String toString() {
        return "ies.torredelrey.modelo.Administrador[ id=" + id + " ]";
    }
}
