package com.zsh.reflection.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by zsh7040 on 2017-11-7.
 * 代理模式的使用主要目的就是将额外的操作分离出来，如日志，可以很容易的实现热插拔
 *
 * 此例为静态代理,即在编译阶段就加入代理模式,适用于远程对象访问之类
 *
 * Spring常见的是动态代理,主要实现AOP编程
 */
public class ProxyTest{
    /**
     * 演示热插拔，很简单，只要传入不同对象即可
     * @param args
     */
    public static void main(String[] args) {

        NormalObject no = new NormalObject();
        //本来类
        ProxyTest.test(no);
        //动态代理
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),new Class[]{Interface.class},
                new DynamicPorxyHandler(no));
        ProxyTest.test(proxy);


    }

    /**
     * 参数是一个接口,由于代理类和本类都是实现同一个接口,因此可以直接传入代理类
     * todo 如果加了AOP注解，不能在方法内部调用加了AOP注解的类，不然不能够动态代理，因为在方法内部的this关键字是被代理类本身.
     * @param anInterface
     */
    private static void test(Interface anInterface){
        anInterface.doSomething();
        anInterface.doSomethingElse();
    }
}
