package Entidades;

import Entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-03T12:49:50")
@StaticMetamodel(Perfiles.class)
public class Perfiles_ { 

    public static volatile SingularAttribute<Perfiles, Integer> idPerfiles;
    public static volatile ListAttribute<Perfiles, Usuarios> usuariosList;
    public static volatile SingularAttribute<Perfiles, String> nombPerf;

}