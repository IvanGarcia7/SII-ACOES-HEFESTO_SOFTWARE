/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Peticion;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.sql.Date;
import java.util.Calendar;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Antonio Manuel
 */

@Named(value = "escribirPeticion")
@ManagedBean
@RequestScoped
public class EscribirPeticion {
    @EJB
    private Negocio negocio;
    
    private Peticion peticion = new Peticion();
    
    @Inject
    private ControlAutorizacion ctrl;

    public Peticion getPeticion() {
        return peticion;
    }

    public void setPeticion(Peticion peticion) {
        this.peticion = peticion;
    }
    
    public void enviarPeticion(){
        peticion.setTipo(Boolean.TRUE);
        peticion.setFechaPeticion(new Date(Calendar.getInstance().getTime().getTime()));
        peticion.setUsuario(ctrl.getUsuario());
        negocio.enviarPeticion(peticion);
    }
}
