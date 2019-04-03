package hefestosoftware;

import hefestosoftware.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T00:06:19")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, String> descripcion;
    public static volatile SingularAttribute<Paquete, Empleado> empleado;
    public static volatile SingularAttribute<Paquete, byte[]> adjunto;
    public static volatile SingularAttribute<Paquete, Long> id;
    public static volatile SingularAttribute<Paquete, String> origen;
    public static volatile SingularAttribute<Paquete, String> destino;

}