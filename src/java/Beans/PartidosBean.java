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
import Entidades.Usuarios;
import EntidadesEJB.ApuestaFacadeLocal;
import EntidadesEJB.BoleteriaFacadeLocal;
import EntidadesEJB.Equipo2FacadeLocal;
import EntidadesEJB.EquipoFacadeLocal;
import EntidadesEJB.PartidoFacadeLocal;
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
@Named(value = "partidosBean")
@RequestScoped
public class PartidosBean {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    @EJB
    private ApuestaFacadeLocal apuestaFacade;

    @EJB
    private Equipo2FacadeLocal equipo2Facade;

    @EJB
    private BoleteriaFacadeLocal boleteriaFacade;

    @EJB
    private EquipoFacadeLocal equipoFacade;
    @EJB
    private PartidoFacadeLocal partidoFacade;



    private int idpartido;
    private int idusuarios;
    private int idboleteria;
    private int marcadorequip1;
    private int marcadorequip2;
    private Equipo equipos;
    private Equipo2 equipos2;
    private Boleteria boleterias;
    private Usuarios usuarios;
    private Apuesta apuesta;
    private Partido partidos;
    
         public PartidosBean() {
          equipos = new Equipo();
          equipos2 = new Equipo2();
          boleterias = new Boleteria();
          usuarios = new Usuarios();
          partidos = new Partido();
    }
        public List<Partido>getPartido(){
    
        return partidoFacade.findAll();
    
    }
     
        public List<Boleteria>getBoleteria(){
    
        return boleteriaFacade.findAll();
    
    }
        
        public List<Usuarios>getUsuario(){
    
        return usuariosFacade.findAll();
    
    }
     
     
        
        public String consulta(int id)
    { 
        Partido p =  this.partidoFacade.find(id);       
        this.idpartido = p.getIdPartido();
        this.equipos = p.getIdEquipo();
        this.equipos2 = p.getIdEquipo2();
        
        
        return "definemarca";
    }

       public String crear(){
        
       Apuesta a = new Apuesta();

       a.setIdPartido(partidoFacade.find(idpartido));
       a.setIdUsuarios(usuariosFacade.find(usuarios.getIdUsuarios()));
       a.setIdBoleteria(boleteriaFacade.find(boleterias.getIdBoleteria()));
       a.setMarcador1(marcadorequip1);
       a.setMarcador2(marcadorequip2); 
            apuestaFacade.create(a);
           

       return "consuapuesta";
   }

    public UsuariosFacadeLocal getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuariosFacadeLocal usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public ApuestaFacadeLocal getApuestaFacade() {
        return apuestaFacade;
    }

    public void setApuestaFacade(ApuestaFacadeLocal apuestaFacade) {
        this.apuestaFacade = apuestaFacade;
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

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public int getIdboleteria() {
        return idboleteria;
    }

    public void setIdboleteria(int idboleteria) {
        this.idboleteria = idboleteria;
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

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }

    public Partido getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido partidos) {
        this.partidos = partidos;
    }

   
  
}
