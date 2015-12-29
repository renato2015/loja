/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Bean.BeanAlteraSenha;
import Bean.BeanUsuario;
import Sql.sqlUsuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.Mensagem;

/**
 *
 * @author Fox w8
 */
@ManagedBean(name = "mbusuario")
@SessionScoped
public class mbUsuario {

    public mbUsuario() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
    }
    
    
    private boolean disabled = true;
    
    BeanAlteraSenha bUsuario = new BeanAlteraSenha();
    Mensagem msg = new Mensagem();
    sqlUsuario sUsuario = new sqlUsuario();
    private String usuario;
    private String senha, senha2;    
    private String razao;
    private String admin;

    public String logar() {
        List<BeanUsuario> listaUsu;
        listaUsu = sUsuario.logar(usuario);
        for (int i = 0; i < listaUsu.size(); i++) {
            String cnpj = listaUsu.get(i).getCodUsuario();
            String senhabd = listaUsu.get(i).getSenha();
            if (cnpj.equals(usuario) && senhabd.equals(this.senha)) {
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("usuario", this.razao);
                String usu = "02461097186";
                razao = listaUsu.get(i).getNome();
                if (usuario.equals(usu) && listaUsu.get(i).getAdministrador() == 'S') {
                    return "produtos/administrador.xhtml?faces-redirect=true";
                } else {
                    return "produtos/produto.xhtml?faces-redirect=true";
                }
            }
        }
        msg.erro("Usuário e/ou senha não são iguais!Verifique!");
        return null;

    }

    public String sair() {
        this.razao = null;
        this.usuario = null;        

        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.removeAttribute("usuario");
        mbCarrinho mbCarrinho = new mbCarrinho();
//        mbCarrinho.getListaCarrinho() == null;
        return "/index.xhtml?faces-redirect=true";
    }

    public void alterarSenha(String cnpj, String senha1, String senha2, String senhaVelha) {
        @SuppressWarnings("UnusedAssignment")
        BeanUsuario bUsu = new BeanUsuario();
        bUsu = sUsuario.consultar(cnpj);

        try {
            if (senhaVelha.equals(bUsu.getSenha())) {
                if (senha1.equals(senha2)) {
                    bUsu.setSenha(senha1);
                    sUsuario.alterarSenha(bUsu);
                } else {
                    msg.erro("As senhas são diferente verifique!");
                }
            }else{
                msg.erro("Senha Atual não confere!Verifique!");
            }
        } catch (Exception e) {
            msg.erro("Erro ao alterar senha!Verifique!"+ e.getMessage());
        }
    }
    
    public void consultarUsuario(){
        BeanUsuario bUsu;        
        bUsu = sUsuario.consultar(usuario);
        if(bUsu != null) {
            setRazao(bUsu.getNome());
            disabled = false;
        }
        else msg.erro("Usuario não Encontrado verifique!");
    }
    
    public void limpar(){
        setRazao("");
        setAdmin("");
        setSenha("");
        setUsuario("");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }
    
    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public boolean isDisabled() {
        return disabled;
    }

    
}
