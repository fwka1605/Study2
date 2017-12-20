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
public class JPAInsertStandalone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Entityマネージャファクトリを生成する
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("JPASample01PU");
        
         // Entityマネージャを生成する
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
         // Entityトランザクションを取得し、トランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        
        entityTransaction.begin();
        
        Meigara meigara = new Meigara( "千鶴", "ちづる", 25, "白", "黄金千貫", "神酒造", 1.8f, 1946);
        entityManager.persist(meigara);
        
        entityTransaction.commit();
        
        entityManager.close();
        
        
        
    }
    
}
