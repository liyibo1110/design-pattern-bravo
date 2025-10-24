package com.github.liyibo1110.pattern.iterator.v2;

import com.github.liyibo1110.pattern.iterator.v2.container.BinarySearchTree;
import com.github.liyibo1110.pattern.iterator.v2.iterator.Iterator;
import com.github.liyibo1110.pattern.iterator.v2.iteratorfactory.InOrderIteratorFactory;

/**
 * @author liyibo
 * @date 2025-10-24 14:30
 */
public class Client {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new InOrderIteratorFactory<Integer>());
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(9);

        Iterator<Integer> iterator = tree.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }
}
