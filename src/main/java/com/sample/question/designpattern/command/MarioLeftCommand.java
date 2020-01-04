package com.sample.question.designpattern.command;

public class MarioLeftCommand implements Command {
    private MarioCharacterReceiver marioCharacterReceiver;
    public MarioLeftCommand(MarioCharacterReceiver marioCharacterReceiver) {
     this.marioCharacterReceiver = marioCharacterReceiver;
    }

    @Override
    public void execute() {
        marioCharacterReceiver.moveLeft();
    }
}
