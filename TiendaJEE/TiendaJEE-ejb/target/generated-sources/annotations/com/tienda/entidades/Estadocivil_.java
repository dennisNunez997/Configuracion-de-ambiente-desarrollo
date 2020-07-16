package com.tienda.entidades;

import com.tienda.entidades.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-16T10:20:57")
@StaticMetamodel(Estadocivil.class)
public class Estadocivil_ { 

    public static volatile SingularAttribute<Estadocivil, Integer> codigoEC;
    public static volatile CollectionAttribute<Estadocivil, Empleado> empleadoCollection;
    public static volatile SingularAttribute<Estadocivil, String> nombre;

}