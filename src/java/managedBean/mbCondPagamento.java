/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Bean.BeanCondicaopagamento;
import Sql.SqlCondPagamento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import util.Mensagem;

/**
 *
 * @author Fox w8
 */
@ManagedBean
public class mbCondPagamento {
    SqlCondPagamento sCondPag = new SqlCondPagamento();
    List<BeanCondicaopagamento> listaCondPag;
    Mensagem msg = new Mensagem();
    
    public void Gravar(BeanCondicaopagamento bCondPag){
        try {
            bCondPag.setStatusCondicao("A");
            sCondPag.gravar(bCondPag);
        } catch (Exception e) {
            msg.erro("Erro ao inserir!" + e.getMessage());
        }
    }
    
    public List<BeanCondicaopagamento> consultar(){
        try {
            listaCondPag = sCondPag.consultar();
        } catch (Exception e) {
        }
        return listaCondPag;
    }
}
