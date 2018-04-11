package com.zsh.patterns.command;

/**
 * Created by zsh7040 on 2018-3-19.
 * 这里的命令是LightOnCommand而不是LightCommand
 * 这是我没有想到的
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
