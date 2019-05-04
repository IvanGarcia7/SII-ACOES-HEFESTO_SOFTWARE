/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "registro")
@RequestScoped
public class Registro {

    private String usuario;
    private String correoele;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private String telefono;
    private String contrasenia;
    private String contrasenia2;

    @Inject
    private ServicioUsuarios servicio;

    /**
     * Creates a new instance of Registro
     */
    public Registro() {

    }

    public String getUsuario() {
        return usuario;
    }

    public String getCorreoele() {
        return correoele;
    }

    public void setCorreoele(String correoele) {
        this.correoele = correoele;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getContrasenia2() {
        return contrasenia2;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setContrasenia2(String contrasenia2) {
        this.contrasenia2 = contrasenia2;
    }

    public ServicioUsuarios getServicio() {
        return servicio;
    }

    public void setServicio(ServicioUsuarios servicio) {
        this.servicio = servicio;
    }
    
    public String valido() {
        if (servicio.obtenerUsuario(usuario) == null && servicio.correoDisponible(correoele) && contrasenia.equals(contrasenia2)) {
            Usuario nuevo = new Usuario(usuario,contrasenia,nombre,apellidos,correoele,domicilio,telefono,Rol.NORMAL);
            servicio.añadirUsuario(nuevo);
            return "login.xhtml";
        } else {
            return "errorregistro.xhtml";
        }
    }

    public String reinicio() {
        return "login.xhtml";
    }
}
