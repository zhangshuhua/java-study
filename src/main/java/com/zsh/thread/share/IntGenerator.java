package com.zsh.thread.share;

/**
 * Created by zsh7040 on 2018-4-19.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel(){
        canceled = true;
    }

    public boolean isCanceled(){
        return canceled;
    }
}
