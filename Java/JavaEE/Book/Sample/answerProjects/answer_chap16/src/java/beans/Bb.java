package beans;

import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import util.FileUtil;

@Named
@RequestScoped
public class Bb implements Serializable {

    private BkKey id;			// 主キー
    private String title;		// 題名
    private String author;		// 著者名
    private Calendar pdate;		// 作成年月日
    private String text;		// 本文

    @EJB
    BookDb db;

    @PostConstruct
    public void init() {
        BkKey key = new BkKey("aozora", "1");
        Book book = db.find(key);
        if (book == null) {
            id = key;
            title = "杜子春";
            author = "芥川龍之介";
            pdate = Calendar.getInstance();
            pdate.set(2004, 2, 14);
            text = FileUtil.getText("/resources/data/toshishun.txt");
            book = new Book(id, title, author, pdate, text);
            create(book);
        } else {
            id = book.getId();
            title = book.getTitle();
            author = book.getAuthor();
            pdate = book.getPdate();
            text = book.getText();
        }
    }

    public String save() {
        Book book = new Book(id, title, author, pdate, text);
        update(book);
        return null;
    }

    ///////////////////////////////////
    public void create(Book book) {
        try {
            db.create(book);
        } catch (Exception e) {
        }
    }

    public void update(Book book) {
        try {
            db.update(book);
        } catch (Exception e) {
        }

    }

    public BkKey getId() {
        return id;
    }

    public void setId(BkKey id) {
        this.id = id;
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

    public Calendar getPdate() {
        return pdate;
    }

    public void setPdate(Calendar pdate) {
        this.pdate = pdate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
