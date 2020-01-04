package com.sample.question.designpattern.strategy.example1;

public class Main {

    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard();
        System.out.println("ballon Tap Score :");

        scoreboard.algoBase = new Ballon();
        scoreboard.showScore(10,5);

        System.out.println("Clown tap Score:");
        scoreboard.algoBase = new Clown();

        scoreboard.showScore(10,5);
        System.out.println("square Ballon score");
        scoreboard.algoBase = new Square();
        scoreboard.showScore(10,5);
    }
}
