package com.sample.question.designpattern.strategy.example1;

public class Ballon implements ScoreAlgoBase {


    @Override
    public int calculateScore(int taps, int multiplier) {
        return taps*multiplier-20;
    }
}
