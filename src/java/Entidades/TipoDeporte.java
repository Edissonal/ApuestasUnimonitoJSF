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
@Table(name = "tipo_deporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeporte.findAll", query = "SELECT t FROM TipoDeporte t")
    , @NamedQuery(name = "TipoDeporte.findByIdTipoDeporte", query = "SELECT t FROM TipoDeporte t WHERE t.idTipoDeporte = :idTipoDeporte")
    , @NamedQuery(name = "TipoDeporte.findByNombDepor", query = "SELECT t FROM TipoDeporte t WHERE t.nombDepor = :nombDepor")})
public class TipoDeporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipo_Deporte")
    private Integer idTipoDeporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NombDepor")
    private String nombDepor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDeporte")
    private List<Equipo> equipoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDeporte")
    private List<Equipo2> equipo2List;

    public TipoDeporte() {
    }

    public TipoDeporte(Integer idTipoDeporte) {
        this.idTipoDeporte = idTipoDeporte;
    }

    public TipoDeporte(Integer idTipoDeporte, String nombDepor) {
        this.idTipoDeporte = idTipoDeporte;
        this.nombDepor = nombDepor;
    }

    public Integer getIdTipoDeporte() {
        return idTipoDeporte;
    }

    public void setIdTipoDeporte(Integer idTipoDeporte) {
        this.idTipoDeporte = idTipoDeporte;
    }

    public String getNombDepor() {
        return nombDepor;
    }

    public void setNombDepor(String nombDepor) {
        this.nombDepor = nombDepor;
    }

    @XmlTransient
    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }

    @XmlTransient
    public List<Equipo2> getEquipo2List() {
        return equipo2List;
    }

    public void setEquipo2List(List<Equipo2> equipo2List) {
        this.equipo2List = equipo2List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDeporte != null ? idTipoDeporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeporte)) {
            return false;
        }
        TipoDeporte other = (TipoDeporte) object;
        if ((this.idTipoDeporte == null && other.idTipoDeporte != null) || (this.idTipoDeporte != null && !this.idTipoDeporte.equals(other.idTipoDeporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoDeporte[ idTipoDeporte=" + idTipoDeporte + " ]";
    }
    
}
