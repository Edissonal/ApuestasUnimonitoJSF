/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Perfiles;
import Entidades.Usuarios;
import EntidadesEJB.PerfilesFacadeLocal;
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
@Named(value = "usuariosdBean")
@RequestScoped
public class UsuariosdBean {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    @EJB
    private PerfilesFacadeLocal perfilesFacade;

    /**
     * Creates a new instance of UsuariosdBean
     */
    
    
    private int       idusuarios;
    private String    nombusu;
    private int       cedulusu;
    private Perfiles perfiles;
    
      public List<Usuarios>getUsuarios(){
    
        return usuariosFacade.findAll();
    
    }

        public String crear(){
        
       Usuarios a = new Usuarios();

       a.setNombUsu(nombusu);
       a.setCedulUsu(cedulusu);
       a.setIdPerfiles(perfilesFacade.find(perfiles.getIdPerfiles()));     
       usuariosFacade.create(a);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "consusu.xhtml");
       return "consusu";
   }   
      
      
          public String elimina(int codigo){                    
          Usuarios usuarios;              
         usuarios = usuariosFacade.find(codigo);
         usuariosFacade.remove(usuarios);
         return "alumno";
    }
        
        public String consulta(int id)
    { 
        Usuarios p =  this.usuariosFacade.find(id);       
        this.idusuarios = p.getIdUsuarios();
        this.nombusu = p.getNombUsu();
        this.cedulusu = p.getCedulUsu();
        this.perfiles= p.getIdPerfiles();
        return "updateusu";
    }
     
        
  public String GuardarEdicion(int id)
    {
       
       Usuarios a = new Usuarios();       
       a =  this.usuariosFacade.find(id);  
       a.setNombUsu(nombusu);
       a.setCedulUsu(cedulusu);
       a.setIdPerfiles(perfilesFacade.find(perfiles.getIdPerfiles()));
       this.usuariosFacade.edit(a);
       return "consusu";
    }     
                    
               
               
               
    public String getNombusu() {
        return nombusu;
    }

    public void setNombusu(String nombusu) {
        this.nombusu = nombusu;
    }
    public UsuariosdBean() {
      perfiles = new Perfiles();
        
    
}

    public PerfilesFacadeLocal getPerfilesFacade() {
        return perfilesFacade;
    }

    public void setPerfilesFacade(PerfilesFacadeLocal perfilesFacade) {
        this.perfilesFacade = perfilesFacade;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public int getCedulusu() {
        return cedulusu;
    }

    public void setCedulusu(int cedulusu) {
        this.cedulusu = cedulusu;
    }

    public Perfiles getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Perfiles perfiles) {
        this.perfiles = perfiles;
    }
    
    
    
}
