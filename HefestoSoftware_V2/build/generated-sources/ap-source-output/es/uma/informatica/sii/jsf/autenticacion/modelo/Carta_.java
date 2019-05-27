package es.uma.informatica.sii.jsf.autenticacion.modelo;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-27T22:19:48")
@StaticMetamodel(Carta.class)
public class Carta_ { 

    public static volatile SingularAttribute<Carta, Date> fechaEnvio;
    public static volatile SingularAttribute<Carta, Empleado> empleado;
    public static volatile SingularAttribute<Carta, byte[]> adjunto;
    public static volatile SingularAttribute<Carta, Boolean> autorizado;
    public static volatile SingularAttribute<Carta, String> asunto;
    public static volatile SingularAttribute<Carta, Date> fechaEntrega;
    public static volatile SingularAttribute<Carta, Niño> niño;
    public static volatile SingularAttribute<Carta, Usuario> usuario;
    public static volatile SingularAttribute<Carta, Long> id;
    public static volatile SingularAttribute<Carta, String> mensaje;
    public static volatile SingularAttribute<Carta, Boolean> emisor;

}