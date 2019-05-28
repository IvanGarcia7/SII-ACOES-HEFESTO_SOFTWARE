package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
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
    
    
}

