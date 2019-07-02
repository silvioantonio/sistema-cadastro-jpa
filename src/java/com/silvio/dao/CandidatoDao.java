/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.dao;

import com.silvio.dominio.Candidato;
import com.silvio.operacoes.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author SILVIO
 */
public class CandidatoDao extends DaoGenerico {

    public CandidatoDao(Class classe) {
        super(classe);
    }

    public List<Candidato> getCandidatoByCargo(String cargo) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "select c from Candidato c "
                + "inner join Vaga v "
                + "on v.cargo like :parametro "
                + "and c.vaga.id = v.id";
        Query query = em.createQuery(jpql, Candidato.class);
        query.setParameter("parametro", "%"+cargo+"%");
        return query.getResultList();
    }
    
    public List<Candidato> getCandidatoByCidade(String cidade) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "select c from Candidato c "
                + "where c.endereco.cidade like :parametro ";
        Query query = em.createQuery(jpql, Candidato.class);
        query.setParameter("parametro", "%"+cidade+"%");
        return query.getResultList();
    }
    
    public List<Candidato> getCandidatoByEstado(String estado) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "select c from Candidato c "
                + "where c.endereco.uf like :parametro ";
        Query query = em.createQuery(jpql, Candidato.class);
        query.setParameter("parametro", "%"+estado+"%");
        return query.getResultList();
    }

}
