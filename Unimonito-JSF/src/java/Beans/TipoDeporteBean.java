/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.TipoDeporte;
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
@Named(value = "tipoDeporteBean")
@RequestScoped
public class TipoDeporteBean {

    @EJB
    private TipoDeporteFacadeLocal tipoDeporteFacade;
    
    
    private int       idTipoDeporte;
    private String    nombDepor;
    
    public List<TipoDeporte> getTipoDeporte(){
        
        return tipoDeporteFacade.findAll();
    }

    public String crear(){
        
       TipoDeporte a = new TipoDeporte();

       a.setIdTipoDeporte(idTipoDeporte);
       a.setNombDepor(nombDepor);  
       tipoDeporteFacade.create(a);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "consusu.xhtml");
       return "consutdeporte";
    } 

          public String elimina(int codigo){                    
          TipoDeporte tipodeporte;              
         tipodeporte = tipoDeporteFacade.find(codigo);
         tipoDeporteFacade.remove(tipodeporte);
         return "consutdeporte";
    }

        public String consulta(int id)
    { 
        TipoDeporte p =  this.tipoDeporteFacade.find(id);       
        this.idTipoDeporte = p.getIdTipoDeporte();
        this.nombDepor = p.getNombDepor();
        return "updatetdeporte";
    }
               
  public String GuardarEdicion(int id)
    {
       
       TipoDeporte a = new TipoDeporte();       
       a =  this.tipoDeporteFacade.find(id);  
       a.setIdTipoDeporte(idTipoDeporte);
       a.setNombDepor(nombDepor);
       this.tipoDeporteFacade.edit(a);
       return "consutdeporte";
    }     
        
          
    

    public int getIdTipoDeporte() {
        return idTipoDeporte;
    }

    public void setIdTipoDeporte(int idTipoDeporte) {
        this.idTipoDeporte = idTipoDeporte;
    }

    public String getNombDepor() {
        return nombDepor;
    }

    public void setNombDepor(String nombDepor) {
        this.nombDepor = nombDepor;
    }
    
    /**
     * Creates a new instance of TipoDeporteBean
     */
    public TipoDeporteBean() {
    }
    
    

    
}
