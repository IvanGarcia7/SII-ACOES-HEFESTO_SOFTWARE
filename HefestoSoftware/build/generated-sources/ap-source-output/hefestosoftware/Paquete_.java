package hefestosoftware;

import hefestosoftware.HistorialPaquetes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T12:44:50")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, String> descripcion;
    public static volatile SingularAttribute<Paquete, byte[]> adjunto;
    public static volatile SingularAttribute<Paquete, HistorialPaquetes> historial;
    public static volatile SingularAttribute<Paquete, Long> id;
    public static volatile SingularAttribute<Paquete, String> origen;
    public static volatile SingularAttribute<Paquete, String> destino;

}