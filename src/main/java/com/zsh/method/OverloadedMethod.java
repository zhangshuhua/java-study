package com.zsh.method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zsh7040 on 2018-4-3.
 */
public class OverloadedMethod {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i <50 ; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i <3 ; i++) {
            set.remove(i);
            list.remove((Integer) i);
        }
        System.out.println(set);
        System.out.println(list);
    }
}
