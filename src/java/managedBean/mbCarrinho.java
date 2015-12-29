/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Bean.BeanProduto;
import Sql.sqlProduto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fox w8
 */
@SessionScoped
@ManagedBean
public class mbCarrinho {

    BeanProduto bProd = new BeanProduto();

    private List<BeanProduto> lista1;
    private List<BeanProduto> lista2;
    private List<BeanProduto> lista3;
    private List<BeanProduto> listaCarrinho = new ArrayList<>();

    sqlProduto sProduto = new sqlProduto();

    public List<BeanProduto> getLista1() {
        if (lista1 == null) {
            lista1 = sProduto.consultarProd("1");
        }
        return lista1;
    }

    public List<BeanProduto> getLista2() {
        if (lista2 == null) {
            lista2 = sProduto.consultarProd("2");
        }
        return lista2;
    }

    public List<BeanProduto> getLista3() {
        if (lista3 == null) {
            lista3 = sProduto.consultarProd("3");
        }
        return lista3;
    }

    public List<BeanProduto> consultaProd(String categoria) {
        List<BeanProduto> bProd = sProduto.consultarProd(categoria);
        return bProd;
    }
    
    public String finalizar(){
        return "carrinho.xhtml";
    }

    //Metodo Getter e setter da lista de carrinho
    public List<BeanProduto> getListaCarrinho() {
        //     listaCarrinho.add(bProduto);
        return listaCarrinho;
    }
    
    public void setListaCarrinho(List<BeanProduto> listaCarrinho) {
        this.listaCarrinho = listaCarrinho;
    }
}
