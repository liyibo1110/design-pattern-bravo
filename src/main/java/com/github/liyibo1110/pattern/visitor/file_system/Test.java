package com.github.liyibo1110.pattern.visitor.file_system;

import com.github.liyibo1110.pattern.visitor.file_system.element.Directory;
import com.github.liyibo1110.pattern.visitor.file_system.element.File;
import com.github.liyibo1110.pattern.visitor.file_system.visitor.CalculateSizeVisitor;

/**
 * @author liyibo
 * @date 2025-12-05 18:14
 */
public class Test {
    public static void main(String[] args) {
        Directory root = new Directory("D:\\testDir");
        Directory documents = new Directory("D:\\documentDir");
        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.txt", 20);

        documents.addElement(file1);
        documents.addElement(file2);

        CalculateSizeVisitor sizeVisitor = new CalculateSizeVisitor();
        root.accept(sizeVisitor);   // 开始遍历并累加
        System.out.println("Total size: " + sizeVisitor.getTotalSize());
    }
}
