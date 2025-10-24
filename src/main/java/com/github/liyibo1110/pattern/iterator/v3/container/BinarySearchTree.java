package com.github.liyibo1110.pattern.iterator.v3.container;

import com.github.liyibo1110.pattern.iterator.v2.container.Node;
import lombok.Getter;

/**
 * 版本3：和版本2不同之处在于，这里迭代器组合了容器，并非容器组合了迭代器，因此没有实现Iterable接口
 * @author liyibo
 * @date 2025-10-24 14:57
 */
public class BinarySearchTree<E extends Comparable<E>> {
    /** 需要能让外界获取到root */
    @Getter
    private Node<E> root;

    public BinarySearchTree() {
        this.root = null;
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
}
