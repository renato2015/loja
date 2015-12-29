/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import Bean.BeanProduto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Fox w8
 */
public class sqlProduto {

    List<BeanProduto> listProduto;

    public void gravarProduto(BeanProduto bProduto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(bProduto);
        tx.commit();
    }

    public List<BeanProduto> consultar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "from BeanProduto as bProd order by bProd.categoria";
        Query query = session.createQuery(sql);
        listProduto = query.list();
        return listProduto;
    }

    public List<BeanProduto> consultarProd(String categoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "from BeanProduto as bProd where bProd.categoria = :categoria order by bProd.codProduto";
        Query query = session.createQuery(sql);
        query.setParameter("categoria", categoria);
        listProduto = query.list();
        return listProduto;
    }
    
    public BeanProduto consultarProduto(String categoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "from BeanProduto as bProd where bProd.categoria = :categoria order by bProd.codProduto";
        Query query = session.createQuery(sql);
        query.setParameter("categoria", categoria);
        BeanProduto bProd = (BeanProduto) query.uniqueResult();
        return bProd;
    }
    
     public BeanProduto consultaCarrinho(String codProduto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "from BeanProduto as bProd where bProd.codProduto = :codProduto order by bProd.codProduto";
        Query query = session.createQuery(sql);
        query.setParameter("codProduto", codProduto);
        BeanProduto bProd = (BeanProduto) query.uniqueResult();
        return bProd;
    }

    public void excluir(BeanProduto bProduto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(bProduto);
        tx.commit();
    }

    public BeanProduto consultarId(String codProd) {
        BeanProduto bProduto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "from BeanProduto as bProd where bProd.codProduto = :codProd";
        Query query = session.createQuery(sql);
        query.setParameter("codProd", codProd);
        bProduto = (BeanProduto) query.uniqueResult();
        return bProduto;
    }

    public BeanProduto listaTudo(String codProduto) {
        BeanProduto bProd = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "from BeanProduto as bProd where bProd.codProduto = :codProd";
        Query query = session.createQuery(sql);
        query.setParameter("codProd", codProduto);
        bProd = (BeanProduto) query.uniqueResult();

        return bProd;
    }

    public void alterar(BeanProduto bProduto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(bProduto);
        tx.commit();
    }

    public BeanProduto consultaCategoria(String categoria) {
        BeanProduto bProduto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "from BeanProduto as bProd where bProd.categoria = :categoria group by bProd.categoria";
        Query query = session.createQuery(sql);
        query.setParameter("categoria", categoria);
        bProduto = (BeanProduto) query.uniqueResult();
        return bProduto;
    }

}
