/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.TipoDeporte;
import Entidades.Equipo2;
import EntidadesEJB.Equipo2FacadeLocal;
import EntidadesEJB.TipoDeporteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dicita
 */
@Named(value = "equipo2Bean")
@RequestScoped
public class Equipo2Bean {

    @EJB
    private Equipo2FacadeLocal equipo2Facade;

    @EJB
    private TipoDeporteFacadeLocal tipoDeporteFacade;
    
    private int       idEquipo2;
    private String    nombEquipo2;
    private TipoDeporte idTipo_Deporte;
    
    
    public List<Equipo2>getEquipo(){
    
        return equipo2Facade.findAll();
    
    }  
    
    public String crear(){
        
       Equipo2 a = new Equipo2();

       //a.setIdEquipo(idEquipo);
       a.setNombEquipo2(nombEquipo2);
       a.setIdTipoDeporte(tipoDeporteFacade.find(idTipo_Deporte.getIdTipoDeporte()));     
       equipo2Facade.create(a);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "consequipo.xhtml");
       return "consequipo";
   }


    public String elimina(int codigo){                    
         Equipo2 equipo2;              
         equipo2 = equipo2Facade.find(codigo);
         equipo2Facade.remove(equipo2);
         return "consequipo";
    }

    public String consulta(int id){ 
        Equipo2 p =  this.equipo2Facade.find(id);       
        this.idEquipo2 = p.getIdEquipo2();
        this.nombEquipo2 = p.getNombEquipo2();
        this.idTipo_Deporte= p.getIdTipoDeporte();
        return "updateequipo";
    } 
    
    public String GuardarEdicion(int id){
       
       Equipo2 a = new Equipo2();       
       a =  this.equipo2Facade.find(id);  
       //a.setIdEquipo(idEquipo);
       a.setNombEquipo2(nombEquipo2);
       a.setIdTipoDeporte(tipoDeporteFacade.find(idTipo_Deporte.getIdTipoDeporte()));
       this.equipo2Facade.edit(a);
       return "consequipo";
    }    
    

    public TipoDeporteFacadeLocal getTipoDeporteFacade() {
        return tipoDeporteFacade;
    }

    public void setTipoDeporteFacade(TipoDeporteFacadeLocal tipoDeporteFacade) {
        this.tipoDeporteFacade = tipoDeporteFacade;
    }

    public int getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(int idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    public String getNombEquipo2() {
        return nombEquipo2;
    }

    public void setNombEquipo2(String nombEquipo2) {
        this.nombEquipo2 = nombEquipo2;
    }

    public TipoDeporte getIdTipo_Deporte() {
        return idTipo_Deporte;
    }

    public void setIdTipo_Deporte(TipoDeporte idTipo_Deporte) {
        this.idTipo_Deporte = idTipo_Deporte;
    }

    /**
     * Creates a new instance of Equipo2Bean
     */
    public Equipo2Bean() {
        idTipo_Deporte = new TipoDeporte();
    }
    
}
