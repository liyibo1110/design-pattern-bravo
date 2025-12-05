package com.github.liyibo1110.pattern.command.pattern;

import com.github.liyibo1110.pattern.command.pattern.command.Command;
import com.github.liyibo1110.pattern.command.pattern.command.ConcreteCommandA;
import com.github.liyibo1110.pattern.command.pattern.invoker.Invoker;
import com.github.liyibo1110.pattern.command.pattern.receiver.ReceiverA;

/**
 * @author liyibo
 * @date 2025-12-05 15:48
 */
public class Test {
    public static void main(String[] args) {
        Command command = buildCommand();
        Invoker invoker = new Invoker(command);
        invoker.request();
    }

    private static Command buildCommand() {
        ReceiverA receiver = new ReceiverA();
        return new ConcreteCommandA(receiver);
    }
}
