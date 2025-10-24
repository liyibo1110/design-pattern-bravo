package com.github.liyibo1110.pattern.iterator.v1.container;

import com.github.liyibo1110.pattern.iterator.v1.iterator.Iterable;
import com.github.liyibo1110.pattern.iterator.v1.iterator.Iterator;

import java.util.Stack;

/**
 * 版本1：以内部类自行实现了迭代器的功能（优点是可以直接访问外部类的字段和方法）
 * @author liyibo
 * @date 2025-10-24 14:03
 */
public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(E data) {
        this.root = this.insertRec(this.root, data);
    }

    private Node insertRec(Node root, E data) {
        if(root == null) {  // 递归的结束条件
            root = new Node(data);
            return root;
        }

        if(data.compareTo(root.data) < 0)   // 数据如果比当前节点小，往左继续比较插入
            root.left = this.insertRec(root.left, data);
        else if(data.compareTo(root.data) > 0)  // 数据如果比当前节点大，往右继续比较插入
            root.right = this.insertRec(root.right, data);
        return root;
    }

    /**
     * 查询给定的元素是否存在
     * @param data
     * @return
     */
    public boolean search(E data) {
        return this.searchRec(this.root, data);
    }

    private boolean searchRec(Node root, E data) {
        if(root == null)
            return false;
        if(data.compareTo(root.data) == 0)  // 找到了
            return true;
        if(data.compareTo(root.data) < 0)   // 数据比当前节点小，往左继续找
            return this.searchRec(root.left, data);
        else // 数据比当前节点大，往右继续找
            return this.searchRec(root.right, data);
    }

    private class Node {
        E data;
        Node left;
        Node right;

        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /** 以下是迭代器相关实现 */

    @Override
    public Iterator<E> iterator() {
        return new InOrderIterator(root);
    }

    private class InOrderIterator implements Iterator<E> {
        private final Stack<Node> stack;

        public InOrderIterator(Node root) {
            this.stack = new Stack<>();
            this.pushLeft(root);    // 保证stack顶部是最小的值
        }

        @Override
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        @Override
        public E next() {
            Node current = this.stack.pop();
            this.pushLeft(current.right);
            return current.data;
        }

        /**
         * 将指定node本身，和其左右的left节点全部压入stack中（使得顶部到底部的值是由小到大排列）
         * @param node
         */
        private void pushLeft(Node node) {
           while(node != null) {
               this.stack.push(node);
               node = node.left;
           }
        }
    }
}
