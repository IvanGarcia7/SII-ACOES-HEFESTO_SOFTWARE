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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named(value="vistaCartas")
@ViewScoped
public class VistaCartas implements Serializable{
    private List<Carta> cartas;
    private Carta cartaSeleccionada;
    
    @Inject
    private ServicioCartas servicio;
    @Inject
    private ControlAutorizacion ctrl;
    
    @PostConstruct
    public void init(){
        cartas = servicio.obtenerHistorial(ctrl.getUsuario().getUsuario());
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public ServicioCartas getServicio() {
        return servicio;
    }

    public void setServicio(ServicioCartas servicio) {
        this.servicio = servicio;
    }

    public Carta getCartaSeleccionada() {
        return cartaSeleccionada;
    }

    public void setCartaSeleccionada(Carta cartaSeleccionada) {
        this.cartaSeleccionada = cartaSeleccionada;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    public String mostrarCartaActual(){
        if(cartaSeleccionada==null){
            return "Cada vez que se pulsa en una de las filas, se muestra la carta de dicho niño en esta area.";
        }else{
            return cartaSeleccionada.getMensaje();
        }
    }
    
}
