package com.github.liyibo1110.pattern.visitor.double_dispatch.inheritance;

import com.github.liyibo1110.pattern.visitor.double_dispatch.visitor.Printer;

/**
 * @author liyibo
 * @date 2025-12-05 18:06
 */
public class Father {

    public void say() {
        System.out.println("I am father.");
    }

    public void accept(Printer printer) {
        printer.print(this);
    }
}
