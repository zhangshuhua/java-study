package com.zsh.patterns.command;

import org.junit.Test;

/**
 * Created by zsh7040 on 2018-3-19.
 */
public class CommandPatternTest {

    @Test
    public void testLightOn() throws Exception {

        Command lightOn = new LightOnCommand(new Light());

        SimpleRemoteControl src = new SimpleRemoteControl(lightOn);

        src.buttonWasPressed();

        Command lightOff = new LightOffCommand(new Light());
        src.setCommand(lightOff);
        src.buttonWasPressed();

    }


    @Test
    public void testLightOff() throws Exception {

        Command lightOff = new LightOffCommand(new Light());

        SimpleRemoteControl src = new SimpleRemoteControl(lightOff);

        src.buttonWasPressed();

    }
}
