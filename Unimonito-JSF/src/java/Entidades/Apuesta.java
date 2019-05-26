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
@Table(name = "apuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apuesta.findAll", query = "SELECT a FROM Apuesta a")
    , @NamedQuery(name = "Apuesta.findByIdApuesta", query = "SELECT a FROM Apuesta a WHERE a.idApuesta = :idApuesta")
    , @NamedQuery(name = "Apuesta.findByMarcador1", query = "SELECT a FROM Apuesta a WHERE a.marcador1 = :marcador1")
    , @NamedQuery(name = "Apuesta.findByMarcador2", query = "SELECT a FROM Apuesta a WHERE a.marcador2 = :marcador2")})
public class Apuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idApuesta")
    private Integer idApuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Marcador1")
    private int marcador1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Marcador2")
    private int marcador2;
    @JoinColumn(name = "idPartido", referencedColumnName = "idPartido")
    @ManyToOne(optional = false)
    private Partido idPartido;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuarios idUsuarios;
    @JoinColumn(name = "idBoleteria", referencedColumnName = "idBoleteria")
    @ManyToOne(optional = false)
    private Boleteria idBoleteria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApuesta")
    private List<Ganadores> ganadoresList;

    public Apuesta() {
    }

    public Apuesta(Integer idApuesta) {
        this.idApuesta = idApuesta;
    }

    public Apuesta(Integer idApuesta, int marcador1, int marcador2) {
        this.idApuesta = idApuesta;
        this.marcador1 = marcador1;
        this.marcador2 = marcador2;
    }

    public Integer getIdApuesta() {
        return idApuesta;
    }

    public void setIdApuesta(Integer idApuesta) {
        this.idApuesta = idApuesta;
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

    public Partido getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Partido idPartido) {
        this.idPartido = idPartido;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Boleteria getIdBoleteria() {
        return idBoleteria;
    }

    public void setIdBoleteria(Boleteria idBoleteria) {
        this.idBoleteria = idBoleteria;
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
        hash += (idApuesta != null ? idApuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apuesta)) {
            return false;
        }
        Apuesta other = (Apuesta) object;
        if ((this.idApuesta == null && other.idApuesta != null) || (this.idApuesta != null && !this.idApuesta.equals(other.idApuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Apuesta[ idApuesta=" + idApuesta + " ]";
    }
    
}
