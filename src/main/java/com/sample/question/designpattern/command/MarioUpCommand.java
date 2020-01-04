package com.sample.question.designpattern.command;

public class MarioUpCommand implements Command {

    private MarioCharacterReceiver marioCharacter;

    public MarioUpCommand(MarioCharacterReceiver marioCharacter){
        this.marioCharacter = marioCharacter;
    }

    @Override
    public void execute() {
       marioCharacter.moveUp();
    }
}
