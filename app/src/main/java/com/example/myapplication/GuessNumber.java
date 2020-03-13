package com.example.myapplication;

import java.util.Random;

public class GuessNumber {
    private int currentNumber;
    private int maxNumber;
    public enum guessState{BIGGER,EQUAL,SMALLER};

    public GuessNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public guessState testNumber(int numberTotTest){
        guessState numberState;
        if(numberTotTest<currentNumber)
        {
            numberState=guessState.SMALLER;
        }
        else if (numberTotTest>currentNumber)
        {
            numberState=guessState.BIGGER;
        }
        else
        {
            numberState=guessState.EQUAL;
        }
        return numberState;
    }
    public void generateNewNumber(){
        currentNumber = new Random().nextInt(maxNumber+1);
    }


}


