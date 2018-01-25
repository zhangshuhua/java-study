package com.zsh.algorithm.chapter3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zsh7040 on 2018-1-23.
 * 不同remove方式的效率,删除一个list中的偶数
 */
public class RemoveList {


    /**
     * 错误做法，每次都i++是不对的，只有不移除的时候才i++,移除的时候，坐标本来就会缩减
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

    public static List<Integer> removeEvensVar11(List<Integer> list) {

        int i = 0;
        while (i<list.size()){
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }else {
                i++;
            }
        }
        return list;
    }


    /**
     * 这个感觉会同理，就是不知道会不会报错的呢
     * @param list
     * @return
     */
    public static List<Integer> removeEvensVar2(List<Integer> list) {

        //这里必须是Integer类型，如果是int类型，会被认为是下标的删除
        for (Integer item : list) {
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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <80000 ; i++) {
            list.add(i);
        }
        removeEvensVar2(list);
    }

}
