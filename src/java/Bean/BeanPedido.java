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
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanPedido.findAll", query = "SELECT b FROM BeanPedido b"),
    @NamedQuery(name = "BeanPedido.findByIdPedido", query = "SELECT b FROM BeanPedido b WHERE b.idPedido = :idPedido"),
    @NamedQuery(name = "BeanPedido.findByPedido", query = "SELECT b FROM BeanPedido b WHERE b.pedido = :pedido"),
    @NamedQuery(name = "BeanPedido.findByVlTotal", query = "SELECT b FROM BeanPedido b WHERE b.vlTotal = :vlTotal"),
    @NamedQuery(name = "BeanPedido.findByQtdIten", query = "SELECT b FROM BeanPedido b WHERE b.qtdIten = :qtdIten"),
    @NamedQuery(name = "BeanPedido.findByCnpjForcli", query = "SELECT b FROM BeanPedido b WHERE b.cnpjForcli = :cnpjForcli"),
    @NamedQuery(name = "BeanPedido.findByRazao", query = "SELECT b FROM BeanPedido b WHERE b.razao = :razao")})
public class BeanPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Column(name = "pedido")
    private Integer pedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_total")
    private Double vlTotal;
    @Column(name = "qtd_iten")
    private Integer qtdIten;
    @Size(max = 14)
    @Column(name = "cnpj_forcli")
    private String cnpjForcli;
    @Size(max = 100)
    @Column(name = "razao")
    private String razao;

    public BeanPedido() {
    }

    public BeanPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public Integer getQtdIten() {
        return qtdIten;
    }

    public void setQtdIten(Integer qtdIten) {
        this.qtdIten = qtdIten;
    }

    public String getCnpjForcli() {
        return cnpjForcli;
    }

    public void setCnpjForcli(String cnpjForcli) {
        this.cnpjForcli = cnpjForcli;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanPedido)) {
            return false;
        }
        BeanPedido other = (BeanPedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bean.BeanPedido[ idPedido=" + idPedido + " ]";
    }
    
}
