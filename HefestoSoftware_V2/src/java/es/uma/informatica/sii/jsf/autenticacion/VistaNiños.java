/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
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
public class VistaNiños implements Serializable {

    private List<Niño> niños;

    @EJB
    private NegocioAdmin negocio;

    @PostConstruct
    public void init() {
        niños = negocio.obtenerNiños();
    }

    public void eliminar(Niño niño) {
        negocio.eliminarNiño(niño);
        niños = negocio.obtenerNiños();
    }

    public void modificar(RowEditEvent event) {
        negocio.modificarNiño((Niño) event.getObject());
    }

    public List<Niño> getNiños() {
        return niños;
    }

    public void setNiños(List<Niño> niños) {
        this.niños = niños;
    }

    public NegocioAdmin getNegocio() {
        return negocio;
    }

    public void setNegocio(NegocioAdmin negocio) {
        this.negocio = negocio;
    }
}
