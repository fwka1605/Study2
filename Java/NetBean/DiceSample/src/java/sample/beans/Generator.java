/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;


/**
 *
 * @author A-pZ
 */
@Named(value="generator")
@SessionScoped
public class Generator implements Serializable {

    /** Creates a new instance of Generator */
    public Generator() {
        int i=0;
    }
    
    private int diceType;
    
    /**
     * サイコロの種類を指定する
     * @param value サイコロの種類を指定
     */
    public void changeDice(int value) {
        diceType = value;
    }
    
    @Dice
    @Produces
    public IDice getDice() {
        IDice dice = null;
        // diceTypeの値に応じて生成するインスタンスを切りかえる
        switch (diceType) {
            case 0:
                // SimpleDiceを生成
                dice = new SimpleDice();
                break;
            case 1:
                // ExtendDiceを生成
                dice = new ExtendDice();
                break;
            default:
        }
        return dice;
    }
}
