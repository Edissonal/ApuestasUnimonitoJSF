/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Apuesta;
import Entidades.Equipo;
import Entidades.Partido;
import EntidadesEJB.EquipoFacadeLocal;
import EntidadesEJB.PartidoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ealonso
 */
@Named(value = "partidosBean")
@RequestScoped
public class PartidosBean {

    @EJB
    private EquipoFacadeLocal equipoFacade;
@EJB
    private PartidoFacadeLocal partidoFacade;



    private int idpartido;
    private int idequipo;
    private int idequipo2;
    private String NombEquipo;
    private String NombEquipo2;
    private int marcadorequip1;
    private int marcadorequip2;
    //private Equipo equipos;
  
    
        public PartidosBean() {
          //equipos = new Equipo();
    }
    
        public List<Partido>getPartido(){
    
        return partidoFacade.findAll();
    
    }
        
         public List<Equipo>getEquipos(){
    
        return equipoFacade.findAll();
    
    }  

        
        public String consulta(int id)
    { 
        Partido p =  this.partidoFacade.find(id);       
        this.idpartido = p.getIdPartido();
        this.equipos = p.getIdEquipo();
        return "definemarca";
    }

   
        
}
