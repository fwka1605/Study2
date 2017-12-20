package beans;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.*;

@Entity
public class Book implements Serializable {

    @Id
    @NotNull
    private String code;		// コード番号
    private String title;		// 題名
    private String author;		// 著者名
    private Integer price;		// 価格

    public Book() {
    }

    public Book(String code, String title, String author, Integer price) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // セッターとゲッター
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
