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
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author yo
 */
@Named(value="servicioCartas")
@SessionScoped
public class ServicioCartas implements Serializable {

    private List<Carta> cartas;

    @Inject
    private ServicioNiños sn;

    @PostConstruct
    public void init() {
        cartas = new ArrayList<Carta>();
        Niño n1 = sn.obtenerNiño("n1");
        Niño n2 = sn.obtenerNiño("n2");
        Niño n3 = sn.obtenerNiño("n3");
        Niño n4 = sn.obtenerNiño("n4");
        Usuario u1 = new Usuario("pepe", "asdf", Usuario.Rol.NORMAL);
        Usuario u2 = new Usuario("antonio", "asdf", Usuario.Rol.NORMAL);
        cartas.add(new Carta(n1, u1, "asunto1", "mensaje1", "2018-01-01", true));
        cartas.add(new Carta(n2, u1, "asunto2", "mensaje2", "2018-03-02", true));
        cartas.add(new Carta(n3, u1, "asunto3", "mensaje3", "2018-07-03", false));
        cartas.add(new Carta(n4, u1, "asunto4", "mensaje4", "2018-09-05", true));
        cartas.add(new Carta(n4, u2, "asunto5", "mensaje5", "2018-09-06", false));
    }

    public List<Carta> obtenerHistorial(String usuario) {
        List<Carta> historial = new ArrayList<>();
        for (Carta c : cartas) {
            if (usuario.equals(c.getUsuario().getUsuario())) {
                if (c.getAutorizado()) {
                    historial.add(c);
                } else {
                    if (c.getEmisor()) {
                        historial.add(c);
                    }
                }
            }
        }
        return historial;
    }

    public List<Carta> cartasPorAutorizar() {
        List<Carta> pendientes = new ArrayList<Carta>();
        for (Carta c : cartas) {
            if (!c.getAutorizado()) {
                pendientes.add(c);
            }
        }
        return pendientes;
    }

    public void añadirCarta(Carta c) {
        cartas.add(c);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public ServicioNiños getSn() {
        return sn;
    }

    public void setSn(ServicioNiños sn) {
        this.sn = sn;
    }
    
}
