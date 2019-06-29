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

    
}
