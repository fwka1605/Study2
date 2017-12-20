/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author NVLCLT13
 */
@Named(value = "number")
@SessionScoped
public class NumberGame implements Serializable {

    // 定数定義。メッセージ用定義をしている。
    public static final String MESSAGE_CORRECT = "正解です！";
    public static final String MESSAGE_WRONG = "違います";
    /** 正解となる番号 */
    private int number;
    /** 予想で入力した値 */
    private int guess;
    /** 入力できる最小値 */
    private int smallest;
    /** 入力できる最大値 */
    private int biggest;
    /** 結果メッセージ */
    private String message;
    /** 残り解答回数 */
    private int remainingGuesses;


    /** 初期最大値。限定子MaxNumberによってDIされる。 */
    @MaxNumber
    @Inject
    private int maxNumber;
    
    /** 乱数値。限定子RandomによってDIされる。 */
    @Random
    @Inject
    Instance<Integer> randomNumber;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getSmallest() {
        return smallest;
    }

    public void setSmallest(int smallest) {
        this.smallest = smallest;
    }

    public int getBiggest() {
        return biggest;
    }

    public void setBiggest(int biggest) {
        this.biggest = biggest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    public void setRemainingGuesses(int remainingGuesses) {
        this.remainingGuesses = remainingGuesses;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Instance<Integer> getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Instance<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }
    
    
    
    /**
     * 予想された入力値が当たっているかをチェックする。
     * @throws InterruptedException
     */
    public void check() throws InterruptedException {
        if (guess > number) {
            // 予想値が正解より大きかったときは、
            // 次回入力可能な最大値=予想値-1とする。
            biggest = guess - 1;
        }
        if (guess < number) {
            // 予想値が正解より小さかったときは、
            // 次回入力可能な最小値=予想値+1とする。
            smallest = guess + 1;
        }

        if (guess == number) {
            // 予想があたったので、正解メッセージを返す
            message = MESSAGE_CORRECT;
        } else {
            // 予想が間違っていたので残り予想回数を-1して、
            // 間違いのメッセージを返す。
            remainingGuesses--;
            message = MESSAGE_WRONG;
        }
        
        // 初期化処理。
        if (NumberGame.MESSAGE_CORRECT.equals(message)) {
            // 正解したのでリセット
            reset();
        } else if (getRemainingGuesses() == 0) {
            // 回答回数が0になった場合の処理
            message = "残り回数がなくなりました。正解は" + getNumber() + "でした。";
            reset();
        }
    }

    /**
     * リセット時の処理。PostConstructで、
     * ManagedBeanが設定されたスコープで、
     * 初回リクエストを受けて起動する際の初期化処理として動く。
     */
    @PostConstruct
    public void reset() {
        this.smallest = 0;
        this.guess = 0;
        this.remainingGuesses = 10;
        this.biggest = maxNumber;
        this.number = randomNumber.get();
    }
    
    
    /**
     * Creates a new instance of NumberGame
     */
    public NumberGame() {
    }
    
}
