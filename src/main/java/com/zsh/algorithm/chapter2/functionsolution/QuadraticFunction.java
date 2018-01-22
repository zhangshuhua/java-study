package com.zsh.algorithm.chapter2.functionsolution;

/**
 * Created by zsh7040 on 2018-1-22.
 */
public class QuadraticFunction implements Function {
    @Override
    public double f(double x) {
        return x*x-2*x-1;
    }
}
