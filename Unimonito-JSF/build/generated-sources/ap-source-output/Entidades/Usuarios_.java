package Entidades;

import Entidades.Apuesta;
import Entidades.Boleteria;
import Entidades.Perfiles;
import Entidades.Rifa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-25T20:43:49")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Perfiles> idPerfiles;
    public static volatile SingularAttribute<Usuarios, String> nombUsu;
    public static volatile ListAttribute<Usuarios, Boleteria> boleteriaList;
    public static volatile ListAttribute<Usuarios, Rifa> rifaList;
    public static volatile SingularAttribute<Usuarios, Integer> idUsuarios;
    public static volatile SingularAttribute<Usuarios, Integer> cedulUsu;
    public static volatile ListAttribute<Usuarios, Apuesta> apuestaList;

}