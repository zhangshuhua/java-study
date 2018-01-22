package com.zsh.algorithm.chapter2.functionsolution;

import org.junit.Test;

/**
 * Created by zsh7040 on 2018-1-22.
 */
public class FunctionSolutionTests {

    @Test
    public void testLineFunction(){
        FunctionSolution fs = new FunctionSolution();
        Function lineFunction = new LineFunction();
        try {
            double result = fs.solute(lineFunction,-2,2);
            System.out.println(result);
        } catch (NoSolutionExction noSolutionExction) {
            noSolutionExction.printStackTrace();
        }
    }

    @Test
    public void testQuadraticFunction(){
        FunctionSolution fs = new FunctionSolution();
        Function quadraticFunction = new QuadraticFunction();
        try {
            double result = fs.solute(quadraticFunction,0,5);
            System.out.println(result);
            System.out.println(quadraticFunction.f(result));

        } catch (NoSolutionExction noSolutionExction) {
            noSolutionExction.printStackTrace();
        }
    }


    @Test(expected = NoSolutionExction.class)
    public void testNoSolutionException() throws NoSolutionExction {
        FunctionSolution fs = new FunctionSolution();
        Function quadraticFunction = new QuadraticFunction();
        double result = fs.solute(quadraticFunction,-5,5);
    }
}
