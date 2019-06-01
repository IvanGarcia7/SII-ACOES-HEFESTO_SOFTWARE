package es.uma.informatica.sii.hs.entidades;

import es.uma.informatica.sii.hs.entidades.Empleado;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T10:45:38")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, String> descripcion;
    public static volatile SingularAttribute<Paquete, String> estado;
    public static volatile SingularAttribute<Paquete, Date> fechaEnvio;
    public static volatile SingularAttribute<Paquete, Empleado> empleado;
    public static volatile SingularAttribute<Paquete, byte[]> adjunto;
    public static volatile SingularAttribute<Paquete, Date> fechaEntrega;
    public static volatile SingularAttribute<Paquete, Long> id;
    public static volatile SingularAttribute<Paquete, String> origen;
    public static volatile SingularAttribute<Paquete, String> destino;

}