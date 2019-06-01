/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.hs.vista;


import es.uma.informatica.sii.hs.entidades.Carta;
import es.uma.informatica.sii.hs.negocio.NegocioAdmin;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Antonio Manuel
 */
@Named(value = "vistaCartas")
@ViewScoped
public class VistaCartas implements Serializable {

    private List<Carta> cartas;
    private String filtroDestinatario;
   
    @EJB
    private NegocioAdmin negocioAdmin;
   
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {

        if (ctrl.getEmpleado() != null) {
            cartas = negocioAdmin.obtenerCartas();
        }

    }
    
    public void aplicarFiltros() {
        cartas = new LinkedList<>(cartas);
        
        if (filtroDestinatario != null) {
            cartas.removeIf(c -> (c.getEmisor() && !c.getNiño().getNombre().contains(filtroDestinatario))
                    || (!c.getEmisor() && !c.getUsuario().getUsuario().contains(filtroDestinatario)));
        }
    }
    
    public void quitarFiltros() {
        cartas = new LinkedList<>(cartas);
       
        filtroDestinatario = null;
        
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

   

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }

}
