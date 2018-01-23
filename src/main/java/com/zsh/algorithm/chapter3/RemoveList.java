package com.zsh.algorithm.chapter3;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zsh7040 on 2018-1-23.
 * 不同remove方式的效率,删除一个list中的偶数
 */
public class RemoveList {


    /**
     * 错误做法
     * @param list
     * @return
     */
    public static List<Integer> removeEvensVar1(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        return list;
    }


    public static List<Integer> removeEvensVar2(List<Integer> list) {

        for (int item : list) {
            if (item % 2 == 0) {
                list.remove(item);
            }
        }
        return list;
    }


    public static List<Integer> removeEvensVar3(List<Integer> list) {

        Iterator<Integer> integerIterator = list.iterator();

        while (integerIterator.hasNext()) {
            if (integerIterator.next() % 2 == 0) {
                integerIterator.remove();
            }
        }
        return list;

    }

    public static List<Integer> removeEvensVar4(List<Integer> list) {

        list.removeIf(integer -> integer % 2 == 0);
        return list;

    }

}
