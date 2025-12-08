package com.github.liyibo1110.pattern.visitor.double_dispatch.visitor;

import com.github.liyibo1110.pattern.visitor.double_dispatch.inheritance.Father;
import com.github.liyibo1110.pattern.visitor.double_dispatch.inheritance.Son;

/**
 * @author liyibo
 * @date 2025-12-05 18:06
 */
public interface Printer {
    void print(Father father);
    void print(Son son);
}
