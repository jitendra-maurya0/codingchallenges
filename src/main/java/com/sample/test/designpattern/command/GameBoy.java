package com.sample.test.designpattern.command;

public class GameBoy {

    private Command upCommand;
    private Command downCommand;
    private Command leftCommand;
    private Command rightCommand;

    public GameBoy(Command upCommand, Command downCommand, Command leftCommand, Command rightCommand) {
        this.upCommand = upCommand;
        this.downCommand = downCommand;
        this.leftCommand = leftCommand;
        this.rightCommand = rightCommand;
    }

    public void arrowUp(){
        upCommand.execute();
    }

    public void arrowDown(){
        downCommand.execute();
    }

    public void arrowleft(){
        leftCommand.execute();
    }
    public void arrowRight(){
        rightCommand.execute();
    }
}
