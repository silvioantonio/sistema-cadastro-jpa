/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.dao;

import com.silvio.dominio.Candidato;
import com.silvio.dominio.ExperienciaProficional;
import com.silvio.operacoes.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SILVIO
 */
public class ExperienciaDao extends DaoGenerico{
    
    public ExperienciaDao(Class classe) {
        super(classe);
    }
    
    public List<ExperienciaProficional> getExperienciaByCandidato(int candidato){
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "select ex from ExperienciaProficional ex "
                + "inner join Candidato c "
                + "on c.id = :parametro "
                + "and ex.candidato.id = c.id";
        Query query = em.createQuery(jpql, ExperienciaProficional.class);
        query.setParameter("parametro", candidato);
        return query.getResultList();
    }
    
}
