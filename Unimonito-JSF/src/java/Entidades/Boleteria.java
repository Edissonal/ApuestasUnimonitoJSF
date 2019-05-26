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
@Table(name = "boleteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleteria.findAll", query = "SELECT b FROM Boleteria b")
    , @NamedQuery(name = "Boleteria.findByIdBoleteria", query = "SELECT b FROM Boleteria b WHERE b.idBoleteria = :idBoleteria")
    , @NamedQuery(name = "Boleteria.findByPrecio", query = "SELECT b FROM Boleteria b WHERE b.precio = :precio")
    , @NamedQuery(name = "Boleteria.findByCantidad", query = "SELECT b FROM Boleteria b WHERE b.cantidad = :cantidad")})
public class Boleteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBoleteria")
    private Integer idBoleteria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuarios idUsuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBoleteria")
    private List<Rifa> rifaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBoleteria")
    private List<Apuesta> apuestaList;

    public Boleteria() {
    }

    public Boleteria(Integer idBoleteria) {
        this.idBoleteria = idBoleteria;
    }

    public Boleteria(Integer idBoleteria, int precio, int cantidad) {
        this.idBoleteria = idBoleteria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getIdBoleteria() {
        return idBoleteria;
    }

    public void setIdBoleteria(Integer idBoleteria) {
        this.idBoleteria = idBoleteria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoleteria != null ? idBoleteria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleteria)) {
            return false;
        }
        Boleteria other = (Boleteria) object;
        if ((this.idBoleteria == null && other.idBoleteria != null) || (this.idBoleteria != null && !this.idBoleteria.equals(other.idBoleteria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Boleteria[ idBoleteria=" + idBoleteria + " ]";
    }
    
}
