/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.beans;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author NVLCLT13
 */

//アノテーション適用させる対象。型、メソッド、パラメータ、フィールド。
@Target({METHOD, FIELD, PARAMETER, TYPE})

//アノテーション対象オブジェクトの寿命。
@Retention(RUNTIME)

// アノテーション定義の利用を宣言。
@Qualifier
public @interface Random {
}
