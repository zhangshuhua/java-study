package com.zsh.thread;

/**
 * Created by zsh7040 on 2017-12-8.
 * volatile适用于多处理器可见性
 * a=1,b=2;和a=3,b=3;都是会出现很多，不考虑
 * 加入volatile 出现了a=3,b=2;  不出现a=1,b=3; //经验证是没有重排序导致不出现b=3;a=1，与多线程没有关系
 * 不加volatile 出现了a=3,b=2;（较多）和a=1,b=3;（较少）
 * 重排序可以导致先将值得引用赋值，后执行构造函数的代码
 */
public class VolatileTest{
    int a ;
    int b ;
    int c ;

    public VolatileTest(){
        a = 1;
        b = 2;
        c = 3;
    }

    public void change(){
        a = 4;
        b = 5;
        c = 6;
    }

    public void print(){
        System.out.print("a="+a+",b="+b+",c="+c);
        System.out.println("a="+a+",b="+b+",c="+c+"------------");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        Thread $1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    test.a = 1;
                    test.b = 2;
                    test.c = 3;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    test.change();
                }

            }
        });

        Thread $2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }
        });


        while (true){
            $1.start();
            $2.start();
        }
    }
}