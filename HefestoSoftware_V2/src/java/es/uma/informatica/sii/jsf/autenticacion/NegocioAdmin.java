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

    public List<Niño> obtenerNiños();

    public List<Usuario> obtenerUsuarios();

    public void eliminarNiño(Niño niño);

    public void eliminarUsuario(Usuario usuario);

    public Usuario obtenerUsuario(String usuario);

    public Niño obtenerNiño(String niño);
    
    public void escribirPaquete(Paquete paquete);
    
    public List<Paquete> obtenerPaquetes();
    
    public void añadirCarta(Carta carta);
   
    public List<HistorialPadrinos> obtenerApadrinamientos(String niño);
    
    public List<Peticion> obtenerPeticiones(String usuario);
    
    public LinkedList<Carta> cartasPorAutorizar();

    public void autorizarCarta(Carta carta);

    public List<Carta> obtenerCartas();
}

