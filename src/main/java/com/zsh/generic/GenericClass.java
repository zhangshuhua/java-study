package com.zsh.generic;

/**
 * Created by zsh7040 on 2018-6-5.
 */
public class GenericClass<T> {

    private T t;

    public GenericClass(T t){
        this.t = t;
    }

    public void set(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }


}
