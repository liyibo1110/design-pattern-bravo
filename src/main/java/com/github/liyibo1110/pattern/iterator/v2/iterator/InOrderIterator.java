package com.github.liyibo1110.pattern.iterator.v2.iterator;

import com.github.liyibo1110.pattern.iterator.v2.container.Node;

import java.util.Stack;

/**
 * @author liyibo
 * @date 2025-10-24 14:52
 */
public class InOrderIterator<E extends Comparable<E>> implements Iterator<E> {
    private final Stack<Node<E>> stack;

    public InOrderIterator(Node<E> root) {
        this.stack = new Stack<>();
        this.pushLeft(root);
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
