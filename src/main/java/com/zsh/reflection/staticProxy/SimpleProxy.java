package com.zsh.reflection.staticProxy;

/**
 * Created by zsh7040 on 2017-11-7.
 * 代理模式的使用主要目的就是将额外的操作分离出来，如日志，可以很容易的实现热插拔
 */
public class SimpleProxy implements Interface{

    private Interface anInterface;

    public SimpleProxy(Interface anInterface){
        this.anInterface = anInterface;
    }

    @Override
    public void doSomething() {
        System.out.println("before doSomething");
        anInterface.doSomething();
    }

    @Override
    public void doSomethingElse() {
        System.out.println("before doSomethingElse");
        anInterface.doSomethingElse();
    }
}

/**
 * 此例为静态代理,即在编译阶段就加入代理模式,适用于远程对象访问之类
 *
 * Spring常见的是动态代理,主要实现AOP编程
 */
class ProxyTest{
    /**
     * 演示热插拔，很简单，只要传入不同对象即可
     * @param args
     */
    public static void main(String[] args) {
        //本来类
        ProxyTest.test(new NormalObject());
        //代理类
        ProxyTest.test(new SimpleProxy(new NormalObject()));

    }

    /**
     * 参数是一个接口,由于代理类和本类都是实现同一个接口,因此可以直接传入代理类
     * @param anInterface
     */
    private static void test(Interface anInterface){
        anInterface.doSomething();
        anInterface.doSomethingElse();
    }
}
