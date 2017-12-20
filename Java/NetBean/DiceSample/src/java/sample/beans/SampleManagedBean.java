/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.beans;

import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author A-pZ
 */
@Named(value = "sample")
public class SampleManagedBean {

    public SampleManagedBean() {
    }
    
    @Inject
    @Dice
    private IDice dice;
    
    public int nextValue() {
        return dice.nextValue();
    }
    
    public String getMessage() {
        return dice.getMessage();
    }
}
