/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Apuesta;
import Entidades.Boleteria;
import Entidades.Equipo;
import Entidades.Equipo2;
import Entidades.Partido;
import EntidadesEJB.BoleteriaFacadeLocal;
import EntidadesEJB.Equipo2FacadeLocal;
import EntidadesEJB.EquipoFacadeLocal;
import EntidadesEJB.PartidoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ealonso
 */
@Named(value = "partidosBean")
@RequestScoped
public class PartidosBean {

    @EJB
    private Equipo2FacadeLocal equipo2Facade;

    @EJB
    private BoleteriaFacadeLocal boleteriaFacade;

    @EJB
    private EquipoFacadeLocal equipoFacade;
    @EJB
    private PartidoFacadeLocal partidoFacade;



    private int idpartido;
    private int marcadorequip1;
    private int marcadorequip2;
    private Equipo equipos;
    private Equipo2 equipos2;
    private Boleteria boleterias;
  
    
         public PartidosBean() {
          equipos = new Equipo();
          equipos2 = new Equipo2();
          boleterias = new Boleteria();
        }
    
        public List<Partido>getPartido(){
    
        return partidoFacade.findAll();
    
    }


       public String crear(){
        
       Partido a = new Partido();
       a.setMarcadorEquip1(marcadorequip1);
       a.setMarcadorEquip2(marcadorequip2); 
       a.setIdEquipo(equipoFacade.find(equipos.getIdEquipo()));
       a.setIdEquipo2(equipo2Facade.find(equipos2.getIdEquipo2()));
       partidoFacade.create(a);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "constpartido.xhtml");
      
    
       return "constpartido";
   }
       
    public String elimina(int codigo){                    
         Partido partido;              
         partido = partidoFacade.find(codigo);
         partidoFacade.remove(partido);
         return "constpartido";
    }       
             
        public String consulta(int id)
    { 
        Partido p =  this.partidoFacade.find(id);       
        this.idpartido = p.getIdPartido();
        this.marcadorequip1 = p.getMarcadorEquip1();
        this.marcadorequip2 = p.getMarcadorEquip2();        
        this.equipos = p.getIdEquipo();
        this.equipos2 = p.getIdEquipo2();
        
        
        return "updatepartido";
    }

    public String GuardarEdicion(int id){
       
       Partido a = new Partido();       
       a =  this.partidoFacade.find(id);  
       a.setMarcadorEquip1(marcadorequip1);
       a.setMarcadorEquip2(marcadorequip2);       
       a.setIdEquipo(equipoFacade.find(equipos.getIdEquipo()));
       a.setIdEquipo2(equipo2Facade.find(equipos2.getIdEquipo2()));
       this.partidoFacade.edit(a);
       return "constpartido";
    }        


    public Equipo2FacadeLocal getEquipo2Facade() {
        return equipo2Facade;
    }

    public void setEquipo2Facade(Equipo2FacadeLocal equipo2Facade) {
        this.equipo2Facade = equipo2Facade;
    }

    public BoleteriaFacadeLocal getBoleteriaFacade() {
        return boleteriaFacade;
    }

    public void setBoleteriaFacade(BoleteriaFacadeLocal boleteriaFacade) {
        this.boleteriaFacade = boleteriaFacade;
    }

    public EquipoFacadeLocal getEquipoFacade() {
        return equipoFacade;
    }

    public void setEquipoFacade(EquipoFacadeLocal equipoFacade) {
        this.equipoFacade = equipoFacade;
    }

    public int getIdpartido() {
        return idpartido;
    }

    public void setIdpartido(int idpartido) {
        this.idpartido = idpartido;
    }

    public int getMarcadorequip1() {
        return marcadorequip1;
    }

    public void setMarcadorequip1(int marcadorequip1) {
        this.marcadorequip1 = marcadorequip1;
    }

    public int getMarcadorequip2() {
        return marcadorequip2;
    }

    public void setMarcadorequip2(int marcadorequip2) {
        this.marcadorequip2 = marcadorequip2;
    }

    public Equipo getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipo equipos) {
        this.equipos = equipos;
    }

    public Equipo2 getEquipos2() {
        return equipos2;
    }

    public void setEquipos2(Equipo2 equipos2) {
        this.equipos2 = equipos2;
    }

    public Boleteria getBoleterias() {
        return boleterias;
    }

    public void setBoleterias(Boleteria boleterias) {
        this.boleterias = boleterias;
    }  
        
}
