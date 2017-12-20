/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author NVLCLT13
 */

@Entity
@Table(name="BASKET")
public class Basket implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id = 0;
    
    @Column(name="USER_ID")
    private String userId = null;
    
    @OneToMany(targetEntity = BasketItem.class)
    private List basketItems = null;

    public Basket(){
    }
    
    public Basket(
        int id,
        String userId,
        List basketItem
    ){
         this.id=id;
         this.userId = userId;
         this.basketItems=basketItem;
                 
    }   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List basketItems) {
        this.basketItems = basketItems;
    }
    
    
}
