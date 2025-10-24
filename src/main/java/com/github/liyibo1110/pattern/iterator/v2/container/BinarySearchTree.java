package com.github.liyibo1110.pattern.iterator.v2.container;

import com.github.liyibo1110.pattern.iterator.v2.iterator.Iterable;
import com.github.liyibo1110.pattern.iterator.v2.iterator.Iterator;
import com.github.liyibo1110.pattern.iterator.v2.iteratorfactory.IteratorFactory;

/**
 * 版本1：将容器、迭代器分离（通过工厂），允许容器通过组合的形式切换迭代器
 * @author liyibo
 * @date 2025-10-24 14:57
 */
public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
    private Node<E> root;

    private final IteratorFactory<E> factory;

    public BinarySearchTree(IteratorFactory<E> factory) {
        this.root = null;
        this.factory = factory;
    }

    public void insert(E data) {
        this.root = this.insertRec(this.root, data);
    }

    private Node<E> insertRec(Node<E> root, E data) {
        if(root == null) {  // 递归的结束条件
            root = new Node<>(data);
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

    private boolean searchRec(Node<E> root, E data) {
        if(root == null)
            return false;
        if(data.compareTo(root.data) == 0)  // 找到了
            return true;
        if(data.compareTo(root.data) < 0)   // 数据比当前节点小，往左继续找
            return this.searchRec(root.left, data);
        else // 数据比当前节点大，往右继续找
            return this.searchRec(root.right, data);
    }

    @Override
    public Iterator<E> iterator() {
        return this.factory.createIterator(this.root);
    }
}
