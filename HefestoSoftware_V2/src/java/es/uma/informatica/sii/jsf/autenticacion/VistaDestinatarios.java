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
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named(value = "vistaDestinatarios")
@ViewScoped
public class VistaDestinatarios implements Serializable {

    private List<Niño> destinatarios;

    @EJB
    private Negocio negocio;
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {
        destinatarios = negocio.obtenerNiñosApadrinados(ctrl.getUsuario());
    }

    public List<Niño> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<Niño> destinatarios) {
        this.destinatarios = destinatarios;
    }

   

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }

}
