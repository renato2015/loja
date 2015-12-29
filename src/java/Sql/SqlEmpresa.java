/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import Bean.BeanEmpresa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.Mensagem;

/**
 *
 * @author Fox w8
 */
public class SqlEmpresa {
    Mensagem msg = new Mensagem();
    
    public void gravar(BeanEmpresa bEmp) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(bEmp);
            tx.commit();
        } catch (Exception e) {
            msg.erro("Erro ao cadastrar Empresa!" + e.getMessage());                        
        }
    }
    
}
