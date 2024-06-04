package ies.torredelrey.modelo;

import ies.torredelrey.modelo.Actividad;
import ies.torredelrey.modelo.Usuarios;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-04T14:07:31", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Reservas.class)
public class Reservas_ { 

    public static volatile SingularAttribute<Reservas, String> apellidosUsuario;
    public static volatile SingularAttribute<Reservas, Actividad> idActividad;
    public static volatile SingularAttribute<Reservas, String> nombreActividad;
    public static volatile SingularAttribute<Reservas, Integer> numeroPlazasReserva;
    public static volatile SingularAttribute<Reservas, Integer> id;
    public static volatile SingularAttribute<Reservas, String> nombreUsuario;
    public static volatile SingularAttribute<Reservas, Usuarios> usuarios;
    public static volatile SingularAttribute<Reservas, String> dniUsuario;
    public static volatile SingularAttribute<Reservas, Date> fechaReserva;

}