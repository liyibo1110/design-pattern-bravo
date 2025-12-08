package com.github.liyibo1110.pattern.visitor.file_system.element;

import com.github.liyibo1110.pattern.visitor.file_system.visitor.FileSystemVisitor;
import lombok.Getter;

/**
 * @author liyibo
 * @date 2025-12-05 18:15
 */
@Getter
public class File implements FileSystemElement {
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
