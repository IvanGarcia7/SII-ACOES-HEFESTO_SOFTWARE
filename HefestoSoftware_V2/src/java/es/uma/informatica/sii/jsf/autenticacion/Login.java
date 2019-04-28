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

/**
 *
 * @author francis
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;
    private Usuario actual;
    
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("pepe", "asdf", Rol.NORMAL));
        usuarios.add(new Usuario("manolo", "qwer", Rol.ADMINISTRADOR));
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String autenticar() {
        boolean encontrado = false;
        int i=0;
        
        //Mientras no encuentre al usuario, sigo recorriendo la lista.
        
        while(i<usuarios.size() && encontrado==false){
            actual = usuarios.get(i);
            if(actual.getUsuario().equals(usuario) && actual.getContrasenia().equals(contrasenia)){
                encontrado=true;
            }
            i++;
        }
        
        if(encontrado){
            ctrl.setUsuario(actual);
            return ctrl.home();
        }else{
            return "error.xhtml";
        }
        
    }
    
    public String reinicio()
    {
        return "login.xhtml";
    }
}
