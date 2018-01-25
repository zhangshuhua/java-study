package com.zsh.algorithm.chapter3.adt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by zsh7040 on 2018-1-25.
 * 简单计算器，通过读入String，得到结果
 */
public class SimilarCalculate {

    private Stack<Character> convertStack;

    private Stack<Character> parseStack;

    public List<Character> suffixList;

    private static Character[] operations = {'+','-','\u0000','\u0000','*','/','%'};

    private static final char NULL_CHAR = '\u0000';

    private static final char LEFT_PARENTHESES = '(';
    private static final char RIGHT_PARENTHESES = ')';

    public SimilarCalculate(){
        convertStack = new Stack<>();
        parseStack = new Stack<>();
        suffixList = new ArrayList<>();
    }


    public void convertSuffixPattern(String expression){

        char[] expressionChars = expression.toCharArray();
        for (int i = 0; i <expressionChars.length ; i++) {
            char current = expressionChars[i];
            if(current==LEFT_PARENTHESES){
                //小括号左半部分直接入栈
                convertStack.push(current);
            }else if(current==RIGHT_PARENTHESES){
                //小括号右部分，则将括号之前的全部出栈，入队列
                while (convertStack.peek()!=LEFT_PARENTHESES){
                    suffixList.add(convertStack.pop());
                }
                //'('本身弹出，不入队列
                convertStack.pop();
            }else if(isOperation(current)){
                //栈中的操作符大于和等于都有pop
                try {
                    char top = convertStack.peek();

                    while (top!='('&&isPriorityOrEqual(top,current)){
                        convertStack.pop();
                        suffixList.add(top);
                        top = convertStack.peek();
                    }

                    convertStack.push(current);
                } catch (EmptyStackException e) {
                    //空栈则直接入栈
                    convertStack.push(current);
                }
            }else {
                //非操作符直接入队列
                suffixList.add(current);
            }
        }
        //结束后把栈中剩余的都加入到列表中
        while (!convertStack.empty()){
            suffixList.add(convertStack.pop());
        }
    }

    private boolean isOperation(char c){
        return new HashSet<Character>(Arrays.asList(operations)).contains(c);
    }

    private boolean isPriorityOrEqual(char a,char b){
        return getPriorityIndex(a)-getPriorityIndex(b)>=-2;
    }

    private int getPriorityIndex(char c){
        for (int i = 0; i <operations.length ; i++) {
            if(c==operations[i]){
                return i;
            }
        }
        throw new NoSuchElementException("没有该元素");
    }
}
