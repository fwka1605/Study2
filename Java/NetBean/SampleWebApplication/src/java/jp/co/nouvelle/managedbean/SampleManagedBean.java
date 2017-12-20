/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle.managedbean;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named(value="user")
@RequestScoped
public class SampleManagedBean implements Serializable {

    /** Creates a new instance of SampleJSFBean */
    public SampleManagedBean() {

    }

    String username;
    String password;
    String email;
    String age;
    
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    
    
    String result;
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResult() {
        
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    public void action() {
        if ( password != null ) {
            result = "ようこそ！" + username + "さん！"
                + "パスワードの長さは" + password.length() + "文字です。";
        }
    }

    /**
     * usernameの入力チェックを行う。呼び出しはFaceletsから行われる。
     * @param fc FacesContext
     * @param uic UIComponent
     * @param value 入力値(ここではusernameの値)
     */
    public void validationUsername(FacesContext fc, UIComponent uic, Object value) {
        String input = (String)value;
        
        if ( input == null || input.equals("") ) {
            throw new ValidatorException(new FacesMessage("ユーザIDは必須入力です"));
        }
        if ( input.length() >= 16 ) {
            throw new ValidatorException(new FacesMessage("ユーザIDは15文字以内です"));
        }
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}

