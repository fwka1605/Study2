/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.beans;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author NVLCLT13
 */
@Named(value = "generator")
@ApplicationScoped
public class Generator {

    private java.util.Random random = new java.util.Random(
            System.currentTimeMillis());

    private int maxNumber = 100;

    java.util.Random getRandom() {
        return random;
    }

    /**
    * 次の乱数を取得する。
    * @return
    */
    @Produces
    @Random
    int next() {
        return getRandom().nextInt(maxNumber);
    }

    @Produces
    @MaxNumber
    int getMaxNumber() {
        return maxNumber;
    }
}
