/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fox w8
 */
@ManagedBean(name = "bUsuario")
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanUsuario.findAll", query = "SELECT b FROM BeanUsuario b"),
    @NamedQuery(name = "BeanUsuario.findByIdUsuario", query = "SELECT b FROM BeanUsuario b WHERE b.idUsuario = :idUsuario"),
    @NamedQuery(name = "BeanUsuario.findByNome", query = "SELECT b FROM BeanUsuario b WHERE b.nome = :nome"),
    @NamedQuery(name = "BeanUsuario.findBySenha", query = "SELECT b FROM BeanUsuario b WHERE b.senha = :senha"),
    @NamedQuery(name = "BeanUsuario.findByAdministrador", query = "SELECT b FROM BeanUsuario b WHERE b.administrador = :administrador"),
    @NamedQuery(name = "BeanUsuario.findByCodUsuario", query = "SELECT b FROM BeanUsuario b WHERE b.codUsuario = :codUsuario")})
public class BeanUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "senha")
    private String senha;
    @Column(name = "administrador")
    private Character administrador;
    @Size(max = 20)
    @Column(name = "cod_usuario")
    private String codUsuario;
    @Size(max = 20)
    @Column(name = "senha2")
    private String senha2;
    
    public BeanUsuario() {
    }

    public BeanUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BeanUsuario(Integer idUsuario, String nome, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Character getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Character administrador) {
        this.administrador = administrador;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

   
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanUsuario)) {
            return false;
        }
        BeanUsuario other = (BeanUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bean.BeanUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
