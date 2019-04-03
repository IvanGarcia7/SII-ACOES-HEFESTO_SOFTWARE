package hefestosoftware;

import hefestosoftware.Empleado;
import hefestosoftware.HistorialCartas;
import hefestosoftware.Niño;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T00:06:19")
@StaticMetamodel(Carta.class)
public class Carta_ { 

    public static volatile SingularAttribute<Carta, Empleado> empleado;
    public static volatile SingularAttribute<Carta, byte[]> adjunto;
    public static volatile SingularAttribute<Carta, String> asunto;
    public static volatile SingularAttribute<Carta, HistorialCartas> historial;
    public static volatile SingularAttribute<Carta, Niño> niño;
    public static volatile SingularAttribute<Carta, Long> id;
    public static volatile SingularAttribute<Carta, String> mensaje;

}