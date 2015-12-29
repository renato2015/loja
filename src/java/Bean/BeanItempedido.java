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
@Table(name = "itempedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanItempedido.findAll", query = "SELECT b FROM BeanItempedido b"),
    @NamedQuery(name = "BeanItempedido.findByIdItempedido", query = "SELECT b FROM BeanItempedido b WHERE b.idItempedido = :idItempedido"),
    @NamedQuery(name = "BeanItempedido.findByIdPedido", query = "SELECT b FROM BeanItempedido b WHERE b.idPedido = :idPedido"),
    @NamedQuery(name = "BeanItempedido.findByVlTotal", query = "SELECT b FROM BeanItempedido b WHERE b.vlTotal = :vlTotal"),
    @NamedQuery(name = "BeanItempedido.findByItemPedido", query = "SELECT b FROM BeanItempedido b WHERE b.itemPedido = :itemPedido"),
    @NamedQuery(name = "BeanItempedido.findByCodProduto", query = "SELECT b FROM BeanItempedido b WHERE b.codProduto = :codProduto"),
    @NamedQuery(name = "BeanItempedido.findByDescricao", query = "SELECT b FROM BeanItempedido b WHERE b.descricao = :descricao"),
    @NamedQuery(name = "BeanItempedido.findByVlrUnitario", query = "SELECT b FROM BeanItempedido b WHERE b.vlrUnitario = :vlrUnitario")})
public class BeanItempedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_itempedido")
    private Integer idItempedido;
    @Column(name = "id_pedido")
    private Integer idPedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_total")
    private Double vlTotal;
    @Column(name = "item_pedido")
    private Integer itemPedido;
    @Column(name = "cod_produto")
    private Integer codProduto;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 45)
    @Column(name = "vlr_unitario")
    private String vlrUnitario;

    public BeanItempedido() {
    }

    public BeanItempedido(Integer idItempedido) {
        this.idItempedido = idItempedido;
    }

    public Integer getIdItempedido() {
        return idItempedido;
    }

    public void setIdItempedido(Integer idItempedido) {
        this.idItempedido = idItempedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public Integer getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(Integer itemPedido) {
        this.itemPedido = itemPedido;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(String vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItempedido != null ? idItempedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanItempedido)) {
            return false;
        }
        BeanItempedido other = (BeanItempedido) object;
        if ((this.idItempedido == null && other.idItempedido != null) || (this.idItempedido != null && !this.idItempedido.equals(other.idItempedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bean.BeanItempedido[ idItempedido=" + idItempedido + " ]";
    }
    
}
