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
 * @author Miguel
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
        Niño n5 = sn.obtenerNiño("n5");
        Usuario u1 = new Usuario("pepe", "asdf", Usuario.Rol.NORMAL);
        Usuario u2 = new Usuario("antonio", "asdf", Usuario.Rol.NORMAL);
        cartas.add(new Carta(n1, u1, "Hola", "Soy tu nuevo padrino", "2018-01-01", true,true));
        cartas.add(new Carta(n1, u1, "Gracias por adoptarme", "Es un placer", "2018-02-01", false,true));
        cartas.add(new Carta(n1, u1, "Mis ultimas notas", "He sacado todo 10", "2018-03-01", false));
        cartas.add(new Carta(n1, u1, "Re: Mis ultimas notas", "Bueno menos una asignatura", "2018-03-01", false));
        cartas.add(new Carta(n2, u1, "Saludos", "Cuanto tiempo,como estas?", "2018-03-02", true,true));
        cartas.add(new Carta(n2, u1, "Buenas", "Estoy bien", "2018-03-02", false,true));
        cartas.add(new Carta(n2, u1, "Regalo de cuempleaños", "Voy a enviarte dinero", "2018-03-03", true));
        cartas.add(new Carta(n3, u1, "Las cosas por Honduras", "Estan muy mal", "2018-07-03", false,true));
        cartas.add(new Carta(n3, u1, "Dinero", "Me vendria bien algo de dinero", "2018-07-03", false,true));
        cartas.add(new Carta(n3, u1, "Vale", "Te mandare algo cuando pueda", "2018-07-15", true,true));
        cartas.add(new Carta(n3, u1, "Guay", "Vale guay, muchas gracias", "2018-07-20", false));
        cartas.add(new Carta(n3, u1, "Hace tiempo que no hablamos", "Te ha pasado algo?", "2018-07-05", true));
        cartas.add(new Carta(n4, u1, "¿Como van las cosas por Honduras?", "Espero que mejor", "2018-09-05", true));
        cartas.add(new Carta(n4, u2, "Malas noticias", "Me he roto la pierna", "2018-09-06", false));
        cartas.add(new Carta(n4, u2, "Como estais en España?", "Pues eso", "2018-10-07", false));
        cartas.add(new Carta(n5, u2, "Que onda", "Me han dicho que es mi nuevo padrino", "2018-12-07", false));
        cartas.add(new Carta(n5, u2, "Presentacion", "Soy tu nuevo padrino", "2018-12-08", false));
        cartas.add(new Carta(n5, u2, "Feliz navidad", "Feliz navidad", "2018-12-24", false));
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
