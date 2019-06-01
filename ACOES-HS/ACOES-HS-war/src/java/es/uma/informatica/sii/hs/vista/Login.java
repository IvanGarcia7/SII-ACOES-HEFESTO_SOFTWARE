/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.hs.vista;


import es.uma.informatica.sii.hs.entidades.Usuario;
import es.uma.informatica.sii.hs.negocio.AcoesException;
import es.uma.informatica.sii.hs.negocio.ContraseniaInvalidaException;
import es.uma.informatica.sii.hs.negocio.CuentaInexistenteException;
import es.uma.informatica.sii.hs.negocio.Negocio;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "login")
@RequestScoped
public class Login {

    @Inject
    private InfoSesion sesion;
    
    @EJB
    private Negocio negocio;
    
    private Usuario usuario;
   
    @Inject
    private ControlAutorizacion ctrl;
    

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String entrar() throws AcoesException {
        try {
            
            negocio.compruebaLogin(usuario);
            ctrl.setUsuario(usuario);
            ctrl.setLogeado(true);
            return "normal.xhtml";
            
        } catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return "error.xhtml";
    }
    
    public String reinicio(){
        return "login.xhtml";
    }

}
