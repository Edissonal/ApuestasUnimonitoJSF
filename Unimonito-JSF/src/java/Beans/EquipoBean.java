/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Dicita
 */
@Named(value = "equipoBean")
@RequestScoped
public class EquipoBean {

    /**
     * Creates a new instance of EquipoBean
     */
    public EquipoBean() {
    }
    
}
