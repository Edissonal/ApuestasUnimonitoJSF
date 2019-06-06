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
@Table(name = "perfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfiles.findAll", query = "SELECT p FROM Perfiles p")
    , @NamedQuery(name = "Perfiles.findByIdPerfiles", query = "SELECT p FROM Perfiles p WHERE p.idPerfiles = :idPerfiles")
    , @NamedQuery(name = "Perfiles.findByNombPerf", query = "SELECT p FROM Perfiles p WHERE p.nombPerf = :nombPerf")})
public class Perfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerfiles")
    private Integer idPerfiles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NombPerf")
    private String nombPerf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfiles")
    private List<Usuarios> usuariosList;

    public Perfiles() {
    }

    public Perfiles(Integer idPerfiles) {
        this.idPerfiles = idPerfiles;
    }

    public Perfiles(Integer idPerfiles, String nombPerf) {
        this.idPerfiles = idPerfiles;
        this.nombPerf = nombPerf;
    }

    public Integer getIdPerfiles() {
        return idPerfiles;
    }

    public void setIdPerfiles(Integer idPerfiles) {
        this.idPerfiles = idPerfiles;
    }

    public String getNombPerf() {
        return nombPerf;
    }

    public void setNombPerf(String nombPerf) {
        this.nombPerf = nombPerf;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfiles != null ? idPerfiles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfiles)) {
            return false;
        }
        Perfiles other = (Perfiles) object;
        if ((this.idPerfiles == null && other.idPerfiles != null) || (this.idPerfiles != null && !this.idPerfiles.equals(other.idPerfiles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Perfiles[ idPerfiles=" + idPerfiles + " ]";
    }
    
}
