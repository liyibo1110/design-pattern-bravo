package com.github.liyibo1110.pattern.visitor.file_system.element;

import com.github.liyibo1110.pattern.visitor.file_system.visitor.FileSystemVisitor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyibo
 * @date 2025-12-05 18:16
 */
@Getter
public class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> elements = new ArrayList<>();
    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        // 访问当前文件夹
        visitor.visit(this);
        // 再访问下层的子文件
        for(FileSystemElement e : this.elements)
            e.accept(visitor);
    }

    public void addElement(FileSystemElement element) {
        this.elements.add(element);
    }
}
