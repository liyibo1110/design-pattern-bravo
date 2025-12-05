package com.github.liyibo1110.pattern.command.pattern.command;

import com.github.liyibo1110.pattern.command.pattern.receiver.ReceiverB;

/**
 * @author liyibo
 * @date 2025-12-05 17:19
 */
public class ConcreteCommandB implements Command {
    private final ReceiverB receiver;

    public ConcreteCommandB(ReceiverB receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.receiverMethod();
    }
}
