/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.dao;

import com.silvio.dominio.Vaga;
import com.silvio.operacoes.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SILVIO
 */
public class VagaDao extends DaoGenerico{
    
    public VagaDao(Class classe) {
        super(classe);
    }
    
    public List<Vaga> getVagasByIdEmpresa(int i) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "select v from Vaga v where v.empresa.id = :parametro";
        Query query = em.createQuery(jpql, Vaga.class);
        query.setParameter("parametro", i);
        return query.getResultList();
    }
    
    public List<Vaga> getVagasByCargo(String cargo){
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "select v from Vaga v where v.cargo like :parametro";
        Query query = em.createQuery(jpql,Vaga.class);
        query.setParameter("parametro", "%"+cargo+"%");
        return query.getResultList();
    }
    
    public List<Vaga> getVagasByCidade(String cidade) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "select v from Vaga v "
                + "inner join Empresa e "
                + "on e.endereco.cidade like :parametro "
                + "and v.empresa.id = e.id";
        Query query = em.createQuery(jpql, Vaga.class);
        query.setParameter("parametro", cidade);
        return query.getResultList();
    }
    
    public List<Vaga> getVagasByEstado(String estado) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "select v from Vaga v "
                + "inner join Empresa e "
                + "on e.endereco.uf like :parametro "
                + "and v.empresa.id = e.id";
        Query query = em.createQuery(jpql, Vaga.class);
        query.setParameter("parametro", estado);
        return query.getResultList();
    }
    
}
