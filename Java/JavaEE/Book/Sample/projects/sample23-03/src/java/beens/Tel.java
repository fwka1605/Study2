package beens;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Tel implements Serializable {

    private String telephone;
    private String cellular;

    public Tel() {
    }

    public Tel(String telephone, String cellular) {
        this.telephone = telephone;
        this.cellular = cellular;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellular() {
        return cellular;
    }

    public void setCellular(String cellular) {
        this.cellular = cellular;
    }

}
