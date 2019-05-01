/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author yo
 */
@Named(value="servicioCartas")
@SessionScoped
public class ServicioCartas implements Serializable{
   private List<Carta> cartas;

    public ServicioCartas() {
        cartas = new ArrayList<Carta>();
        Niño n1 = new Niño("Jose Manuel","Perez");
        Niño n2 = new Niño("Ana Maria","Jimenez");
        Niño n3 = new Niño("Jose Alberto","Victoria");
        Niño n4 = new Niño("Patricia","Rodriguez");
        Usuario u1 = new Usuario("pepe","asdf",Usuario.Rol.NORMAL);
        Usuario u2 = new Usuario("antonio","asdf",Usuario.Rol.NORMAL);
        cartas.add(new Carta(n1,u1,"asunto1", "mensaje1","2018-01-01",1));
        cartas.add(new Carta(n2,u1,"asunto2", "mensaje2","2018-03-02",2));
        cartas.add(new Carta(n3,u1,"asunto3", "mensaje3","2018-07-03",3));
        cartas.add(new Carta(n4,u1,"asunto4", "mensaje4","2018-09-05",4));
        cartas.add(new Carta(n4,u2,"asunto5", "mensaje5","2018-09-06",5));
    }

    public List<Carta> obtenerHistorial(String usuario) {
        List<Carta> historial = new ArrayList<>();
        for(Carta c : cartas) {
            if (usuario.equals(c.getUsuario().getUsuario())) {
                historial.add(c);
            }
        }
        return historial;
    }
    
    public void añadirCarta(Carta c){
        cartas.add(c);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}
