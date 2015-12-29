/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Bean.BeanEmpresa;
import Bean.BeanUsuario;
import Sql.SqlEmpresa;
import Sql.sqlUsuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.Mensagem;

/**
 *
 * @author Fox w8
 */
@ManagedBean
@SessionScoped
public class mbEmpresa {
    BeanUsuario bUsuario = new BeanUsuario();
    Mensagem msg = new Mensagem();
    SqlEmpresa sEmpresa = new SqlEmpresa();
    sqlUsuario sUsuario = new sqlUsuario();
    mbUsuario mbusuario = new mbUsuario();
    
    public String cadastrar(BeanEmpresa bEmp, String senha, String confSenha) {
        if (senha.equals(confSenha)) {
            if (!bEmp.equals(null)) {
                bUsuario.setAdministrador('N');
                bUsuario.setCodUsuario(bEmp.getCnpjForcli());
                bUsuario.setNome(bEmp.getRazao());
                bUsuario.setSenha(senha);
                bUsuario.setSenha2(confSenha);
                
                sUsuario.gravar(bUsuario);
                
                bEmp.setCidade("Aparecida de Goiânia");
                bEmp.setEstado("GO");
                bEmp.setFantasia(bEmp.getRazao());
                sEmpresa.gravar(bEmp);
                
                mbusuario.setAdmin("N");
                mbusuario.setRazao(bEmp.getRazao());
                
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("usuario", mbusuario.getRazao()  );
                
                msg.advertencia("Cadastro Efetuado com sucesso!Faça o logina para entrar no site!");
                
            }
        } else {
            msg.erro("Senhas não conferem verifique!");
        }
        return null;
    }

}
