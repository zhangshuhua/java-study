package com.zsh.reflection.staticProxy;

/**
 * Created by zsh7040 on 2017-11-7.
 */
public class NormalObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("NormalObject-doSomething");
    }

    @Override
    public void doSomethingElse() {
        System.out.println("NormalObject-doSomethingElse");
    }
}
