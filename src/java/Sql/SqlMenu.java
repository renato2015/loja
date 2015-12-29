/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import Bean.BeanMenu;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Fox w8
 */
public class SqlMenu {
    
    public List<BeanMenu> listaMenuAdmin(){
        List<BeanMenu> lista ;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "from BeanMenu";
        Query query = session.createQuery(hql);
        lista = query.list();
        return lista;
    }
    
    public List<BeanMenu> listaMenu(String admin){
        List<BeanMenu> lista ;        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "from BeanMenu as bMenu where bMenu.acessoNormal = :admin";
        Query query = session.createQuery(hql);
        query.setParameter("admin", admin);
        lista = query.list();
        return lista;
    }
}
