package com.zsh.algorithm.chapter4;

/**
 * Created by zsh7040 on 2018-1-29.
 * 二叉查找树
 */
public class BinarySearchTree {

    private class BinaryNode {

        private Integer element;

        private BinaryNode left;

        private BinaryNode right;

        public BinaryNode(Integer element) {
            this(element, null, null);
        }

        public BinaryNode(Integer element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode root;

    public Integer getRoot() {
        return root.element;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 这个太难，自己实现不了
     * todo 需要自己实现，本章结束后
     * @param element
     */
    public void remove(Integer element) {

    }

    public boolean contain(Integer element) {
        return contain(element, root);
    }

    public Integer findMin() {
        return findMin(root);
    }

    public Integer findMax() {
        return findMax(root);
    }

    private boolean contain(Integer element, BinaryNode node) {
        if (node == null) {
            return false;
        }
        if (element < node.element) {
            return contain(element, node.left);
        } else if (element > node.element) {
            return contain(element, node.right);
        } else {
            return true;
        }
    }

    /**
     * 相当于不能通过额外效应来达到目的，只能通过返回值
     * @param element
     */
    public void insert(Integer element) {
        this.root = insert(element, root);
    }

    private BinaryNode insert(Integer element, BinaryNode node) {

        if (node == null) {
            /**
             * 在这里遇到一个大麻烦，就是关于方法调用，传的是引用的时候，你可以直接修改值，但是不是调用new，
             * 调用了new之后，就是一个全新的内存空间，之前的引用就已经断了
             */
            BinaryNode n = new BinaryNode(element);
            return n;
        }
        if (element < node.element) {
            node.left = insert(element, node.left);
            // return node.left;//错误做法
        } else if (element > node.element) {
            node.right = insert(element, node.right);
            // return node.right;//错误做法
        } else {
            throw new RuntimeException("已经存在相同元素");
        }
        //这里进来node,返回也是node并且是必须的，就是因为83行中新new了一个对象
        return node;//正确做法
    }

    private Integer findMin(BinaryNode node) {
        if (node == null) {
            throw new NullPointerException();
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.element;
    }

    private Integer findMax(BinaryNode node) {
        if (node == null) {
            throw new NullPointerException();
        }
        while (node.right != null) {
            node = node.right;
        }
        return node.element;
    }

}
