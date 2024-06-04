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
 * @author 34662
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
    @NamedQuery(name = "Reservas.findByFechaReserva", query = "SELECT r FROM Reservas r WHERE r.fechaReserva = :fechaReserva")})
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "apellidos_usuario")
    private String apellidosUsuario;
    @Basic(optional = false)
    @Column(name = "dni_usuario")
    private String dniUsuario;
    @Basic(optional = false)
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    @Basic(optional = false)
    @Column(name = "numero_plazas_reserva")
    private int numeroPlazasReserva;
    @Basic(optional = false)
    @Column(name = "fecha_reserva")
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    @ManyToOne
    @JoinColumn(name = "id_actividad")
    private Actividad idActividad;

    /*@ManyToOne
    @JoinColumn(name = "id_actividad", insertable = false, updatable = false)
    private Actividad actividad;    @ManyToOne(optional = false)*/

    @JoinColumns({
        @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id")})
    private Usuarios usuarios;
    

    public Reservas() {
    }

    public Reservas(Integer id) {
        this.id = id;
    }
    

    public Reservas(Integer id, String nombreUsuario, String apellidosUsuario, String dniUsuario, String nombreActividad, int numeroPlazasReserva, Date fechaReserva) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.dniUsuario = dniUsuario;
        this.nombreActividad = nombreActividad;
        this.numeroPlazasReserva = numeroPlazasReserva;
        this.fechaReserva = fechaReserva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getNumeroPlazasReserva() {
        return numeroPlazasReserva;
    }

    public void setNumeroPlazasReserva(int numeroPlazasReserva) {
        this.numeroPlazasReserva = numeroPlazasReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Actividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Actividad idActividad) {
        this.idActividad = idActividad;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
     /*public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }*/
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ies.torredelrey.modelo.Reservas[ id=" + id + " ]";
    }
    
}
