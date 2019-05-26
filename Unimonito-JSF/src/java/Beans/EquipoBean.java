/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.TipoDeporte;
import Entidades.Equipo;
import EntidadesEJB.EquipoFacadeLocal;
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
@Named(value = "equipoBean")
@RequestScoped
public class EquipoBean {

    @EJB
    private TipoDeporteFacadeLocal tipoDeporteFacade;

    @EJB
    private EquipoFacadeLocal equipoFacade;
    
    private int       idEquipo;
    private String    NomEquipo;
    private TipoDeporte idTipo_Deporte;   
    
    public List<Equipo>getEquipo(){
    
        return equipoFacade.findAll();
    
    }

    public String crear(){
        
       Equipo a = new Equipo();

       //a.setIdEquipo(idEquipo);
       a.setNombEquipo(NomEquipo);
       a.setIdTipoDeporte(tipoDeporteFacade.find(idTipo_Deporte.getIdTipoDeporte()));     
       equipoFacade.create(a);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "consequipo.xhtml");
       return "consequipo";
   }

    public String elimina(int codigo){                    
         Equipo equipo;              
         equipo = equipoFacade.find(codigo);
         equipoFacade.remove(equipo);
         return "consequipo";
    }

    public String consulta(int id){ 
        Equipo p =  this.equipoFacade.find(id);       
        this.idEquipo = p.getIdEquipo();
        this.NomEquipo = p.getNombEquipo();
        this.idTipo_Deporte= p.getIdTipoDeporte();
        return "updateequipo";
    }

    public String GuardarEdicion(int id){
       
       Equipo a = new Equipo();       
       a =  this.equipoFacade.find(id);  
       //a.setIdEquipo(idEquipo);
       a.setNombEquipo(NomEquipo);
       a.setIdTipoDeporte(tipoDeporteFacade.find(idTipo_Deporte.getIdTipoDeporte()));
       this.equipoFacade.edit(a);
       return "consequipo";
    }     
    

    

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNomEquipo() {
        return NomEquipo;
    }

    public void setNomEquipo(String NomEquipo) {
        this.NomEquipo = NomEquipo;
    }

    public TipoDeporte getIdTipo_Deporte() {
        return idTipo_Deporte;
    }

    public void setIdTipo_Deporte(TipoDeporte idTipo_Deporte) {
        this.idTipo_Deporte = idTipo_Deporte;
    }

    public TipoDeporteFacadeLocal getTipoDeporteFacade() {
        return tipoDeporteFacade;
    }

    public void setTipoDeporteFacade(TipoDeporteFacadeLocal tipoDeporteFacade) {
        this.tipoDeporteFacade = tipoDeporteFacade;
    }

    /**
     * Creates a new instance of EquipoBean
     */
    public EquipoBean() {
        idTipo_Deporte = new TipoDeporte();
        
    }
    
}
