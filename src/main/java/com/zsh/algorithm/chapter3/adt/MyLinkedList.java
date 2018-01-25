package com.zsh.algorithm.chapter3.adt;

/**
 * Created by zsh7040 on 2018-1-24.
 */
public class MyLinkedList<T> {

    private class Node<T>{
        Node privious;
        Node next;
        T data;

        public Node(T data){
            this.data = data;
        }
    }

    Node<T> head;
    Node<T> tail;

    int size;

    public MyLinkedList(){
        clear();
    }

    private Node<T> getNode(int index){
        Node<T> node;
        if(index<0){
            throw new IndexOutOfBoundsException("下标小于0");
        }

        if(index<size/2){
            // int i = 0;
            node = head.next;
            // while (i<index){
            //     node = node.next;
            //     i++;
            // }
            for (int i = 0; i < index ; i++) {
                node = node.next;
            }
        }else {
            int inverseIndex = size-index;
            // int i =0;
            node = tail;
            // while (i<inverseIndex){
            //     node = node.privious;
            //     i++;
            // }
            for (int i = 0; i <inverseIndex ; i++) {
                node = node.privious;
            }
        }
        return node;

    }

    public T get(int index){
        return getNode(index).data;
    }

    public T set(int index,T value){
        Node<T> node = getNode(index);

        Node<T> newNode = new Node<>(value);

        newNode.next = node.next;
        newNode.privious = node.privious;

        node.privious.next = newNode;
        node.next.privious = newNode;

        T result = node.data;
        node = null;
        return result;




    }

    public boolean add(T value){
        Node<T> newNode = new Node<>(value);
        // tail.next = newNode;
        // newNode.privious = tail;
        // tail = newNode;
        newNode.next = tail;
        newNode.privious = tail.privious;

        tail.privious.next = newNode;
        tail.privious = newNode;

        size++;
        return true;
    }

    public T remove(int index){
        Node<T> node = getNode(index);

        return romove(node);

    }

    private T romove(Node<T> node){

        node.privious.next = node.next;
        node.next.privious = node.privious;
        size--;
        return node.data;

    }

    public boolean isEmpty(){
        return head.next==tail;
    }

    public int size(){
        return size;
    }

    public void clear(){
        size = 0;
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next=tail;
        tail.privious = head;
    }

}
