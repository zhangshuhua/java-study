package com.zsh.algorithm.chapter3.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by zsh7040 on 2018-1-24.
 */
public class MyArrayList<T> {

    private T[] myArray;

    private int size;

    private final int DEFAULT_CAPICITY = 16;

    private final Object[] EMPTY_ARRAY = {};

    private int capicity ;

    @SuppressWarnings("unchecked")
    public MyArrayList(){
        //这个是我没有想到的，通过T来cast object数组
        myArray = (T[]) new Object[DEFAULT_CAPICITY];
        size = 0;
        capicity = DEFAULT_CAPICITY;
    }

    @SuppressWarnings("unchecked")
    private void enLargeArray(){
        this.capicity*=2;
        T[] newArray = (T[]) new Object[capicity];
        for (int i = 0; i <myArray.length ; i++) {
            newArray[i] = myArray[i];
        }
        this.myArray = newArray;
    }

    public T get(int index){
        //忘记考虑index>=0
        if(index<=size-1&&index>=0){
            return myArray[index];
        }else {
            throw new IndexOutOfBoundsException("越界");
        }
    }

    public T set(int index,T value){
        if(index<=size-1&&index>=0){
            T old = myArray[index];
            myArray[index] = value;
            return old;
        }else {
            throw new IndexOutOfBoundsException("越界");
        }
    }

    public boolean add(T value){
        if(size<capicity){
            myArray[size] = value;
            size++;
            return true;
        }else {
            enLargeArray();
            return add(value);
        }
    }

    public T remove(int index){
        if(index<=size-1&&index>=0){
            T old = get(index);

            for (int i = index; i <size ; i++) {
                myArray[i] = myArray[i+1];
            }
            size--;
            return old;
        }else {
            throw new IndexOutOfBoundsException("越界");
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void clear(){
        size = 0;
        capicity = DEFAULT_CAPICITY;
        myArray = (T[])EMPTY_ARRAY;
    }

    public Iterator<T> iterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{

        private int index;

        @Override
        public boolean hasNext() {
            return index<size;
        }

        /**
         * 没有想到index++
         * @return
         */
        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("没有元素");
            }
            return myArray[index++];//++的正宗用法
        }

        /**
         * 这个没有想到
         */
        @Override
        public void remove(){
            MyArrayList.this.remove(--index);
        }
    }
}
