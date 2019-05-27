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

/**
 *
 * @author Miguel
 */
@Entity
public class Paquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private byte[] adjunto;
    @Column(length = 500, nullable = false)
    private String descripcion;
    @Column(length = 100, nullable = false)
    private String origen;
    @Column(length = 100, nullable = false)
    private String destino;
    @Column(nullable = false, name = "fecha_envio")
    private Date fechaEnvio;
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;
    private String estado;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Empleado empleado;

    public Paquete(){
        
    }
    
    public Paquete(Long id, String descripcion, String fechaEnvio, String estado){
        this.id = id;
        this.descripcion = descripcion;
        this.fechaEnvio = Date.valueOf(fechaEnvio);
        this.estado = estado;
        
    }
    
    
    public byte[] getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(byte[] adjunto) {
        this.adjunto = adjunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Paquete)) {
            return false;
        }
        Paquete other = (Paquete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hefestosoftware.Paquete[ id=" + id + " ]";
    }
    
}
