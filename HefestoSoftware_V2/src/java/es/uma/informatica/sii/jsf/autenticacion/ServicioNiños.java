/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named
@SessionScoped
public class ServicioNiños implements Serializable {

    private List<Niño> niños;
    private int numeroNiños = 0;

    public ServicioNiños() {
        niños = new ArrayList<>();
        niños.add(new Niño("n"+(++numeroNiños),"Jose Manuel","Perez","Calle Pelaez 22","Comayagua",Date.valueOf("2000-01-17"),Date.valueOf("2017-10-22")));
        niños.add(new Niño("n"+(++numeroNiños),"Ana Maria","Jimenez","Calle Picaso 7","Catacamas",Date.valueOf("2004-11-12"),Date.valueOf("2017-10-24")));
        niños.add(new Niño("n"+(++numeroNiños),"Jose Alberto","Victoria","Calle España 10","Tela",Date.valueOf("2003-03-07"),Date.valueOf("2017-11-12")));
        niños.add(new Niño("n"+(++numeroNiños),"Patricia","Rodriguez","Calle Almeria 21","La Ceiba",Date.valueOf("2006-09-24"),Date.valueOf("2017-12-12")));
        niños.add(new Niño("n"+(++numeroNiños),"Alberto","Macias","Calle America 33","Trujillo",Date.valueOf("2006-05-20"),Date.valueOf("2017-12-27")));
    }

    public Niño obtenerNiño(String usuario) {
        for (Niño n : niños) {
            if (usuario.equals(n.getUsuario())) {
                return n;
            }
        }
        return null;
    }
    
    public void añadirNiño(String nombre,String apellidos,String direccion,String poblacion,Date fechaNacimiento) {
        niños.add(new Niño("n"+(++numeroNiños),nombre,apellidos,direccion,poblacion,fechaNacimiento,new Date(System.currentTimeMillis())));
    }
    
    public void delete(String usuario){
        niños.removeIf(n -> n.getUsuario().equals(usuario));
    }

    public List<Niño> getNiños() {
        return niños;
    }

    public void setNiños(List<Niño> niños) {
        this.niños = niños;
    }

    public int getNumeroNiños() {
        return numeroNiños;
    }

    public void setNumeroNiños(int numeroNiños) {
        this.numeroNiños = numeroNiños;
    }

}
