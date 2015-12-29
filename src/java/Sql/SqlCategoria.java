/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import Bean.BeanCategoria;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Fox w8
 */
public class SqlCategoria {
    List<BeanCategoria> listaCategoria;
    
    public void gravarCategoria(BeanCategoria bCategoria){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(bCategoria);
        tx.commit();        
    }
    
    public List<BeanCategoria> consultar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "from BeanCategoria";
        Query query = session.createQuery(sql);
        listaCategoria = query.list();
        return listaCategoria;
    }
}
