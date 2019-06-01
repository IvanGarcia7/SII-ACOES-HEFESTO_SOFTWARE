/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.hs.vista;


import es.uma.informatica.sii.hs.entidades.Usuario;
import es.uma.informatica.sii.hs.negocio.NegocioAdmin;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Miguel
 */
@Named
@ViewScoped
public class VistaUsuarios implements Serializable {

    private List<Usuario> usuarios;
    private boolean inactivos;

    @EJB
    private NegocioAdmin negocio;

    @PostConstruct
    public void init() {
        actualizar();
    }

    public void actualizar() {
        if (inactivos) {
            usuarios = negocio.obtenerUsuarios();
        } else {
            usuarios = negocio.obtenerUsuariosActivos();
        }
    }

    public void suspender(Usuario usuario) {
        negocio.suspenderUsuario(usuario);
        actualizar();
    }

    public void modificar(RowEditEvent event) {
        negocio.modificarUsuario((Usuario) event.getObject());
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean isInactivos() {
        return inactivos;
    }

    public void setInactivos(boolean inactivos) {
        this.inactivos = inactivos;
    }

    public NegocioAdmin getNegocio() {
        return negocio;
    }

    public void setNegocio(NegocioAdmin negocio) {
        this.negocio = negocio;
    }

}
