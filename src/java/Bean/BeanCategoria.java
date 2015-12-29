/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fox w8
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanCategoria.findAll", query = "SELECT b FROM BeanCategoria b"),
    @NamedQuery(name = "BeanCategoria.findByIdCategoria", query = "SELECT b FROM BeanCategoria b WHERE b.idCategoria = :idCategoria"),
    @NamedQuery(name = "BeanCategoria.findByCategoria", query = "SELECT b FROM BeanCategoria b WHERE b.categoria = :categoria"),
    @NamedQuery(name = "BeanCategoria.findByDesCategoria", query = "SELECT b FROM BeanCategoria b WHERE b.desCategoria = :desCategoria")})
public class BeanCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 100)
    @Column(name = "des_categoria")
    private String desCategoria;

    public BeanCategoria() {
    }

    public BeanCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDesCategoria() {
        return desCategoria;
    }

    public void setDesCategoria(String desCategoria) {
        this.desCategoria = desCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanCategoria)) {
            return false;
        }
        BeanCategoria other = (BeanCategoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bean.BeanCategoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
