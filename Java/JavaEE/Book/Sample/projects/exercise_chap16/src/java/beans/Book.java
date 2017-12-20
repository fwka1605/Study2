package beans;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// Bookエンティティ
@Entity
/**
 * **************************************************
 * 15章の練習問題で使ったBookエンティティと同じ名前なので、 データベーステーブルの名前が衝突しないように、@Table
 * アノテーションを使って名前を変えます。
****************************************************
 */
@Table(name = "BOOKS")
public class Book implements Serializable {
    /*
     * 指示にしたがってアノテーションを付けなさい
     * アノテーションを付けるとエラーは消えます
     */
    @EmbeddedId
    private BkKey id;			// 主キー
    private String title;		// 題名
    private String author;		// 著者名
    @Temporal(TemporalType.DATE)
    private Calendar pdate;		// 作成年月日
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String text;		// 本文

    // コンストラクタ
    public Book() {
    }

    public Book(BkKey id, String title, String author, Calendar pdate, String text) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pdate = pdate;
        this.text = text;
    }

    // セッターとゲッター
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Calendar getPdate() {
        return pdate;
    }

    public void setPdate(Calendar pdate) {
        this.pdate = pdate;
    }
}
