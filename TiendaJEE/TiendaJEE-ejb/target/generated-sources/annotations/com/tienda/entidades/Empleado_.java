package com.tienda.entidades;

import com.tienda.entidades.Cargo;
import com.tienda.entidades.Estadocivil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-16T10:20:57")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, Date> fechaNacimiento;
    public static volatile SingularAttribute<Empleado, String> cedula;
    public static volatile SingularAttribute<Empleado, String> apellido;
    public static volatile SingularAttribute<Empleado, Estadocivil> codigoEstadoCivil;
    public static volatile SingularAttribute<Empleado, Integer> codigoE;
    public static volatile SingularAttribute<Empleado, Cargo> codigoCargo;
    public static volatile SingularAttribute<Empleado, String> nombre;

}