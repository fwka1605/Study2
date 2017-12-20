/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jp.co.nouvelle.entity.Basket;

/**
 *
 * @author NVLCLT13
 */
@Stateless(name="JPASession01Remote")
public class JPASession01Bean implements JPASession01Remote {

 

    @PersistenceContext(unitName = "JPASample02-ejbPU")
    private EntityManager entityManager;
    
    public JPASession01Bean() {
    }

    public JPASession01Bean(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    public List getMeisai(){
        List meisaiList = null;
        
        Query query = entityManager.createQuery(
            "select " + 
            "   *   " + 
            "from   " + 
            "   MEISAI" 
        );
        
        
        
        meisaiList = query.getResultList();

        return meisaiList;
    }    
    
    public void insertBasketItems(int[] meigaraIds){
        List   basketList = null; 
        Basket basket = null;
        
        Query query = entityManager.createQuery(
            "select     " + 
            "   *       " +
            "from       " + 
            "   BASKET  " + 
            "where      " +
            "   USER_ID= :userId"
        );
        
        query.setParameter("userId", "tomoharu");
        
        basketList = query.getResultList();
        
        if(basketList ==null || basketList.size()==0){
            basket = new Basket();
            basket.setUserId("tomoharu");
            entityManager.persist(basket);
            entityManager.flush();
        }
        else{
            basket = basketList.get(0);
        }
        
    }
}
