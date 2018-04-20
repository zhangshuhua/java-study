package com.zsh.thread;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.Callable;

/**
 * Created by zsh7040 on 2018-4-17.
 */
public class TaskWithResult  implements Callable<String> {

    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }



    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        return "result-"+id;
    }
}
