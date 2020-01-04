package com.sample.test.designpattern.command;

public class Main {

    public static void main(String[] args) {
        MarioCharacterReceiver mario = new MarioCharacterReceiver();
        mario.setName("Mario");

        MarioUpCommand marioUpCommand = new MarioUpCommand(mario);

        MarioDownCommand marioDownCommand = new MarioDownCommand(mario);
        MarioLeftCommand marioLeftCommand = new MarioLeftCommand(mario);

        MarioRightCommand marioRightCommand = new MarioRightCommand(mario);

        GameBoy gameBoy = new GameBoy(marioUpCommand,marioDownCommand,marioLeftCommand,marioRightCommand);
        gameBoy.arrowDown();
        gameBoy.arrowleft();
        gameBoy.arrowRight();
        gameBoy.arrowUp();
    }
}
