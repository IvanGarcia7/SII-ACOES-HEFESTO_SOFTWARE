/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Antonio Manuel
 */
@Entity
public class Usuario implements Serializable {

    public Usuario(String usuario, String contrasenia) {
        setUsuario(usuario);
        setContrasenia(contrasenia);
    }

    public Usuario(String usuario, String contrasenia, String correo) {
        setUsuario(usuario);
        setContrasenia(contrasenia);
        setCorreoElectronico(correo);
    }
    
    public Usuario(String usuario, String contraseña, String nombre, String apellidos, String correo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correo;
    }

    public Usuario(String usuario, String contraseña, String nombre, String apellidos, String correo, String direccion, String telefono) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(length = 30)
    private String usuario;
    @Column(length = 30, nullable = false)
    private String contraseña;
    @Column(length = 30, nullable = false)
    private String nombre;
    @Column(length = 60, nullable = false)
    private String apellidos;
    @Column(length = 9, unique = true, nullable = false)
    private String dni;
    @Column(length = 150, nullable = false)
    private String direccion;
    @Column(length = 200, nullable = false)
    private String poblacion;
    @Column(name = "codigo_postal",length = 5,nullable = false)
    private Integer codigoPostal;
    @Column(length = 30, nullable = false)
    private String provincia;
    @Column(length = 15, nullable = false)
    private String telefono;
    @Column(name = "correo_electronico",length = 60, nullable = false, unique = true)
    private String correoElectronico;
    @Column(name = "fecha_alta",nullable = false)
    private Date fechaAlta;
    @Column(name = "fecha_baja")
    private Date fechaBaja;
    @Column(length = 500)
    private String descripcion;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Peticion> Peticiones;
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Set<Peticion> getPeticiones() {
        return Peticiones;
    }

    public void setPeticiones(Set<Peticion> Peticiones) {
        this.Peticiones = Peticiones;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contraseña;
    }

    public void setContrasenia(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return this.usuario != null && other.usuario != null && this.usuario.equals(other.usuario);
    }

    @Override
    public String toString() {
        return "hefestosoftware.Usuario[ usuario=" + usuario + " ]";
    }
    
}
