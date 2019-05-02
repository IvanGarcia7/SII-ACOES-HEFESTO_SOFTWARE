/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Paquete;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Antonio Manuel
 */
@Named(value="servicioPaquetes")
@SessionScoped
public class ServicioPaquetes implements Serializable{
   private List<Paquete> paquetes;

    public ServicioPaquetes() {
        paquetes = new ArrayList<Paquete>();
        Paquete p1 = new Paquete(new Long(1),"Medicamentos varios","01/02/2018","Aceptado");
        Paquete p2 = new Paquete(new Long(2),"Latas de comida","11/03/2018","Aceptado");
        Paquete p3 = new Paquete(new Long(3),"Tiritas","23/05/2018","Aceptado");
        Paquete p4 = new Paquete(new Long(4),"Herramientas enfermería","24/08/2018","Aceptado");
        Usuario u1 = new Usuario("pepe","asdf",Usuario.Rol.NORMAL);
        Usuario u2 = new Usuario("manolo","qwer",Usuario.Rol.ADMINISTRADOR);
        paquetes.add(p1);
        paquetes.add(p2);
        paquetes.add(p3);
        paquetes.add(p4);
    }

    public List<Paquete> obtenerHistorial(String usuario) {
        List<Paquete> historial = new ArrayList<>();
        for(Paquete p : paquetes) {
            if (usuario.equals(p.getEmpleado())) {
                historial.add(p);
            }
        }
        return historial;
    }
    
    public void añadirPaquete(Paquete p){
        paquetes.add(p);
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
}
