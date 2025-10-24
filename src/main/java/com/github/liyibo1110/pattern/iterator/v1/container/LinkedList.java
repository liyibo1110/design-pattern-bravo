package com.github.liyibo1110.pattern.iterator.v1.container;

import com.github.liyibo1110.pattern.iterator.v1.iterator.Iterable;
import com.github.liyibo1110.pattern.iterator.v1.iterator.Iterator;

import java.util.NoSuchElementException;

/**
 * 版本1：以内部类自行实现了迭代器的功能（优点是可以直接访问外部类的字段，例如first）
 * @author liyibo
 * @date 2025-10-24 13:48
 */
public class LinkedList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    public int size() {
        return this.size;
    }

    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if(this.size == 0) // 首次添加元素时，first和last要指向同一个节点
            this.first = newNode;
        else {
            this.last.next = newNode;
            newNode.prev = this.last;
        }
        this.last = newNode;
        this.size++;
    }

    public boolean remove(Object obj) {
        Node<E> currentNode = first;
        // 遍历链表
        while(currentNode != null) {
            if(obj.equals(currentNode.data)) {
                // 找到则要解除当前元素与prev和next的关联
                this.unlink(currentNode);
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public E get(int index) {
        if(index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<E> node = this.getNode(index);
        return node.data;
    }

    private void unlink(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if(prev == null) {
            this.first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if(next == null) {
            this.last = prev;
        }else {
            next.prev = prev;
            node.next = null;
        }
        this.size--;
    }

    private Node<E> getNode(int index) {
        Node<E> currentNode;
        if(index < (this.size >> 1)) {  // index是否小于size的一半，是则从头部遍历
            currentNode = this.first;
            for(int i = 0; i < index; i++)
                currentNode = currentNode.next;
        }else { // 否则从尾部反向遍历
            currentNode = this.last;
            for(int i = this.size - 1; i > index; i--)
                currentNode = currentNode.prev;
        }
        return currentNode;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.data = element;
            this.next = null;
            this.prev = null;
        }
    }

    /** 以下是迭代器相关实现 */

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> currentNode = first;

        @Override
        public boolean hasNext() {
            return this.currentNode != null;
        }

        @Override
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            E data = this.currentNode.data;
            this.currentNode = this.currentNode.next;
            return data;
        }
    }
}
