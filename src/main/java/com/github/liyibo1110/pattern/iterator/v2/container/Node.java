package com.github.liyibo1110.pattern.iterator.v2.container;

/**
 * 在V2版本中，迭代器被分离出去了，不再是内部类，因此Node需要独立出来，让容器和迭代器都能访问到
 * @author liyibo
 * @date 2025-10-24 14:42
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
