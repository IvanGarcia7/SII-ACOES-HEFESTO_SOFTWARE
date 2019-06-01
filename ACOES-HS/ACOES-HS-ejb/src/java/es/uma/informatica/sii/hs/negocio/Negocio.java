package es.uma.informatica.sii.hs.negocio;

import es.uma.informatica.sii.hs.entidades.Carta;
import es.uma.informatica.sii.hs.entidades.Niño;
import es.uma.informatica.sii.hs.entidades.Peticion;
import es.uma.informatica.sii.hs.entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface Negocio {

    public void registrarUsuario(Usuario u) throws AcoesException;

    public void compruebaLogin(Usuario u) throws AcoesException;

    public Usuario refrescarUsuario(Usuario u) throws AcoesException;

    public void añadirCarta(Carta carta);

    public List<Niño> obtenerNiñosApadrinados(Usuario usuario);

    public List<Carta> obtenerCartasRecibidas(Usuario usuario);

    public List<Carta> obtenerCartasEnviadas(Usuario usuario);

    public void enviarPeticion(Peticion peticion);

}
