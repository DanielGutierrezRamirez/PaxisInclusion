/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.torredelrey.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel Gutierrez Ramirez
 * 
 * clase Actividad
 * Representa un usuario en el sistema.
 * Esta clase es una entidad que se mapea a la tabla "usuarios" en la base de datos.
 * Incluye campos para el ID del usuario, dni, nombre, apellidos, email, telefono, fecganacimiento, sexo, domicilio, cp, provincia y localidad.
 * @version 1.0
 */

@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id"),
    @NamedQuery(name = "Usuarios.findByDni", query = "SELECT u FROM Usuarios u WHERE u.dni = :dni"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuarios.findByFechaNacimiento", query = "SELECT u FROM Usuarios u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuarios.findBySexo", query = "SELECT u FROM Usuarios u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuarios.findByDomicilio", query = "SELECT u FROM Usuarios u WHERE u.domicilio = :domicilio"),
    @NamedQuery(name = "Usuarios.findByCp", query = "SELECT u FROM Usuarios u WHERE u.cp = :cp"),
    @NamedQuery(name = "Usuarios.findByProvincia", query = "SELECT u FROM Usuarios u WHERE u.provincia = :provincia"),
    @NamedQuery(name = "Usuarios.findByLocalidad", query = "SELECT u FROM Usuarios u WHERE u.localidad = :localidad")
})
public class Usuarios implements Serializable {

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

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "cp")
    private String cp;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "localidad")
    private String localidad;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private Collection<Reservas> reservasCollection;

    /**
     * Constructor por defecto.
     */
    public Usuarios() {
    }

    /**
     * Constructor con el id.
     * 
     * @param id El ID del usuario.
     */
    public Usuarios(Integer id) {
        this.id = id;
    }

    /**
     * Constructor con todos los campos obligatorios.
     * 
     * @param id El ID del usuario.
     * @param dni El DNI del usuario.
     * @param nombre El nombre del usuario.
     * @param apellidos Los apellidos del usuario.
     * @param email El email del usuario.
     */
    public Usuarios(Integer id, String dni, String nombre, String apellidos, String email) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    /**
     * Obtiene el ID del usuario.
     * 
     * @return El ID del usuario.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * 
     * @param id El ID del usuario.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el DNI del usuario.
     * 
     * @return El DNI del usuario.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del usuario.
     * 
     * @param dni El DNI del usuario.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del usuario.
     * 
     * @return Los apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del usuario.
     * 
     * @param apellidos Los apellidos del usuario.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el email del usuario.
     * 
     * @return El email del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario.
     * 
     * @param email El email del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el teléfono del usuario.
     * 
     * @return El teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del usuario.
     * 
     * @param telefono El teléfono del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     * 
     * @return La fecha de nacimiento del usuario.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     * 
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el sexo del usuario.
     * 
     * @return El sexo del usuario.
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del usuario.
     * 
     * @param sexo El sexo del usuario.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtiene el domicilio del usuario.
     * 
     * @return El domicilio del usuario.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Establece el domicilio del usuario.
     * 
     * @param domicilio El domicilio del usuario.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Obtiene el código postal del usuario.
     * 
     * @return El código postal del usuario.
     */
    public String getCp() {
        return cp;
    }

    /**
     * Establece el código postal del usuario.
     * 
     * @param cp El código postal del usuario.
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * Obtiene la provincia del usuario.
     * 
     * @return La provincia del usuario.
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Establece la provincia del usuario.
     * 
     * @param provincia La provincia del usuario.
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Obtiene la localidad del usuario.
     * 
     * @return La localidad del usuario.
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Establece la localidad del usuario.
     * 
     * @param localidad La localidad del usuario.
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * Obtiene la colección de reservas del usuario.
     * 
     * @return La colección de reservas del usuario.
     */
    public Collection<Reservas> getReservasCollection() {
        return reservasCollection;
    }

    /**
     * Establece la colección de reservas del usuario.
     * 
     * @param reservasCollection La colección de reservas del usuario.
     */
    public void setReservasCollection(Collection<Reservas> reservasCollection) {
        this.reservasCollection = reservasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // Nota: este método no funcionará en caso de que los campos id no estén establecidos.
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ies.torredelrey.modelo.Usuarios[ id=" + id + " ]";
    }
}