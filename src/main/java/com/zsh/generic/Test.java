package com.zsh.generic;

import com.zsh.initOrder.Child;
import com.zsh.initOrder.Parent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zsh7040 on 2018-4-27.
 */
public class Test {

    public static void main(String[] args) {

        // 为了保证类型安全，泛型的list的意义是确定的一种类型的list，所以不能在加入其它东西
        List<? extends Parent> list = new LinkedList<Child>();

    }


}
