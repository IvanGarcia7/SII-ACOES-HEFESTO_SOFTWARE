/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion.modelo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author Miguel
 */
@Entity
public class Carta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50, nullable = false)
    private String asunto;
    @Column(length = 1000, nullable = false)
    private String mensaje;
    @Lob
    private byte[] adjunto;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Niño niño;
    @ManyToOne
    @JoinColumn
    private Empleado empleado;
    @ManyToOne
    private Usuario usuario;
    @Column(nullable = false, name = "fecha_envio")
    private Date fechaEnvio;
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;
    @Column(nullable = false)
    private Boolean emisor;
    @Column(nullable = false)
    private Boolean autorizado;
    @Transient
    private static int numeroCartas = 0;

    public Carta() {
        autorizado = false;
        id = new Long(++numeroCartas);
    }
    
    public Carta(Niño niño,Usuario usuario,String asunto,String mensaje,String fechaEnvio,Boolean emisor) {
        this.asunto = asunto;
        this.niño = niño;
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.fechaEnvio = Date.valueOf(fechaEnvio);
        this.id = new Long(++numeroCartas);
        this.emisor = emisor;
        autorizado = false;
    }
    
    public Carta(Niño niño,Usuario usuario,String asunto,String mensaje,String fechaEnvio,Boolean emisor,Boolean autorizado) {
        this.asunto = asunto;
        this.niño = niño;
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.fechaEnvio = Date.valueOf(fechaEnvio);
        this.id = new Long(++numeroCartas);
        this.emisor = emisor;
        this.autorizado = autorizado;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public byte[] getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(byte[] adjunto) {
        this.adjunto = adjunto;
    }

    public Niño getNiño() {
        return niño;
    }

    public void setNiño(Niño niño) {
        this.niño = niño;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Boolean getEmisor() {
        return emisor;
    }

    public void setEmisor(Boolean emisor) {
        this.emisor = emisor;
    }

    public Boolean getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Boolean autorizado) {
        this.autorizado = autorizado;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Carta)) {
            return false;
        }
        Carta other = (Carta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hefestosoftware.Carta[ id=" + id + " ]";
    }
    
}
