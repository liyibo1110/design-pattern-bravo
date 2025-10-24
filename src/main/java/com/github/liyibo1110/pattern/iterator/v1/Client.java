package com.github.liyibo1110.pattern.iterator.v1;

import com.github.liyibo1110.pattern.iterator.v1.container.ArrayList;
import com.github.liyibo1110.pattern.iterator.v1.container.BinarySearchTree;
import com.github.liyibo1110.pattern.iterator.v1.container.LinkedList;
import com.github.liyibo1110.pattern.iterator.v1.iterator.Iterator;

/**
 * @author liyibo
 * @date 2025-10-24 13:37
 */
public class Client {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        System.out.println(search(arrayList.iterator(), "a"));

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println(search(linkedList.iterator(), "b"));

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(9);
        System.out.println(search(binarySearchTree.iterator(), 8));
    }

    /**
     * 遍历指定的迭代器，寻找是否存在target
     * @param iterator
     * @param target
     * @return
     */
    public static boolean search(Iterator<?> iterator, Object target) {
        while(iterator.hasNext()) {
            if(iterator.next().equals(target))
                return true;
        }
        return false;
    }
}
