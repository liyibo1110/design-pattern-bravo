package com.github.liyibo1110.pattern.visitor.file_system.element;

import com.github.liyibo1110.pattern.visitor.file_system.visitor.FileSystemVisitor;

/**
 * @author liyibo
 * @date 2025-12-05 18:19
 */
public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
