package com.zsh.InitOrder;

/**
 * Created by zsh7040 on 2017-12-28.
 */
public class OrderTest {

    /**
     * 结论：
     *  1 父类static先按照定义顺序执行  -包含static字段和static{}块中的代码
     *  2 子类static先按照定义顺序执行  -包含static字段和static块中的代码
     *  3 父类实例初始化按照定义顺序执行  -包含字段初始化和{}块中的代码
     *  4 父类构造方法
     *  5 子类实例初始化按照定义顺序执行  -包含字段初始化和{}块中的代码
     *  6 子类构造方法
     */
    public static void main(String[] args) {
        Child child = new Child();

    }
}
