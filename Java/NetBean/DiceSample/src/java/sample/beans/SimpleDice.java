/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.beans;

import java.util.Random;

//@Dice
public class SimpleDice implements IDice {
    
    @Override
    public int nextValue() {
        Random rnd = new Random(System.currentTimeMillis());
        
        int retValue = rnd.nextInt(6) +1;
        
        return retValue;
    }

    @Override
    public String getMessage() {
        return "SimpleDice";
    }
    
    
}
