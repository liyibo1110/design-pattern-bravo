package com.github.liyibo1110.pattern.iterator.v3;

import com.github.liyibo1110.pattern.iterator.v3.iterator.InOrderIterator;
import com.github.liyibo1110.pattern.iterator.v3.container.BinarySearchTree;

/**
 * @author liyibo
 * @date 2025-10-24 15:11
 */
public class Client {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(9);

        InOrderIterator<Integer> iter = new InOrderIterator<>(tree);
        while(iter.hasNext())
            System.out.println(iter.next());
    }
}
