/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author NVLCLT13
 */
@Named
@RequestScoped
public class Bb implements Serializable{

    @Size(max=5,min=5)
    String code;
    
    @Size(max=20,min=1)
    String title;
    
    @Size(max=10,min=1)
    String author;
    
    @NotNull
    Integer price;
    
    @EJB
    BookDb bookDb;
    
    @Inject
    transient Logger log;

    public String next(){
        create();
        return null;
    }
    

    public void create() {
        Book emp = new Book(code, title, author, price);
        try {
            bookDb.create(emp);
            log.info("●新規登録した/" + code);		// 成功
            clear();
        } catch (Exception e) {
            log.severe("★新規登録できない/" + code);	// 失敗
            e.printStackTrace();
        }
    }

    public void clear() {	// 表示用に変数をクリアする
        code = title = author = null;
        price = null;
    }    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    

}
