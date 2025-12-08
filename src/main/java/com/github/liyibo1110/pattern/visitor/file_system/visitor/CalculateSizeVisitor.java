package com.github.liyibo1110.pattern.visitor.file_system.visitor;

import com.github.liyibo1110.pattern.visitor.file_system.element.Directory;
import com.github.liyibo1110.pattern.visitor.file_system.element.File;
import lombok.Getter;

/**
 * @author liyibo
 * @date 2025-12-05 18:17
 */
@Getter
public class CalculateSizeVisitor implements FileSystemVisitor {
    private int totalSize = 0;
    @Override
    public void visit(File file) {
       this.totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // 不需要统计目录
    }
}
