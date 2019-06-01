package es.uma.informatica.sii.hs.entidades;

import es.uma.informatica.sii.hs.entidades.Empleado;
import es.uma.informatica.sii.hs.entidades.Niño;
import es.uma.informatica.sii.hs.entidades.Usuario;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T10:45:38")
@StaticMetamodel(Carta.class)
public class Carta_ { 

    public static volatile SingularAttribute<Carta, Date> fechaEnvio;
    public static volatile SingularAttribute<Carta, Empleado> empleado;
    public static volatile SingularAttribute<Carta, byte[]> adjunto;
    public static volatile SingularAttribute<Carta, String> asunto;
    public static volatile SingularAttribute<Carta, Boolean> autorizado;
    public static volatile SingularAttribute<Carta, Date> fechaEntrega;
    public static volatile SingularAttribute<Carta, Niño> niño;
    public static volatile SingularAttribute<Carta, Usuario> usuario;
    public static volatile SingularAttribute<Carta, Long> id;
    public static volatile SingularAttribute<Carta, String> mensaje;
    public static volatile SingularAttribute<Carta, Boolean> emisor;

}