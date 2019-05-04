/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import es.uma.informatica.sii.jsf.autenticacion.modelo.HistorialPadrinos;
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
@Named(value="servicioSolicitudes")
@SessionScoped
public class ServicioSolicitudes implements Serializable{
   private List<HistorialPadrinos> solicitudes;

    public ServicioSolicitudes() {
        solicitudes = new ArrayList<HistorialPadrinos>();
        Usuario u1 = new Usuario("pepe","asdf",Usuario.Rol.NORMAL);
        Usuario u2 = new Usuario("manolo","qwer",Usuario.Rol.ADMINISTRADOR);
        Usuario u3 = new Usuario("Adela Ramírez Rueda","qwer",Usuario.Rol.NORMAL);
        Usuario u4 = new Usuario("Alfonso Pérez Romero","qwer",Usuario.Rol.NORMAL);
        HistorialPadrinos p1 = new HistorialPadrinos(u3,new Long(1),"01/02/2018");
        HistorialPadrinos p2 = new HistorialPadrinos(u3,new Long(2),"11/03/2018");
        HistorialPadrinos p3 = new HistorialPadrinos(u4,new Long(3),"23/05/2018");
        HistorialPadrinos p4 = new HistorialPadrinos(u4,new Long(4),"24/08/2018");
        solicitudes.add(p1);
        solicitudes.add(p2);
        solicitudes.add(p3);
        solicitudes.add(p4);
    }

    public List<HistorialPadrinos> obtenerHistorial(String usuario) {
        List<HistorialPadrinos> historial = new ArrayList<>();
        for(HistorialPadrinos s : solicitudes) {
            if (usuario.equals(s.getUsuario().getUsuario())) {
                historial.add(s);
            }
        }
        return historial;
    }
    
    public void añadirSolicitud(HistorialPadrinos s){
        solicitudes.add(s);
    }

    public List<HistorialPadrinos> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<HistorialPadrinos> solicitudes) {
        this.solicitudes = solicitudes;
    }
}
