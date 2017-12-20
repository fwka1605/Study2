package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MeiboBean {

    private Integer number;
    private String name;

    public String next() {
        System.out.println("★number=" + this.number + "/ name=" + this.name);
        return "output.xhtml"; // 次に表示するウェブページ
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
