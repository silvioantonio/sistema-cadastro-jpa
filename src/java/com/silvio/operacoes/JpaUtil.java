package com.silvio.operacoes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author SILVIO
 */
public class JpaUtil {
    private static final EntityManagerFactory emf;
    private static EntityManager em;

    static {

        try {

            emf = Persistence.createEntityManagerFactory("persistencia");

        } catch (Throwable ex) {
            // Log exception!   
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {

        em = emf.createEntityManager();

        return em;
    }
}
