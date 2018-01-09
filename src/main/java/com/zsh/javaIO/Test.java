package com.zsh.javaIO;

import java.io.InputStream;

/**
 * Created by zsh7040 on 2018-1-8.
 */
public class Test {
    public static void main(String[] args) {
        InputStream in = Test.class.getResourceAsStream("config.properties");
        System.out.println(in);
    }
}
