package com.zsh.reflection.ClassLoadOrdel;

/**
 * Created by zsh7040 on 2017-11-6.
 * 加载顺序，只有加载了非静态常量的时候才会触发初始化
 * 只是静态常量的引用不会触发static{}；
 * 当调用任意static非常量的时候，包括静态方法和构造方法（构造方法是隐式的静态方法）在负责初始化
 * 初始化的意义并不是调用构造方法，而是static{}运行
 */
public class ClassOrderTest {
    public static void main(String[] args) {
        System.out.println("main方法{}");
        double newPi = ClassInitOrder.pi;
        System.out.println(newPi);
        ClassInitOrder.setR(5);
        ClassInitOrder cio = new ClassInitOrder();
        double area = cio.Squart();
    }
}
