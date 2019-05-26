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
@Table(name = "equipo2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo2.findAll", query = "SELECT e FROM Equipo2 e")
    , @NamedQuery(name = "Equipo2.findByIdEquipo2", query = "SELECT e FROM Equipo2 e WHERE e.idEquipo2 = :idEquipo2")
    , @NamedQuery(name = "Equipo2.findByNombEquipo2", query = "SELECT e FROM Equipo2 e WHERE e.nombEquipo2 = :nombEquipo2")})
public class Equipo2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEquipo2")
    private Integer idEquipo2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NombEquipo2")
    private String nombEquipo2;
    @JoinColumn(name = "idTipo_Deporte", referencedColumnName = "idTipo_Deporte")
    @ManyToOne(optional = false)
    private TipoDeporte idTipoDeporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo2")
    private List<Partido> partidoList;

    public Equipo2() {
    }

    public Equipo2(Integer idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    public Equipo2(Integer idEquipo2, String nombEquipo2) {
        this.idEquipo2 = idEquipo2;
        this.nombEquipo2 = nombEquipo2;
    }

    public Integer getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(Integer idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    public String getNombEquipo2() {
        return nombEquipo2;
    }

    public void setNombEquipo2(String nombEquipo2) {
        this.nombEquipo2 = nombEquipo2;
    }

    public TipoDeporte getIdTipoDeporte() {
        return idTipoDeporte;
    }

    public void setIdTipoDeporte(TipoDeporte idTipoDeporte) {
        this.idTipoDeporte = idTipoDeporte;
    }

    @XmlTransient
    public List<Partido> getPartidoList() {
        return partidoList;
    }

    public void setPartidoList(List<Partido> partidoList) {
        this.partidoList = partidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo2 != null ? idEquipo2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo2)) {
            return false;
        }
        Equipo2 other = (Equipo2) object;
        if ((this.idEquipo2 == null && other.idEquipo2 != null) || (this.idEquipo2 != null && !this.idEquipo2.equals(other.idEquipo2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Equipo2[ idEquipo2=" + idEquipo2 + " ]";
    }
    
}
