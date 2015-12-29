/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Sql.sqlProduto;
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
@ManagedBean(name = "BeanProduto")
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanProduto.findAll", query = "SELECT b FROM BeanProduto b"),
    @NamedQuery(name = "BeanProduto.findByIdProduto", query = "SELECT b FROM BeanProduto b WHERE b.idProduto = :idProduto"),
    @NamedQuery(name = "BeanProduto.findByVlUnitario", query = "SELECT b FROM BeanProduto b WHERE b.vlUnitario = :vlUnitario"),
    @NamedQuery(name = "BeanProduto.findByPathImagem", query = "SELECT b FROM BeanProduto b WHERE b.pathImagem = :pathImagem"),
    @NamedQuery(name = "BeanProduto.findByCodProduto", query = "SELECT b FROM BeanProduto b WHERE b.codProduto = :codProduto"),
    @NamedQuery(name = "BeanProduto.findByDescricao", query = "SELECT b FROM BeanProduto b WHERE b.descricao = :descricao"),
    @NamedQuery(name = "BeanProduto.findByCategoria", query = "SELECT b FROM BeanProduto b WHERE b.categoria = :categoria"),
    @NamedQuery(name = "BeanProduto.findByDescCategoria", query = "SELECT b FROM BeanProduto b WHERE b.descCategoria = :descCategoria")})
public class BeanProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Integer idProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vl_unitario")
    private double vlUnitario;
    @Size(max = 100)
    @Column(name = "path_imagem")
    private String pathImagem;
    @Size(max = 20)
    @Column(name = "cod_produto")
    private String codProduto;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 100)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 100)
    @Column(name = "desc_categoria")
    private String descCategoria;

    public BeanProduto() {
    }

    public BeanProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public BeanProduto(Integer idProduto, double vlUnitario) {
        this.idProduto = idProduto;
        this.vlUnitario = vlUnitario;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public double getVlUnitario() {
        return vlUnitario;
    }

    public void setVlUnitario(double vlUnitario) {
        this.vlUnitario = vlUnitario;
    }

    public String getPathImagem() {
        return pathImagem;
    }

    public void setPathImagem(String pathImagem) {
        this.pathImagem = pathImagem;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanProduto)) {
            return false;
        }
        BeanProduto other = (BeanProduto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bean.BeanProduto[ idProduto=" + idProduto + " ]";
    }

    public void pesqCodProd() {
        sqlProduto sProd = new sqlProduto();
        BeanProduto bProd;
        bProd = sProd.consultarId(codProduto);
        setCodProduto(bProd.getCodProduto());
        setDescricao(bProd.getDescricao());
        setVlUnitario(bProd.getVlUnitario());
        setCategoria(bProd.categoria);
    }

    public void pesqCategoria() {
        sqlProduto sProd = new sqlProduto();
        BeanProduto bProd;
        bProd = sProd.consultaCategoria(categoria);
        setDescCategoria(bProd.getDescCategoria());
        setCodProduto(codProduto);
        setDescricao(descricao);
        setVlUnitario(vlUnitario);
    }

    public void limpar() {
        setVlUnitario(0);
        setCategoria("");
        setDescricao("");
        setCodProduto("");
    }
}
