/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.beans;

import java.util.Random;

/**
 *
 * @author A-pZ
 */
public class ExtendDice implements IDice {

    public int nextValue() {
        Random rnd = new Random(System.currentTimeMillis());
        
        int retValue = rnd.nextInt(6) +15;
        
        return retValue;
    }

    public String getMessage() {
        return "ExtendDice";
    } 
}
