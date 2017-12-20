package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bb {

    private String name;
    private Double weight;
    private Double height;
    private String msg;

    public String next() {
        return "output.xhtml";
    }

    public double getBmi() {
        return weight / (Math.pow(height, 2));
    }

    public String getBmiMessage() {
        double bmi = getBmi();
        if (bmi < 20) {
            return "やせ気味";
        } else if (bmi < 24) {
            return "普通";
        } else if (bmi < 26.5) {
            return "太り気味";
        } else {
            return "太り過ぎ";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
