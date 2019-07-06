/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.dao;

import com.silvio.operacoes.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SILVIO
 * @param <T>
 */
public class DaoGenerico<T> implements IDaoGenerico<T> {

    private final Class<T> classe;
    
    DaoGenerico(Class classe){
        this.classe = classe;
    }

    @Override
    public void add(T u) {
        EntityManager em = JpaUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }catch(Exception e){
            System.err.println("Erro: " + e);
            em.getTransaction().rollback();
        }
    }

    @Override
    public void upd(T u) {
        EntityManager em = JpaUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }catch(Exception e){
            System.err.println("Erro: "+ e);
            em.getTransaction().rollback();
        }
    }

    @Override
    public void del(T u) {
        EntityManager em = JpaUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            
            //u = em.merge(u);
            em.remove(em.contains(u) ? u : em.merge(u));
            em.getTransaction().commit();
        }catch(Exception e){
            System.err.println("Erro: "+e);
            em.getTransaction().rollback();
        }
    }

    @Override
    public T findById(int id) {
        EntityManager em = JpaUtil.getEntityManager();

        T u = (T) em.find(classe, id);

        return u;
    }

    @Override
    public List<T> listaAll() {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "from "+classe.getSimpleName();
        List<T> lista = em.createQuery(jpql, classe).getResultList();
        return lista;
    }
    
    @Override
    public List<T> JpqlLike(String campo, String valor) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "select t from "+classe.getSimpleName()+" t where t."+campo+" like :pbusca";
        Query query = em.createQuery(jpql, classe);
        query.setParameter("pbusca", "%"+valor+"%");
        List<T> lista = query.getResultList();
        //em.close();
        return lista;
    }
 
}
