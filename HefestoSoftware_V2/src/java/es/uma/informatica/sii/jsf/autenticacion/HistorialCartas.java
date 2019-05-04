/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named
@ViewScoped
public class HistorialCartas {

    private List<Carta> enviadas;
    private List<Carta> recibidas;
    private Carta seleccionada;

    @Inject
    private ServicioCartas servicio;
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {
        enviadas = new ArrayList<>();
        recibidas = new ArrayList<>();
        servicio.obtenerHistorial(ctrl.getUsuario().getUsuario(), enviadas, recibidas);
    }

    public ServicioCartas getServicio() {
        return servicio;
    }

    public void setServicio(ServicioCartas servicio) {
        this.servicio = servicio;
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
