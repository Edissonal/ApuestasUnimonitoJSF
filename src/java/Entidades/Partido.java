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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ealonso
 */
@Entity
@Table(name = "partido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p")
    , @NamedQuery(name = "Partido.findByIdPartido", query = "SELECT p FROM Partido p WHERE p.idPartido = :idPartido")
    , @NamedQuery(name = "Partido.findByMarcadorEquip1", query = "SELECT p FROM Partido p WHERE p.marcadorEquip1 = :marcadorEquip1")
    , @NamedQuery(name = "Partido.findByMarcadorEquip2", query = "SELECT p FROM Partido p WHERE p.marcadorEquip2 = :marcadorEquip2")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPartido")
    private Integer idPartido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marcadorEquip1")
    private int marcadorEquip1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marcadorEquip2")
    private int marcadorEquip2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartido")
    private List<Apuesta> apuestaList;
    @JoinColumn(name = "idEquipo", referencedColumnName = "idEquipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "idEquipo2", referencedColumnName = "idEquipo2")
    @ManyToOne(optional = false)
    private Equipo2 idEquipo2;

    public Partido() {
    }

    public Partido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Partido(Integer idPartido, int marcadorEquip1, int marcadorEquip2) {
        this.idPartido = idPartido;
        this.marcadorEquip1 = marcadorEquip1;
        this.marcadorEquip2 = marcadorEquip2;
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public int getMarcadorEquip1() {
        return marcadorEquip1;
    }

    public void setMarcadorEquip1(int marcadorEquip1) {
        this.marcadorEquip1 = marcadorEquip1;
    }

    public int getMarcadorEquip2() {
        return marcadorEquip2;
    }

    public void setMarcadorEquip2(int marcadorEquip2) {
        this.marcadorEquip2 = marcadorEquip2;
    }

    @XmlTransient
    public List<Apuesta> getApuestaList() {
        return apuestaList;
    }

    public void setApuestaList(List<Apuesta> apuestaList) {
        this.apuestaList = apuestaList;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo2 getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(Equipo2 idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartido != null ? idPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.idPartido == null && other.idPartido != null) || (this.idPartido != null && !this.idPartido.equals(other.idPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Partido[ idPartido=" + idPartido + " ]";
    }
    
}
