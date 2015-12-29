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
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanMenu.findAll", query = "SELECT b FROM BeanMenu b"),
    @NamedQuery(name = "BeanMenu.findByIdMenu", query = "SELECT b FROM BeanMenu b WHERE b.idMenu = :idMenu"),
    @NamedQuery(name = "BeanMenu.findByPathMenu", query = "SELECT b FROM BeanMenu b WHERE b.pathMenu = :pathMenu"),
    @NamedQuery(name = "BeanMenu.findByCategoria", query = "SELECT b FROM BeanMenu b WHERE b.categoria = :categoria"),
    @NamedQuery(name = "BeanMenu.findByAcessoAdmin", query = "SELECT b FROM BeanMenu b WHERE b.acessoAdmin = :acessoAdmin"),
    @NamedQuery(name = "BeanMenu.findByAcessoNormal", query = "SELECT b FROM BeanMenu b WHERE b.acessoNormal = :acessoNormal"),
    @NamedQuery(name = "BeanMenu.findByIcone", query = "SELECT b FROM BeanMenu b WHERE b.icone = :icone")})
public class BeanMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu")
    private Integer idMenu;
    @Size(max = 200)
    @Column(name = "path_menu")
    private String pathMenu;
    @Size(max = 100)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 1)
    @Column(name = "acessoAdmin")
    private String acessoAdmin;
    @Size(max = 1)
    @Column(name = "acessoNormal")
    private String acessoNormal;
    @Size(max = 100)
    @Column(name = "icone")
    private String icone;

    public BeanMenu() {
    }

    public BeanMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getPathMenu() {
        return pathMenu;
    }

    public void setPathMenu(String pathMenu) {
        this.pathMenu = pathMenu;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAcessoAdmin() {
        return acessoAdmin;
    }

    public void setAcessoAdmin(String acessoAdmin) {
        this.acessoAdmin = acessoAdmin;
    }

    public String getAcessoNormal() {
        return acessoNormal;
    }

    public void setAcessoNormal(String acessoNormal) {
        this.acessoNormal = acessoNormal;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanMenu)) {
            return false;
        }
        BeanMenu other = (BeanMenu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bean.BeanMenu[ idMenu=" + idMenu + " ]";
    }
    
}
