/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Apuesta;
import Entidades.Usuarios;
import EntidadesEJB.ApuestaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author ealonso
 */
@Named(value = "apuestasBean")
@Dependent
public class ApuestasBean {

    @EJB
    private ApuestaFacadeLocal apuestaFacade;

    
    
    
    
    /**
     * Creates a new instance of ApuestasBean
     */
    
      private int marcador1;
       private int marcador2;
       private int marcador3;
       private int marcador4;
       
       
       
       
       public ApuestasBean() {
       //  equipo = new Perfiles();
    }
       public List<Apuesta>getApuesta(){
    
        return apuestaFacade.findAll();
    
    }

    public int getMarcador3() {
        return marcador3;
    }

    public void setMarcador3(int marcador3) {
        this.marcador3 = marcador3;
    }

       
    public int getMarcador1() {
        return marcador1;
    }

    public void setMarcador1(int marcador1) {
        this.marcador1 = marcador1;
    }

    public int getMarcador2() {
        return marcador2;
    }

    public void setMarcador2(int marcador2) {
        this.marcador2 = marcador2;
    }

    public int getMarcador4() {
        return marcador4;
    }

    public void setMarcador4(int marcador4) {
        this.marcador4 = marcador4;
    }
 
      
    
}
