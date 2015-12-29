/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Bean.BeanMenu;
import Bean.BeanUsuario;
import Sql.SqlMenu;
import Sql.sqlUsuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Fox w8
 */
@ManagedBean
@SessionScoped
public class mbMenu {

    private List<BeanMenu> listaMenu;
    SqlMenu sMenu = new SqlMenu();
    sqlUsuario sUsuario = new sqlUsuario();

    mbUsuario mbUsuario;
    private MenuModel menuModel;

    List<BeanMenu> lista;
    List<BeanMenu> listaAdmin;

    public MenuModel geraMenu(String usuario) {
        
        menuModel = new DefaultMenuModel();

        listaAdmin = sMenu.listaMenuAdmin();
        BeanUsuario bUsuario = sUsuario.listaUsuario(usuario);

        if (bUsuario.getAdministrador() == 'S') {
            for (int i = 0; i < listaAdmin.size(); i++) {
                DefaultMenuItem item = new DefaultMenuItem();
                item.setValue(listaAdmin.get(i).getCategoria());
                item.setOutcome(listaAdmin.get(i).getPathMenu());
                item.setIcon(listaAdmin.get(i).getIcone());
//                if( i == listaAdmin.size() -1){
//                    item.setCommand(sair());
//                }
                menuModel.addElement(item);
            }
        } else {
            String admin = "S";
            lista = sMenu.listaMenu(admin);
            for (int i = 0; i < lista.size(); i++) {
                DefaultMenuItem item = new DefaultMenuItem();
                item.setValue(lista.get(i).getCategoria());
                item.setOutcome(lista.get(i).getPathMenu());
                item.setIcon(lista.get(i).getIcone());
//                if( i == listaAdmin.size() -1){
//                    item.setOnclick(mbUsuario.sair());
//                }
                menuModel.addElement(item);
            }
        }
        
        return menuModel;
    }

    public MenuModel getMemuModel() {
        return menuModel;
    }
    
    
    public String sair() {
//        this.razao = null;
//        this.usuario = null;        

        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.removeAttribute("usuario");

        return "/index.xhtml?faces-redirect=true";
    }

}
