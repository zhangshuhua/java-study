package com.zsh.algorithm.chapter2.functionsolution;

/**
 * Created by zsh7040 on 2018-1-22.
 * 题目2.18，求函数的解
 */
public class FunctionSolution {

    double solute(Function function,double low,double high) throws NoSolutionExction {
        while (low<=high){
            double center = (high+low)/2;

            if(function.f(low)*function.f(high)<0){
                if(function.f(low)*function.f(center)<0){
                    //一开始这里没有写return,导致无限循环，
                    //因为新函数的解等同于原问题的解所以是需要return
                    return solute(function,low,center);
                }else if(function.f(center)*function.f(high)<0){
                    //一开始这里没有写return,导致无限循环，
                    //因为新函数的解等同于原问题的解所以是需要return
                    return solute(function,center,high);
                }else {
                    return center;
                }
            }else if(function.f(low)*function.f(high)==0) {
                if(function.f(low)==0){
                    return low;
                }else {
                    return high;
                }
            }else {
                throw new NoSolutionExction("该函数在"+low+"和"+high+"范围内不一定有解");
            }
        }
        return low;
    }
}
