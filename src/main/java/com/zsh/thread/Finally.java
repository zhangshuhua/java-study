package com.zsh.thread;

/**
 * Created by zsh7040 on 2017-12-11.
 * 直接关闭jvm，finally不会执行
 * finally之前有return照样执行
 */
public class Finally {
    public static void main(String[] args) {
        try {
           Finally f = new Finally();
           f.test();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("结束");
        }
    }

    public int test(){
        try {
            int a =1;
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("test结束");
        }
        return 0;
    }
}
