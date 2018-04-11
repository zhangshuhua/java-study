package com.zsh.patterns.command;

/**
 * Created by zsh7040 on 2018-3-19.
 */
public class SimpleRemoteControl {

    Command slot;

    public SimpleRemoteControl() {
    }

    public SimpleRemoteControl(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed(){
        slot.execute();
    }

    public void setCommand(Command slot) {
        this.slot = slot;
    }
}
