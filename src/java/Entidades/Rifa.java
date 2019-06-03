/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ealonso
 */
@Entity
@Table(name = "rifa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rifa.findAll", query = "SELECT r FROM Rifa r")
    , @NamedQuery(name = "Rifa.findByIdRifa", query = "SELECT r FROM Rifa r WHERE r.idRifa = :idRifa")
    , @NamedQuery(name = "Rifa.findByPremio", query = "SELECT r FROM Rifa r WHERE r.premio = :premio")})
public class Rifa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRifa")
    private Integer idRifa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Premio")
    private String premio;
    @JoinColumn(name = "idBoleteria", referencedColumnName = "idBoleteria")
    @ManyToOne(optional = false)
    private Boleteria idBoleteria;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuarios idUsuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRifa")
    private List<Ganadores> ganadoresList;

    public Rifa() {
    }

    public Rifa(Integer idRifa) {
        this.idRifa = idRifa;
    }

    public Rifa(Integer idRifa, String premio) {
        this.idRifa = idRifa;
        this.premio = premio;
    }

    public Integer getIdRifa() {
        return idRifa;
    }

    public void setIdRifa(Integer idRifa) {
        this.idRifa = idRifa;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public Boleteria getIdBoleteria() {
        return idBoleteria;
    }

    public void setIdBoleteria(Boleteria idBoleteria) {
        this.idBoleteria = idBoleteria;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    @XmlTransient
    public List<Ganadores> getGanadoresList() {
        return ganadoresList;
    }

    public void setGanadoresList(List<Ganadores> ganadoresList) {
        this.ganadoresList = ganadoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRifa != null ? idRifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rifa)) {
            return false;
        }
        Rifa other = (Rifa) object;
        if ((this.idRifa == null && other.idRifa != null) || (this.idRifa != null && !this.idRifa.equals(other.idRifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Rifa[ idRifa=" + idRifa + " ]";
    }
    
}
