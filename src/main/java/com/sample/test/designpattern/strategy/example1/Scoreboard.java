package com.sample.test.designpattern.strategy.example1;

public class Scoreboard {

    public ScoreAlgoBase algoBase;

    public void showScore(int taps,int multiplier){

        System.out.println(algoBase.calculateScore(taps,multiplier));
    }
}
