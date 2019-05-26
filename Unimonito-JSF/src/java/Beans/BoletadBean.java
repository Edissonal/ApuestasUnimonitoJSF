/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Boleteria;
import Entidades.Perfiles;
import Entidades.Usuarios;
import EntidadesEJB.BoleteriaFacadeLocal;
import EntidadesEJB.UsuariosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ealonso
 */
@Named(value = "boletadBean")
@RequestScoped
public class BoletadBean {

    @EJB
    private BoleteriaFacadeLocal boleteriaFacade;

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    /**
     * Creates a new instance of BoletadBean
     */
    
      private int idBoleteria;
      private int Precio;     
      private int Cantidad;
      private Usuarios usuarios;
      
      
    
    public BoletadBean() {
           usuarios = new Usuarios();  
    }
    
       public List<Boleteria>getBoleteria(){
    
        return boleteriaFacade.findAll();
    
    }
       
        public String crear(){
        
       Boleteria a = new Boleteria();

       a.setPrecio(Precio);
       a.setCantidad(Cantidad);
       a.setIdUsuarios(usuariosFacade.find(usuarios.getIdUsuarios()));     
       boleteriaFacade.create(a);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "consubole.xhtml");
       return "consubole";
   }   

          public String elimina(int codigo){                    
          Boleteria boleteria;              
         boleteria = boleteriaFacade.find(codigo);
         boleteriaFacade.remove(boleteria);
         return "consubole";
    }    
      
          public String consulta(int id)
    { 
        Boleteria p =  this.boleteriaFacade.find(id);       
        this.idBoleteria = p.getIdBoleteria();
        this.Precio = p.getPrecio();
        this.Cantidad = p.getCantidad();
        this.usuarios= p.getIdUsuarios();
        return "updatebole";
    }
           
        public String GuardarEdicion(int id)
    {
       
       Boleteria a = new Boleteria();       
       a =  this.boleteriaFacade.find(id);       
       a.setPrecio(Precio);
       a.setCantidad(Cantidad);
       a.setIdUsuarios(usuariosFacade.find(usuarios.getIdUsuarios()));
       this.boleteriaFacade.edit(a);
       return "consubole";
    }     
      
          
        
    public UsuariosFacadeLocal getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuariosFacadeLocal usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public int getIdBoleteria() {
        return idBoleteria;
    }

    public void setIdBoleteria(int idBoleteria) {
        this.idBoleteria = idBoleteria;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
}
