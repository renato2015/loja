/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Fox w8
 */
@ManagedBean(name = "bAlteraSenha")
public class BeanAlteraSenha {
    private String senhaVelha;
    private String senhanova1;
    private String senhanova2;
    private String razao, cnpj;
    

    public String getSenhaVelha() {
        return senhaVelha;
    }

    public void setSenhaVelha(String senhaVelha) {
        this.senhaVelha = senhaVelha;
    }

    public String getSenhanova1() {
        return senhanova1;
    }

    public void setSenhanova1(String senhanova1) {
        this.senhanova1 = senhanova1;
    }

    public String getSenhanova2() {
        return senhanova2;
    }

    public void setSenhanova2(String senhanova2) {
        this.senhanova2 = senhanova2;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getCnpj() {
        return cnpj;
    }
    
}
