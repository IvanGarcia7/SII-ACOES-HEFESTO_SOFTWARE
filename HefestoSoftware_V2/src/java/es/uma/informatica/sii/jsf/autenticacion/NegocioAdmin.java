package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import es.uma.informatica.sii.jsf.autenticacion.modelo.HistorialPadrinos;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Paquete;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Peticion;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Local;
@Local
public interface NegocioAdmin {

    public void compruebaLoginEmpleado(Empleado empleado) throws AcoesException;

    public Niño obtenerNiño(String niño);
    
    public void añadirNiño(Niño niño);
    
    public void eliminarNiño(Niño niño);
    
    public void modificarNiño(Niño niño);
    
    public List<Niño> obtenerNiños();

    public Usuario obtenerUsuario(String usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
    public void modificarUsuario(Usuario usuario);
    
    public List<Usuario> obtenerUsuarios();
    
    public void escribirPaquete(Paquete paquete);
    
    public List<Paquete> obtenerPaquetes();
    
    public void añadirCarta(Carta carta);
   
    public List<HistorialPadrinos> obtenerApadrinamientos(String niño);
    
    public List<Peticion> obtenerPeticiones(String usuario);
    
    public LinkedList<Carta> cartasPorAutorizar();

    public void autorizarCarta(Carta carta);

    public List<Carta> obtenerCartas();
    
    public boolean esPadrino(Niño niño, Usuario usuario);

    public List<Empleado> obtenerEmpleados();

    public void eliminarEmpleado(Empleado empleado);

    public void modificarEmpleado(Empleado empleado);

    public void añadirEmpleado(Empleado empleado);
    
}

