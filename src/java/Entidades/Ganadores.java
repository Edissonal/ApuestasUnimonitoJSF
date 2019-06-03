/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ealonso
 */
@Entity
@Table(name = "ganadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ganadores.findAll", query = "SELECT g FROM Ganadores g")
    , @NamedQuery(name = "Ganadores.findByIdGanadores", query = "SELECT g FROM Ganadores g WHERE g.idGanadores = :idGanadores")})
public class Ganadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGanadores")
    private Integer idGanadores;
    @JoinColumn(name = "idRifa", referencedColumnName = "idRifa")
    @ManyToOne(optional = false)
    private Rifa idRifa;
    @JoinColumn(name = "idApuesta", referencedColumnName = "idApuesta")
    @ManyToOne(optional = false)
    private Apuesta idApuesta;

    public Ganadores() {
    }

    public Ganadores(Integer idGanadores) {
        this.idGanadores = idGanadores;
    }

    public Integer getIdGanadores() {
        return idGanadores;
    }

    public void setIdGanadores(Integer idGanadores) {
        this.idGanadores = idGanadores;
    }

    public Rifa getIdRifa() {
        return idRifa;
    }

    public void setIdRifa(Rifa idRifa) {
        this.idRifa = idRifa;
    }

    public Apuesta getIdApuesta() {
        return idApuesta;
    }

    public void setIdApuesta(Apuesta idApuesta) {
        this.idApuesta = idApuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGanadores != null ? idGanadores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ganadores)) {
            return false;
        }
        Ganadores other = (Ganadores) object;
        if ((this.idGanadores == null && other.idGanadores != null) || (this.idGanadores != null && !this.idGanadores.equals(other.idGanadores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ganadores[ idGanadores=" + idGanadores + " ]";
    }
    
}
