package hefestosoftware;

import hefestosoftware.Paquete;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T14:37:55")
@StaticMetamodel(HistorialPaquetes.class)
public class HistorialPaquetes_ { 

    public static volatile SingularAttribute<HistorialPaquetes, String> descripcion;
    public static volatile SingularAttribute<HistorialPaquetes, Boolean> estado;
    public static volatile SingularAttribute<HistorialPaquetes, Date> fechaEnvio;
    public static volatile SingularAttribute<HistorialPaquetes, Long> id;
    public static volatile SingularAttribute<HistorialPaquetes, Paquete> paquete;
    public static volatile SingularAttribute<HistorialPaquetes, Date> fechaRecepcion;

}