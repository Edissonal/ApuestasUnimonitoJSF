/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Perfiles;
import EntidadesEJB.PerfilesFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ealonso
 */
@Named(value = "perfilesBean")
@RequestScoped
public class PerfilesBean {
    
        public List<Perfiles> getPerfiles(){
        
        return perfilesFacade.findAll();
    }
        
    public PerfilesBean() {
    }

    @EJB
    private PerfilesFacadeLocal perfilesFacade;

    public int getIdperfiles() {
        return idperfiles;
    }

    public void setIdperfiles(int idperfiles) {
        this.idperfiles = idperfiles;
    }

    public String getNombPerf() {
        return nombPerf;
    }

    /**
     * Creates a new instance of PerfilesBean
     */
    public void setNombPerf(String nombPerf) {
        this.nombPerf = nombPerf;
    }

    
    private int idperfiles;
    private String nombPerf;  
    
 
    
}
