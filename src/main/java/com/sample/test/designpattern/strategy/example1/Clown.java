package com.sample.test.designpattern.strategy.example1;

public class Clown implements ScoreAlgoBase {

    @Override
    public int calculateScore(int taps, int multiplier) {
        return taps*multiplier-10;
    }
}
