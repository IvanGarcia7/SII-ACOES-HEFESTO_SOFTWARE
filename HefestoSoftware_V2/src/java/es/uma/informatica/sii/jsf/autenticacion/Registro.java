/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private List<Usuario> usuarios;
    private Usuario actual;
    
   

    /**
     * Creates a new instance of Login
     */
    public Registro() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("pepe", "asdf","pepe@yahoo.com", Rol.NORMAL));
        usuarios.add(new Usuario("angel", "qwer","angelysaras@yahoo.com", Rol.NORMAL));
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

    public String valido() {
        boolean encontrado = false;
        int i=0;
        
        //Mientras no encuentre al usuario, sigo recorriendo la lista.
        
        while(i<usuarios.size() && encontrado==false){
            actual = usuarios.get(i);
            if(actual.getUsuario().equals(usuario) || actual.getCorreoElectronico().equals(correoele)){
                encontrado=true;
            }
            i++;
        }
        
        if(!encontrado && contrasenia.equals(contrasenia2)){
           return "login.xhtml";
        }else{
            return "errorregistro.xhtml";
        }
        
    }
    
    public String reinicio()
    {
        return "login.xhtml";
    }
}
