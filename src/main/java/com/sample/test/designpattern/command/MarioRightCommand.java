package com.sample.test.designpattern.command;

public class MarioRightCommand implements Command {

    private MarioCharacterReceiver marioCharacterReceiver;
    public MarioRightCommand(MarioCharacterReceiver marioCharacterReceiver) {
        this.marioCharacterReceiver = marioCharacterReceiver;
    }

    @Override
    public void execute() {
        marioCharacterReceiver.moveRight();
    }
}
