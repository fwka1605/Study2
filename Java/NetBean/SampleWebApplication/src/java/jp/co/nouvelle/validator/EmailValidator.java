/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * 電子メールアドレス用検証クラス。Faceletsから参照する名称としてsample.emailValidatorを設定。
 * 拡張Validatorクラスの利用方法は、
 * (1)FacesValidatorアノテーションにて名称を定義
 * (2)javax.faces.validator.Validatorを継承
 * (3)validateメソッドにてチェック内容を実装
 */
@FacesValidator("sample.emailValidator")
public class EmailValidator implements Validator {
    
    /** メールアドレスのフォーマットをチェックする正規表現。 */
    private static final String patternString = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    /** 正規表現エンジンクラス */
    private Pattern pattern;
    
    /** 正規表現で指定されたパターンに対して文字列をマッチングするためのクラス */
    private Matcher matcher;
 
    public EmailValidator(){
        // あらかじめ正規表現エンジンのインスタンスを作成。
        pattern = Pattern.compile(patternString);
    }
    
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = (String)value;
        if ( email == null || "".equals(email)) {
            throw new ValidatorException(new FacesMessage("メールアドレスは必須入力です"));
        }
        
        // 正規表現によるチェック。その結果はmatcherインスタンスに格納される
        matcher = pattern.matcher(email);
	
        // もし正規表現であわらされたパターンに合致しない場合は検証エラーとする。
        if ( !matcher.matches() ){
            throw new ValidatorException(new FacesMessage("メールアドレスのフォーマットが正しくありません"));
        }
    }
}
