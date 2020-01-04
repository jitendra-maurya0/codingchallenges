package com.sample.test.designpattern.command;

public class MarioDownCommand implements Command {

    private MarioCharacterReceiver marioCharacterReceiver;
    public MarioDownCommand(MarioCharacterReceiver marioCharacterReceiver) {
        this.marioCharacterReceiver = marioCharacterReceiver;
    }

    @Override
    public void execute() {
        marioCharacterReceiver.moveDown();
    }
}
