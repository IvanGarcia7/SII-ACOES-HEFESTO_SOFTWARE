/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named(value = "vistaCartas")
@ViewScoped
public class VistaCartas implements Serializable {

    private LinkedList<Carta> cartas;
    private List<Carta> enviadas;
    private List<Carta> recibidas;
    private LinkedList<Carta> cartasMostradas;
    private Carta cartaSeleccionada;
    private String filtroAutor;
    private String filtroDestinatario;
    private String filtroAsunto;

    @Inject
    private ServicioCartas servicio;
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {
        if (ctrl.getUsuario().getRol() == Rol.NORMAL) {
            cartas = servicio.obtenerHistorial(ctrl.getUsuario().getUsuario());
            obtenerCartasRecibidas();
            obtenerCartasEnviadas();
        } else if (ctrl.getUsuario().getRol() == Rol.ADMINISTRADOR) {
            cartas = servicio.cartasPorAutorizar();
            cartasMostradas = (LinkedList<Carta>) cartas.clone();
        }
    }

    public LinkedList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(LinkedList<Carta> cartas) {
        this.cartas = cartas;
    }

    public LinkedList<Carta> getCartasMostradas() {
        return cartasMostradas;
    }

    public void setCartasMostradas(LinkedList<Carta> cartasMostradas) {
        this.cartasMostradas = cartasMostradas;
    }

    public String getFiltroAutor() {
        return filtroAutor;
    }

    public void setFiltroAutor(String filtroAutor) {
        this.filtroAutor = filtroAutor;
    }

    public String getFiltroDestinatario() {
        return filtroDestinatario;
    }

    public void setFiltroDestinatario(String filtroDestinatario) {
        this.filtroDestinatario = filtroDestinatario;
    }

    public String getFiltroAsunto() {
        return filtroAsunto;
    }

    public void setFiltroAsunto(String filtroAsunto) {
        this.filtroAsunto = filtroAsunto;
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

    public void autorizarCartaActual() {
        cartaSeleccionada.setAutorizado(true);
        cartaSeleccionada = null;
        cartas = servicio.cartasPorAutorizar();
    }

    private void obtenerCartasEnviadas() {
        enviadas = new ArrayList<>();
        for (Carta c : cartas) {
            if (c.getEmisor()) {
                enviadas.add(c);
            }
        }
    }

    private void obtenerCartasRecibidas() {
        recibidas = new ArrayList<>();
        for (Carta c : cartas) {
            if (!c.getEmisor()) {
                recibidas.add(c);
            }
        }
    }

    public void aplicarFiltros() {
        cartasMostradas = (LinkedList<Carta>) cartas.clone();
        if (filtroAutor != null) {
            cartasMostradas.removeIf(c -> (!c.getEmisor() && !c.getNiño().getNombre().contains(filtroAutor))
                    || (c.getEmisor() && !c.getUsuario().getUsuario().contains(filtroAutor)));
        }
        if (filtroAsunto != null) {
            cartasMostradas.removeIf(c -> !c.getAsunto().contains(filtroAsunto));
        }
        if (filtroDestinatario != null) {
            cartasMostradas.removeIf(c -> (c.getEmisor() && !c.getNiño().getNombre().contains(filtroDestinatario))
                    || (!c.getEmisor() && !c.getUsuario().getUsuario().contains(filtroDestinatario)));
        }
    }

    public void quitarFiltros() {
        cartasMostradas = (LinkedList<Carta>) cartas.clone();
        filtroAutor = null;
        filtroDestinatario = null;
        filtroAsunto = null;
    }

}
