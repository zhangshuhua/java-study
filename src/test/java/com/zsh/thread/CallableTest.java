package com.zsh.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zsh7040 on 2018-4-17.
 */
public class CallableTest {

    @Test
    public void testFori(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
        }
        long before = System.currentTimeMillis();
        for (int i = 0; i < futures.size(); i++) {
            try {
                System.out.println(futures.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long after = System.currentTimeMillis();
        System.out.println(after-before);
    }

    @Test
    public void testLambda(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
        }
        long before = System.currentTimeMillis();
        futures.stream().forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        long after = System.currentTimeMillis();
        System.out.println(after-before);
    }

    @Test
    public void testFor(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
        }
        long before = System.currentTimeMillis();
        for (Future<String> future:futures){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long after = System.currentTimeMillis();
        System.out.println(after-before);
    }

}
