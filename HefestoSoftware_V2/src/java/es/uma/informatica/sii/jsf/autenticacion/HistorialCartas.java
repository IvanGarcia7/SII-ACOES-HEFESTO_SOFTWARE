/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
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

@Named
@ViewScoped
public class HistorialCartas implements Serializable {

    private List<Carta> enviadas;
    private List<Carta> recibidas;
    private Carta seleccionada;

    @EJB
    private Negocio negocio;
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {
        enviadas = negocio.obtenerCartasEnviadas(ctrl.getUsuario());
        recibidas = negocio.obtenerCartasRecibidas(ctrl.getUsuario());
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public Carta getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(Carta seleccionada) {
        this.seleccionada = seleccionada;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }

    public List<Carta> getEnviadas() {
        return enviadas;
    }

    public void setEnviadas(List<Carta> enviadas) {
        this.enviadas = enviadas;
    }

    public List<Carta> getRecibidas() {
        return recibidas;
    }

    public void setRecibidas(List<Carta> recibidas) {
        this.recibidas = recibidas;
    }

}