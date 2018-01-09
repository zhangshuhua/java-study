package com.zsh.algorithm.chapter1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by zsh7040 on 2018-1-9.
 * 字谜类是一个方阵
 * 二维数组对我来说始终还是太难了，希望等看完这本书，我可以有想法
 */
public class Logogriph {

    //方阵的长度和宽度
    int length;

    char[][] chars;

    final String[] dictionary = {"this","two","fat","that"};


    public Logogriph(int length){
        this.length = length;
        chars = new char[length][length];
    }

    public Logogriph(char[][] chars){
        this.chars = chars;
        this.length = (int)Math.sqrt(chars.length);
    }

    public boolean contain(String word){
        return new HashSet<>(Arrays.asList(dictionary)).contains(word);
    }

}
