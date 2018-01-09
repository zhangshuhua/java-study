package com.zsh.reflection.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zsh7040 on 2017-11-7.
 * 调用处理器，所有的调用都重定向到这个处理器上
 * 日常使用并不多，日常可以使用动态代理,但是spring等类库中使用很多
 */
public class DynamicPorxyHandler implements InvocationHandler{

    private Object proxied;

    public DynamicPorxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy的class"+proxy.getClass()+", 方法为"+method+", 参数为"+args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(""+arg);
            }
        }
        //这里遇到一个坑，一定proxied而不是proxy对象，不然就是死循环
        return method.invoke(proxied,args);
        //使用反射的确是可以去除包的访问限制，随意调用private的方法
    }
}
