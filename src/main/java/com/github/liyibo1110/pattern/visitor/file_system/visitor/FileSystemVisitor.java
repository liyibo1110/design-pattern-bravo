package com.github.liyibo1110.pattern.visitor.file_system.visitor;

import com.github.liyibo1110.pattern.visitor.file_system.element.Directory;
import com.github.liyibo1110.pattern.visitor.file_system.element.File;

/**
 * @author liyibo
 * @date 2025-12-05 18:16
 */
public interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}
