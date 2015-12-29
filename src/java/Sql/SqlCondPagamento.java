/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import Bean.BeanCondicaopagamento;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Fox w8
 */
public class SqlCondPagamento {
//    BeanCondicaopagamento bCondPag = new BeanCondicaopagamento();
    
    public void gravar(BeanCondicaopagamento bCondPag){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(bCondPag);
        tx.commit();
    }
    
    public List<BeanCondicaopagamento> consultar(){
        List<BeanCondicaopagamento> listaCondPag = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "from BeanCondicaopagamento";
        Query query = session.createQuery(hql);
        listaCondPag = query.list();
        return listaCondPag;
    }
    
    
}
