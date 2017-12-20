/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author NVLCLT13
 */
public class JPAUpdateStandalone {
 
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPASample01PU");
        
        EntityManager em = entityManagerFactory.createEntityManager();
        
        EntityTransaction entityTransaction = em.getTransaction();
        
        entityTransaction.begin();
        
        Meigara meigara = em.find(Meigara.class, 10);

        meigara.setVolume(0.9f);
        meigara.setPrice(meigara.getPrice()+3);
        
        entityTransaction.commit();

        em.merge(meigara);
        
        
        
    }
}
