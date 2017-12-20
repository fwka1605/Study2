/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author NVLCLT13
 */
@Entity
@Table(name="BASKET_ITEM")
public class BasketItem implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id = 0;

    @ManyToOne(targetEntity = Basket.class)
    @JoinColumn(name = "BASKET_ID" ,referencedColumnName = "ID")
    @Column(name = "BASKET_ID")
    private Basket basketId = null;
    
   @ManyToOne(targetEntity = Meigara.class)
   @JoinColumn(name = "MEIGARA_ID" ,referencedColumnName = "ID")
   @Column(name = "MEIGARA_ID")
   private Meigara meigara = null;
    
   @Column(name = "QUANTITY")
   private int quantity = 0;
   
   public BasketItem(){
   }

   public BasketItem(
           int id,
           Basket basketId,
           Meigara meigara,
           int quantity
   ){
       this.id = id;
       this.basketId = basketId;
       this.meigara = meigara;
       
       this.quantity = quantity;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Basket getBasketId() {
        return basketId;
    }

    public void setBasketId(Basket basketId) {
        this.basketId = basketId;
    }

    public Meigara getMeigara() {
        return meigara;
    }

    public void setMeigara(Meigara meigara) {
        this.meigara = meigara;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
   
}
