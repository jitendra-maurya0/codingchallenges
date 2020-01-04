package com.sample.question.designpattern.strategy.example1;

public class Square implements ScoreAlgoBase {

    @Override
    public int calculateScore(int taps, int multiplier) {
        return taps*multiplier+40;
    }
}
