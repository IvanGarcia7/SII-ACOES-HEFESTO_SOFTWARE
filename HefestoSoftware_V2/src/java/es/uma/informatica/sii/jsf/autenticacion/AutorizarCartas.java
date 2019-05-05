/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import java.io.Serializable;
import java.util.LinkedList;
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
public class AutorizarCartas implements Serializable {

    private LinkedList<Carta> todas;
    private LinkedList<Carta> cartas;
    private Carta seleccionada;
    private String filtroAutor;
    private String filtroDestinatario;
    private String filtroAsunto;

    @Inject
    private ServicioCartas servicio;

    @PostConstruct
    public void init() {
        todas = servicio.cartasPorAutorizar();
        cartas = (LinkedList<Carta>) todas.clone();
    }

    public void autorizarCarta() {
        seleccionada.setAutorizado(true);
        seleccionada = null;
        todas = servicio.cartasPorAutorizar();
    }

    public void aplicarFiltros() {
        cartas = (LinkedList<Carta>) todas.clone();
        if (filtroAutor != null) {
            cartas.removeIf(c -> (!c.getEmisor() && !c.getNiño().getNombre().contains(filtroAutor))
                    || (c.getEmisor() && !c.getUsuario().getUsuario().contains(filtroAutor)));
        }
        if (filtroAsunto != null) {
            cartas.removeIf(c -> !c.getAsunto().contains(filtroAsunto));
        }
        if (filtroDestinatario != null) {
            cartas.removeIf(c -> (c.getEmisor() && !c.getNiño().getNombre().contains(filtroDestinatario))
                    || (!c.getEmisor() && !c.getUsuario().getUsuario().contains(filtroDestinatario)));
        }
    }

    public void quitarFiltros() {
        cartas = (LinkedList<Carta>) todas.clone();
        filtroAutor = null;
        filtroDestinatario = null;
        filtroAsunto = null;
    }

    public LinkedList<Carta> getTodas() {
        return todas;
    }

    public void setTodas(LinkedList<Carta> todas) {
        this.todas = todas;
    }

    public LinkedList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(LinkedList<Carta> cartas) {
        this.cartas = cartas;
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

    public Carta getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(Carta seleccionada) {
        this.seleccionada = seleccionada;
    }

}
