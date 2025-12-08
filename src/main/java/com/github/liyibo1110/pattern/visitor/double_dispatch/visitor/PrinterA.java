package com.github.liyibo1110.pattern.visitor.double_dispatch.visitor;

import com.github.liyibo1110.pattern.visitor.double_dispatch.inheritance.Father;
import com.github.liyibo1110.pattern.visitor.double_dispatch.inheritance.Son;

/**
 * @author liyibo
 * @date 2025-12-05 18:08
 */
public class PrinterA implements Printer {
    @Override
    public void print(Father father) {
        System.out.println("print father in PrinterA.");
    }

    @Override
    public void print(Son son) {
        System.out.println("print son in PrinterA.");
    }
}
