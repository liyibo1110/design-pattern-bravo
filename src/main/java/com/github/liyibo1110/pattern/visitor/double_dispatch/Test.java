package com.github.liyibo1110.pattern.visitor.double_dispatch;

import com.github.liyibo1110.pattern.visitor.double_dispatch.inheritance.Father;
import com.github.liyibo1110.pattern.visitor.double_dispatch.inheritance.Son;
import com.github.liyibo1110.pattern.visitor.double_dispatch.visitor.PrinterA;

/**
 * @author liyibo
 * @date 2025-12-05 18:05
 */
public class Test {
    public static void main(String[] args) {
        Father man = new Son();
        // 动态分派，通过多态机制最终调用Son类里面的say
        man.say();
        // 静态分派，通过重载机制最终调用了PrinterA里面Father的版本（因为重载不考虑多态）
        PrinterA printerA = new PrinterA();
        printerA.print(man);
        // 双重分派，这个才会最终调用PrinterA里面Son的版本（先多态找到Son，再利用重载调用了PrinterA里面Son的版本）
        man.accept(printerA);
    }
}
