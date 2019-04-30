/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

/**
 *
 * @author yo
 */
public class Carta1 {

    private String asunto;
    private String niño;
    private int numero;
    private String mensaje;
    private String usuario;
    private String fecha;

    public Carta1(String asunto, String mensaje, String niño, String usuario, int numero, String fecha) {
        this.asunto = asunto;
        this.niño = niño;
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.numero = numero;
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getNiño() {
        return niño;
    }

    public void setNiño(String niño) {
        this.niño = niño;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
