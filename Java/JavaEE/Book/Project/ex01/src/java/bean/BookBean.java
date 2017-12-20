/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author NVLCLT13
 */
@Named
@RequestScoped
public class BookBean {
    private String title;
    private String author;
    private Integer price;

    public String next(){
        System.out.println("★書籍名=" + title + " / 著者名=" + author + " / 価格=" + price);
        return "output";
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
