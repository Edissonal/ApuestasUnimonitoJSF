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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuarios", query = "SELECT u FROM Usuarios u WHERE u.idUsuarios = :idUsuarios")
    , @NamedQuery(name = "Usuarios.findByNombUsu", query = "SELECT u FROM Usuarios u WHERE u.nombUsu = :nombUsu")
    , @NamedQuery(name = "Usuarios.findByCedulUsu", query = "SELECT u FROM Usuarios u WHERE u.cedulUsu = :cedulUsu")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuarios")
    private Integer idUsuarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NombUsu")
    private String nombUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CedulUsu")
    private int cedulUsu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private List<Boleteria> boleteriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private List<Rifa> rifaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private List<Apuesta> apuestaList;
    @JoinColumn(name = "idPerfiles", referencedColumnName = "idPerfiles")
    @ManyToOne(optional = false)
    private Perfiles idPerfiles;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Usuarios(Integer idUsuarios, String nombUsu, int cedulUsu) {
        this.idUsuarios = idUsuarios;
        this.nombUsu = nombUsu;
        this.cedulUsu = cedulUsu;
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombUsu() {
        return nombUsu;
    }

    public void setNombUsu(String nombUsu) {
        this.nombUsu = nombUsu;
    }

    public int getCedulUsu() {
        return cedulUsu;
    }

    public void setCedulUsu(int cedulUsu) {
        this.cedulUsu = cedulUsu;
    }

    @XmlTransient
    public List<Boleteria> getBoleteriaList() {
        return boleteriaList;
    }

    public void setBoleteriaList(List<Boleteria> boleteriaList) {
        this.boleteriaList = boleteriaList;
    }

    @XmlTransient
    public List<Rifa> getRifaList() {
        return rifaList;
    }

    public void setRifaList(List<Rifa> rifaList) {
        this.rifaList = rifaList;
    }

    @XmlTransient
    public List<Apuesta> getApuestaList() {
        return apuestaList;
    }

    public void setApuestaList(List<Apuesta> apuestaList) {
        this.apuestaList = apuestaList;
    }

    public Perfiles getIdPerfiles() {
        return idPerfiles;
    }

    public void setIdPerfiles(Perfiles idPerfiles) {
        this.idPerfiles = idPerfiles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarios != null ? idUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Usuarios[ idUsuarios=" + idUsuarios + " ]";
    }
    
}
