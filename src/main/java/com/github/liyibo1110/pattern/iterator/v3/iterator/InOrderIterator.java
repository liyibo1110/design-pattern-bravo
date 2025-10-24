package com.github.liyibo1110.pattern.iterator.v3.iterator;

import com.github.liyibo1110.pattern.iterator.v2.container.Node;
import com.github.liyibo1110.pattern.iterator.v3.container.BinarySearchTree;

import java.util.Stack;

/**
 * 版本3：在独立出来的基础上，改成接受容器本身，并对其进行遍历
 * @author liyibo
 * @date 2025-10-24 14:52
 */
public class InOrderIterator<E extends Comparable<E>> implements Iterator<E> {
    private final Stack<Node<E>> stack;

    public InOrderIterator(BinarySearchTree<E> tree) {
        this.stack = new Stack<>();
        this.pushLeft(tree.getRoot());
    }

    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    @Override
    public E next() {
        Node<E> current = this.stack.pop();
        this.pushLeft(current.right);
        return current.data;
    }

    private void pushLeft(Node<E> node) {
        while(node != null) {
            this.stack.push(node);
            node = node.left;
        }
    }
}
