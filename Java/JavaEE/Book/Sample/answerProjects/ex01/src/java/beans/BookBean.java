package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class BookBean {

    private String title;
    private String author;
    private Integer price;

    public String next() {
        System.out.println("★書籍名=" + this.title + "/ 著者名=" + this.author + "/ 価格=" + this.price);
        return "output.xhtml"; // 次に表示するウェブページ
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
