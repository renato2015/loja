/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Bean.BeanCategoria;
import Bean.BeanProduto;
import Sql.SqlCategoria;
import Sql.sqlProduto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Mensagem;

/**
 *
 * @author Fox w8
 */
@ManagedBean(name = "mbProduto")
@SessionScoped
public class mbProduto {
    BeanProduto bProd = new BeanProduto();
    Mensagem msg = new Mensagem();
    sqlProduto sProduto = new sqlProduto();
    SqlCategoria sCategoria = new SqlCategoria();

    BeanCategoria bCategoria = new BeanCategoria();
    BeanProduto bProduto;    
    BeanProduto beanProduto;
    
    
    private List<BeanProduto> lista1;
    private List<BeanProduto> lista2;
    private List<BeanProduto> lista3;

    private List<BeanProduto> listaCarrinho;
    List<BeanCategoria> listaCategoria;

    public mbProduto() {
    }

    public void gravar(BeanProduto bProduto) {
        BeanProduto bProd;
        bProd = sProduto.listaTudo(bProduto.getCodProduto());
        try {
            if (bProd != null) {
                if (!bProduto.getCodProduto().equals(bProd.getCodProduto())) {
                    bProduto.setPathImagem("home/imagens/" + bProduto.getCodProduto() + ".jpg");
                    //Gravar Categoria
                    listaCategoria = sCategoria.consultar();
                    for (int i = 0; i < listaCategoria.size(); i++) {
                        if (!listaCategoria.get(i).getCategoria().equals(bProduto.getCategoria())) {
                            bCategoria.setCategoria(bProduto.getCategoria());
                            bCategoria.setDesCategoria(bProd.getDescCategoria());
                            sCategoria.gravarCategoria(bCategoria);
                        }
                    }
                    //Gravar produto
                    sProduto.gravarProduto(bProduto);
                    msg.advertencia("Produto gravado com sucesso!");
                } else {
                    msg.erro("Esse código de  produto já Existe cadastrado");
                }
            } else {
                bProduto.setPathImagem("/resources/Imagens/" + bProduto.getCodProduto() + ".jpg");
                //Gravar Categoria
                listaCategoria = sCategoria.consultar();
                for (int i = 0; i == 1; i++) {
                    if (!listaCategoria.get(i).getCategoria().equals(bProduto.getCategoria())) {
                        bCategoria.setCategoria(bProduto.getCategoria());
                        bCategoria.setDesCategoria(bProduto.getDescCategoria());
                        sCategoria.gravarCategoria(bCategoria);
                    }
                }
                sProduto.gravarProduto(bProduto);
                msg.advertencia("Produto gravado com sucesso!");
            }
        } catch (Exception e) {
            msg.erro("Erro ao gravar o produto." + e.getMessage());
        }
    }

    public List<BeanProduto> consultar() {
        List<BeanProduto> listaProduto = null;
        try {
            listaProduto = sProduto.consultar();
            if (listaProduto == null) {
                msg.erro("Produto não cadastrado.");
            }
        } catch (Exception e) {
            msg.erro("Erro ao consultar." + e.getMessage());
        }
        return listaProduto;
    }

    public void excluir(String codProduto) {
        try {
            bProduto = new BeanProduto();
            if (codProduto.equals("")) {
                msg.erro("Para Excluir um produto tem que colocar o código do produto!");
            } else {
                bProduto = sProduto.consultarId(codProduto);
                sProduto.excluir(bProduto);
            }
        } catch (Exception e) {
            msg.erro("Erro ao excluir!" + e.getMessage());
        }
        msg.advertencia("Registro excluído com sucesso!");
    }

    public void alterar(String codProduto, String descCat, String categoria, String descricao, float vlUnitario) {
        try {
            bProduto = new BeanProduto();
            if (codProduto.equals("")) {
                msg.erro("Para alterar um produto tem que colocar o código do produto!");
            } else {
                bProduto.setCodProduto(codProduto);
                bProduto.setCategoria(categoria);
                bProduto.setDescCategoria(descCat);
                bProduto.setDescricao(descricao);
                bProduto.setVlUnitario(vlUnitario);
                sProduto.alterar(bProduto);
                msg.advertencia("Registro alterado com sucesso!");
            }
        } catch (Exception e) {
            msg.erro("Erro ao alterar!" + e.getMessage());
        }
    }


    public BeanProduto consultaProduto(String categoria) {        
        beanProduto = sProduto.consultaCarrinho(categoria);
        return beanProduto;
    }

    public String carrinho() {        
        return "/produtos/carrinho.xhtml?faces-redirect=true";
    }

    public List<BeanProduto> getListaCarrinho() {     
   //     listaCarrinho.add(bProduto);
        return listaCarrinho;
    }

    public void setListaCarrinho(List<BeanProduto> listaCarrinho) {
        this.listaCarrinho = listaCarrinho;
    }

    
    

}
