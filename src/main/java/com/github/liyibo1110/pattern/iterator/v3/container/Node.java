package com.github.liyibo1110.pattern.iterator.v3.container;

/**
 * 和V2版本一致
 * @author liyibo
 * @date 2025-10-24 15:11
 */
public class Node<E> {
    public E data;
    public Node<E> left;
    public Node<E> right;

    public Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
