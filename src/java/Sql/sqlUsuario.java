/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import Bean.BeanUsuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.Transaction;

import util.HibernateUtil;

/**
 *
 * @author Fox w8
 */
public class sqlUsuario {
    List<BeanUsuario> listaEmp;
    public List<BeanUsuario> logar(String usuario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from BeanUsuario as usuario where usuario.codUsuario = :usuario";        
        Query query = session.createQuery(hql);
        query.setParameter("usuario", usuario);
        listaEmp = query.list();
        return listaEmp;
    }

    public BeanUsuario consultar(String cnpj) {
        BeanUsuario bUsuario;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from BeanUsuario as usuario where usuario.codUsuario = :cnpj";        
        Query query = session.createQuery(hql);
        query.setParameter("cnpj", cnpj);
        bUsuario = (BeanUsuario) query.uniqueResult();
                
        return bUsuario;        
    }

    public void alterarSenha(BeanUsuario bUsuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(bUsuario);
        transaction.commit();
    }

    public BeanUsuario listaUsuario(String usuario) {
        BeanUsuario lista;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from BeanUsuario as bUsu where bUsu.codUsuario = :usuario";                
        Query query = session.createQuery(hql);
        query.setParameter("usuario", usuario);
        lista = (BeanUsuario) query.uniqueResult();
        return lista;
    }

    public void gravar(BeanUsuario bUsuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bUsuario);
        transaction.commit();
    }
}
