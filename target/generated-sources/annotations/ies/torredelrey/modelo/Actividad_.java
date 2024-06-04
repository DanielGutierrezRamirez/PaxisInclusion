package ies.torredelrey.modelo;

import ies.torredelrey.modelo.Reservas;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-04T14:07:31", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, String> nombreActividad;
    public static volatile CollectionAttribute<Actividad, Reservas> reservasCollection;
    public static volatile SingularAttribute<Actividad, Integer> id;
    public static volatile SingularAttribute<Actividad, Integer> numeroPlazas;

}