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
public class JPADeleteStandalone {
    
    public static void main(String[] args){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPASample01PU");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        EntityTransaction entityTransaction = entityManager.getTransaction();
        
        entityTransaction.begin();
        
        Meigara meigara = entityManager.find(Meigara.class, 10);
        
        if(meigara == null){
            entityTransaction.rollback();
        }
        else{
            entityManager.remove(meigara);

            entityTransaction.commit();
            
        }
            
            
        
        entityManager.close();
    }
    
}
