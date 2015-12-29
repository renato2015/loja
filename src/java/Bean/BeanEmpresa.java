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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fox w8
 */
@ManagedBean(name = "bEmp")
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanEmpresa.findAll", query = "SELECT b FROM BeanEmpresa b"),
    @NamedQuery(name = "BeanEmpresa.findByIdEmpresa", query = "SELECT b FROM BeanEmpresa b WHERE b.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "BeanEmpresa.findByCnpjForcli", query = "SELECT b FROM BeanEmpresa b WHERE b.cnpjForcli = :cnpjForcli"),
    @NamedQuery(name = "BeanEmpresa.findByEndereco", query = "SELECT b FROM BeanEmpresa b WHERE b.endereco = :endereco"),
    @NamedQuery(name = "BeanEmpresa.findByBairro", query = "SELECT b FROM BeanEmpresa b WHERE b.bairro = :bairro"),
    @NamedQuery(name = "BeanEmpresa.findByCidade", query = "SELECT b FROM BeanEmpresa b WHERE b.cidade = :cidade"),
    @NamedQuery(name = "BeanEmpresa.findByEstado", query = "SELECT b FROM BeanEmpresa b WHERE b.estado = :estado"),
    @NamedQuery(name = "BeanEmpresa.findByComplemento", query = "SELECT b FROM BeanEmpresa b WHERE b.complemento = :complemento"),
    @NamedQuery(name = "BeanEmpresa.findByTelCelular", query = "SELECT b FROM BeanEmpresa b WHERE b.telCelular = :telCelular"),
    @NamedQuery(name = "BeanEmpresa.findByTelFixo", query = "SELECT b FROM BeanEmpresa b WHERE b.telFixo = :telFixo"),
    @NamedQuery(name = "BeanEmpresa.findByCep", query = "SELECT b FROM BeanEmpresa b WHERE b.cep = :cep"),
    @NamedQuery(name = "BeanEmpresa.findByRazao", query = "SELECT b FROM BeanEmpresa b WHERE b.razao = :razao"),
    @NamedQuery(name = "BeanEmpresa.findByFantasia", query = "SELECT b FROM BeanEmpresa b WHERE b.fantasia = :fantasia")})
public class BeanEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Size(max = 14)
    @Column(name = "cnpj_forcli")
    private String cnpjForcli;
    @Size(max = 45)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 45)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 45)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "tel_celular")
    private Integer telCelular;
    @Column(name = "tel_fixo")
    private Integer telFixo;
    @Column(name = "cep")
    private Integer cep;
    @Size(max = 100)
    @Column(name = "razao")
    private String razao;
    @Size(max = 100)
    @Column(name = "fantasia")
    private String fantasia;
    
    @Size(max = 100)
    @Column(name= "email")
    private String email;
    
    public BeanEmpresa() {
    }

    public BeanEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCnpjForcli() {
        return cnpjForcli;
    }

    public void setCnpjForcli(String cnpjForcli) {
        this.cnpjForcli = cnpjForcli;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(Integer telCelular) {
        this.telCelular = telCelular;
    }

    public Integer getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(Integer telFixo) {
        this.telFixo = telFixo;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanEmpresa)) {
            return false;
        }
        BeanEmpresa other = (BeanEmpresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bean.BeanEmpresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
