package com.zsh.initOrder;

import org.junit.Test;

/**
 * Created by zsh7040 on 2018-1-17.
 */
public class ExtendTest {


    /**
     * 结论：
     *  1 父类static先按照定义顺序执行  -包含static字段和static{}块中的代码
     *  2 子类static先按照定义顺序执行  -包含static字段和static块中的代码
     *  3 父类实例初始化按照定义顺序执行  -包含字段初始化和{}块中的代码
     *  4 父类构造方法
     *  5 子类实例初始化按照定义顺序执行  -包含字段初始化和{}块中的代码
     *  6 子类构造方法
     */
    @Test
    public void initOrderTest(){
        Child child = new Child();
    }

    @Test
    public void superTest(){
        Child child = new Child();
        child.method();
    }

}
