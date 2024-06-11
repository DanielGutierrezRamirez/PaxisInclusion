package ies.torredelrey.modelo;

import ies.torredelrey.modelo.Reservas;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-11T11:44:45", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> apellidos;
    public static volatile SingularAttribute<Usuarios, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuarios, String> provincia;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile SingularAttribute<Usuarios, String> cp;
    public static volatile SingularAttribute<Usuarios, String> domicilio;
    public static volatile CollectionAttribute<Usuarios, Reservas> reservasCollection;
    public static volatile SingularAttribute<Usuarios, String> localidad;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, String> telefono;
    public static volatile SingularAttribute<Usuarios, String> sexo;
    public static volatile SingularAttribute<Usuarios, String> dni;
    public static volatile SingularAttribute<Usuarios, String> email;

}