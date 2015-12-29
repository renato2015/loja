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
@ManagedBean(name = "bCondPagamento")
@Entity
@Table(name = "condicaopagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanCondicaopagamento.findAll", query = "SELECT b FROM BeanCondicaopagamento b"),
    @NamedQuery(name = "BeanCondicaopagamento.findByIdcondPagamento", query = "SELECT b FROM BeanCondicaopagamento b WHERE b.idcondPagamento = :idcondPagamento"),
    @NamedQuery(name = "BeanCondicaopagamento.findByDescricao", query = "SELECT b FROM BeanCondicaopagamento b WHERE b.descricao = :descricao"),
    @NamedQuery(name = "BeanCondicaopagamento.findByStatusCondicao", query = "SELECT b FROM BeanCondicaopagamento b WHERE b.statusCondicao = :statusCondicao"),
    @NamedQuery(name = "BeanCondicaopagamento.findByPrazoVenc", query = "SELECT b FROM BeanCondicaopagamento b WHERE b.prazoVenc = :prazoVenc"),
    @NamedQuery(name = "BeanCondicaopagamento.findByQtdParcela", query = "SELECT b FROM BeanCondicaopagamento b WHERE b.qtdParcela = :qtdParcela")})
public class BeanCondicaopagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_condPagamento")
    private Integer idcondPagamento;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status_condicao")
    private String statusCondicao;
    @Column(name = "prazo_venc")
    private Integer prazoVenc;
    @Column(name = "qtd_parcela")
    private Integer qtdParcela;

    public BeanCondicaopagamento() {
    }

    public BeanCondicaopagamento(Integer idcondPagamento) {
        this.idcondPagamento = idcondPagamento;
    }

    public BeanCondicaopagamento(Integer idcondPagamento, String statusCondicao) {
        this.idcondPagamento = idcondPagamento;
        this.statusCondicao = statusCondicao;
    }

    public Integer getIdcondPagamento() {
        return idcondPagamento;
    }

    public void setIdcondPagamento(Integer idcondPagamento) {
        this.idcondPagamento = idcondPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatusCondicao() {
        return statusCondicao;
    }

    public void setStatusCondicao(String statusCondicao) {
        this.statusCondicao = statusCondicao;
    }

    public Integer getPrazoVenc() {
        return prazoVenc;
    }

    public void setPrazoVenc(Integer prazoVenc) {
        this.prazoVenc = prazoVenc;
    }

    public Integer getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(Integer qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcondPagamento != null ? idcondPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanCondicaopagamento)) {
            return false;
        }
        BeanCondicaopagamento other = (BeanCondicaopagamento) object;
        if ((this.idcondPagamento == null && other.idcondPagamento != null) || (this.idcondPagamento != null && !this.idcondPagamento.equals(other.idcondPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bean.BeanCondicaopagamento[ idcondPagamento=" + idcondPagamento + " ]";
    }
    
}
