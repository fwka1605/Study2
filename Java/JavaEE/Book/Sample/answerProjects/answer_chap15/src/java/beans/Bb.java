package beans;

import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.*;

@Named
@RequestScoped
public class Bb {

    @Size(max = 5, min = 5)
    private String code;
    @Size(max = 20, min = 1)
    private String title;
    @Size(max = 10, min = 1)
    private String author;
    @NotNull
    private Integer price;
    @EJB
    BookDb db;
    @Inject
    transient Logger log;	// ログの記録用

    public String next() {
        create();			// 新規登録
        return null;		// 画面再表示
    }

    public void create() {
        Book emp = new Book(code, title, author, price);
        try {
            db.create(emp);
            log.info("●新規登録した/" + code);		// 成功
            clear();
        } catch (Exception e) {
            log.severe("★新規登録できない/" + code);	// 失敗

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
