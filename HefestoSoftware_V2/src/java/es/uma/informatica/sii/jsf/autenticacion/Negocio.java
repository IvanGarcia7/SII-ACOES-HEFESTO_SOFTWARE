
package es.uma.informatica.sii.jsf.autenticacion;


import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.util.List;
import javax.ejb.Local;


@Local
public interface Negocio {
    public void registrarUsuario(Usuario u)throws AcoesException;
    public void compruebaLogin(Usuario u) throws AcoesException;
    public Usuario refrescarUsuario(Usuario u) throws AcoesException;

    public void añadirCarta(Carta carta);

    public List<Niño> obtenerNiñosApadrinados(Usuario usuario);

    
   
}

