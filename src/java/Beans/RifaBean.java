/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Apuesta;
import Entidades.Boleteria;
import Entidades.Rifa;
import Entidades.Usuarios;
import EntidadesEJB.ApuestaFacadeLocal;
import EntidadesEJB.BoleteriaFacadeLocal;
import EntidadesEJB.RifaFacadeLocal;
import EntidadesEJB.UsuariosFacadeLocal;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ivan
 */
@Named(value = "rifaBean")
@RequestScoped
public class RifaBean {

    @EJB
    private ApuestaFacadeLocal apuestaFacade;

    
    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    

    @EJB
    private BoleteriaFacadeLocal boleteriaFacade;

    @EJB
    private RifaFacadeLocal rifaFacade;
    
    
    
    private int       idrifa;
    private String    premio;
    private Boleteria boleteria;
    private Usuarios  usuarios;
    private Apuesta  apuesta;
    private Apuesta    winerfinal;
    
    public List<Rifa>getRifas(){
        return rifaFacade.findAll();
    }
    
     public List<Apuesta>getApuestas(){
     
         return apuestaFacade.findAll();
    
     }

    public RifaBean() {
        usuarios = new Usuarios();
        boleteria = new Boleteria();
    } 
    public String crear(){
       Rifa a = new Rifa();
       
       a.setPremio(premio);
       a.setIdUsuarios(usuariosFacade.find(usuarios.getIdUsuarios()));         
       a.setIdBoleteria(boleteriaFacade.find(boleteria.getIdBoleteria()));     
       
       rifaFacade.create(a);
       
       FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "consurifa.xhtml");
       
       return "consurifa";
   }  
    
    
         public String elimina(int codigo){                    
         Rifa rifa;              
         rifa = rifaFacade.find(codigo);
         rifaFacade.remove(rifa);
         return "consurifa";
       }

         public String consulta(int id)
    { 
        Rifa p =  this.rifaFacade.find(id);       
        this.idrifa = p.getIdRifa();
        this.premio = p.getPremio();
        this.boleteria = p.getIdBoleteria();
        this.usuarios= p.getIdUsuarios();
        return "editrifa";
    }
      
           
         public String GuardarEdicion(int id)
    {
       
       Rifa a = new Rifa();       
       a =  this.rifaFacade.find(id);  
       a.setPremio(premio);
       a.setIdBoleteria(boleteriaFacade.find(boleteria.getIdBoleteria()));
       a.setIdUsuarios(usuariosFacade.find(usuarios.getIdUsuarios()));
       this.rifaFacade.edit(a);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "consurifa.xhtml");
      
       return "consurifa";
    } 
         
     public String rifar()
    {
       List<Apuesta> apuesta=apuestaFacade.findAll();
          
          
          Random rand = new Random(); 
          Apuesta winer = apuesta.get(rand.nextInt(apuesta.size()));
          setWinerfinal(winer);
   
       return "consurifa";
    } 
     
         
         
        public UsuariosFacadeLocal getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuariosFacadeLocal usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public BoleteriaFacadeLocal getBoleteriaFacade() {
        return boleteriaFacade;
    }

    public void setBoleteriaFacade(BoleteriaFacadeLocal boleteriaFacade) {
        this.boleteriaFacade = boleteriaFacade;
    }

    public int getIdrifa() {
        return idrifa;
    }

    public void setIdrifa(int idrifa) {
        this.idrifa = idrifa;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public Boleteria getBoleteria() {
        return boleteria;
    }

    public void setBoleteria(Boleteria boleteria) {
        this.boleteria = boleteria;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Apuesta getWinerfinal() {
        return winerfinal;
    }

    public void setWinerfinal(Apuesta winerfinal) {
        this.winerfinal = winerfinal;
    }


    
    
}

