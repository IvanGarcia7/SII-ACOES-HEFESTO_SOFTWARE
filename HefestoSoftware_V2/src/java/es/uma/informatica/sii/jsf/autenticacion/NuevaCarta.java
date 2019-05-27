/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Date;
import javax.ejb.EJB;

/**
 *
 * @author Miguel
 */
@Named(value="nuevaCarta")
@RequestScoped
public class NuevaCarta {
    private Carta carta;
    
   
    @Inject
    private ControlAutorizacion ctrl;
    
    @EJB
    private Negocio negocio;
    
    public NuevaCarta(){
        carta = new Carta();
    }
    
    public void enviarCarta(){
        carta.setUsuario(ctrl.getUsuario());
        carta.setEmisor(true);
        carta.setFechaEnvio(new Date(System.currentTimeMillis()));
        negocio.añadirCarta(carta);
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }


    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
}
