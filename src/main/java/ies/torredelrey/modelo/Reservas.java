/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.torredelrey.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel Gutierrez Ramirez
 * 
 * clase Reservas
 * * Representa una reserva en el sistema.
 * Esta clase es una entidad que se mapea a la tabla "reservas" en la base de datos.
 * Incluye campos para el ID de la reserva, nombre y apellidos del usuario, DNI, nombre de la actividad, número de plazas reservadas, fecha de la reserva, actividad y usuario asociados.
 * @version 1.0
 */
@Entity
@Table(name = "reservas")
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r"),
    @NamedQuery(name = "Reservas.findById", query = "SELECT r FROM Reservas r WHERE r.id = :id"),
    @NamedQuery(name = "Reservas.findByNombreUsuario", query = "SELECT r FROM Reservas r WHERE r.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Reservas.findByApellidosUsuario", query = "SELECT r FROM Reservas r WHERE r.apellidosUsuario = :apellidosUsuario"),
    @NamedQuery(name = "Reservas.findByDniUsuario", query = "SELECT r FROM Reservas r WHERE r.dniUsuario = :dniUsuario"),
    @NamedQuery(name = "Reservas.findByNombreActividad", query = "SELECT r FROM Reservas r WHERE r.nombreActividad = :nombreActividad"),
    @NamedQuery(name = "Reservas.findByNumeroPlazasReserva", query = "SELECT r FROM Reservas r WHERE r.numeroPlazasReserva = :numeroPlazasReserva"),
    @NamedQuery(name = "Reservas.findByFechaReserva", query = "SELECT r FROM Reservas r WHERE r.fechaReserva = :fechaReserva")
})
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * El identificador único para la reserva.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    /**
     * El nombre del usuario que realiza la reserva.
     */
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    
    /**
     * Los apellidos del usuario que realiza la reserva.
     */
    @Basic(optional = false)
    @Column(name = "apellidos_usuario")
    private String apellidosUsuario;
    
    /**
     * El DNI del usuario que realiza la reserva.
     */
    @Basic(optional = false)
    @Column(name = "dni_usuario")
    private String dniUsuario;
    
    /**
     * El nombre de la actividad para la que se realiza la reserva.
     */
    @Basic(optional = false)
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    
    /**
     * El número de plazas reservadas.
     */
    @Basic(optional = false)
    @Column(name = "numero_plazas_reserva")
    private int numeroPlazasReserva;
    
    /**
     * La fecha en la que se realiza la reserva.
     */
    @Basic(optional = false)
    @Column(name = "fecha_reserva")
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    
    /**
     * La actividad asociada a la reserva.
     */
    @ManyToOne
    @JoinColumn(name = "id_actividad")
    private Actividad idActividad;
    
    /**
     * El usuario asociado a la reserva.
     */
    @JoinColumns({
        @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    })
    private Usuarios usuarios;

    /**
     * Constructor por defecto.
     */
    public Reservas() {
    }

    /**
     * Constructor con parámetro id.
     * 
     * @param id El identificador único para la reserva.
     */
    public Reservas(Integer id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parámetros.
     * 
     * @param id El identificador único para la reserva.
     * @param nombreUsuario El nombre del usuario que realiza la reserva.
     * @param apellidosUsuario Los apellidos del usuario que realiza la reserva.
     * @param dniUsuario El DNI del usuario que realiza la reserva.
     * @param nombreActividad El nombre de la actividad para la que se realiza la reserva.
     * @param numeroPlazasReserva El número de plazas reservadas.
     * @param fechaReserva La fecha en la que se realiza la reserva.
     */
    public Reservas(Integer id, String nombreUsuario, String apellidosUsuario, String dniUsuario, String nombreActividad, int numeroPlazasReserva, Date fechaReserva) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.dniUsuario = dniUsuario;
        this.nombreActividad = nombreActividad;
        this.numeroPlazasReserva = numeroPlazasReserva;
        this.fechaReserva = fechaReserva;
    }

    /**
     * Obtiene el identificador único para la reserva.
     * 
     * @return El identificador único para la reserva.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único para la reserva.
     * 
     * @param id El identificador único para la reserva.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario que realiza la reserva.
     * 
     * @return El nombre del usuario que realiza la reserva.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre del usuario que realiza la reserva.
     * 
     * @param nombreUsuario El nombre del usuario que realiza la reserva.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene los apellidos del usuario que realiza la reserva.
     * 
     * @return Los apellidos del usuario que realiza la reserva.
     */
    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    /**
     * Establece los apellidos del usuario que realiza la reserva.
     * 
     * @param apellidosUsuario Los apellidos del usuario que realiza la reserva.
     */
    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    /**
     * Obtiene el DNI del usuario que realiza la reserva.
     * 
     * @return El DNI del usuario que realiza la reserva.
     */
    public String getDniUsuario() {
        return dniUsuario;
    }

    /**
     * Establece el DNI del usuario que realiza la reserva.
     * 
     * @param dniUsuario El DNI del usuario que realiza la reserva.
     */
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Obtiene el nombre de la actividad para la que se realiza la reserva.
     * 
     * @return El nombre de la actividad para la que se realiza la reserva.
     */
    public String getNombreActividad() {
        return nombreActividad;
    }

    /**
     * Establece el nombre de la actividad para la que se realiza la reserva.
     * 
     * @param nombreActividad El nombre de la actividad para la que se realiza la reserva.
     */
    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    /**
     * Obtiene el número de plazas reservadas.
     * 
     * @return El número de plazas reservadas.
     */
    public int getNumeroPlazasReserva() {
        return numeroPlazasReserva;
    }

    /**
     * Establece el número de plazas reservadas.
     * 
     * @param numeroPlazasReserva El número de plazas reservadas.
     */
    public void setNumeroPlazasReserva(int numeroPlazasReserva) {
        this.numeroPlazasReserva = numeroPlazasReserva;
    }

    /**
     * Obtiene la fecha en la que se realiza la reserva.
     * 
     * @return La fecha en la que se realiza la reserva.
     */
    public Date getFechaReserva() {
        return fechaReserva;
    }

    /**
     * Establece la fecha en la que se realiza la reserva.
     * 
     * @param fechaReserva La fecha en la que se realiza la reserva.
     */
    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * Obtiene la actividad asociada a la reserva.
     * 
     * @return La actividad asociada a la reserva.
     */
    public Actividad getIdActividad() {
        return idActividad;
    }

    /**
     * Establece la actividad asociada a la reserva.
     * 
     * @param idActividad La actividad asociada a la reserva.
     */
    public void setIdActividad(Actividad idActividad) {
        this.idActividad = idActividad;
    }

    /**
     * Obtiene el usuario asociado a la reserva.
     * 
     * @return El usuario asociado a la reserva.
     */
    public Usuarios getUsuarios() {
        return usuarios;
    }

    /**
     * Establece el usuario asociado a la reserva.
     * 
     * @param usuarios El usuario asociado a la reserva.
     */
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
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
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
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
        return "ies.torredelrey.modelo.Reservas[ id=" + id + " ]";
    }
}