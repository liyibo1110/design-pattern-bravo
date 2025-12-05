package com.github.liyibo1110.pattern.command.pattern.command;

import com.github.liyibo1110.pattern.command.pattern.receiver.ReceiverA;

/**
 * @author liyibo
 * @date 2025-12-05 17:19
 */
public class ConcreteCommandA implements Command {
    private final ReceiverA receiver;

    public ConcreteCommandA(ReceiverA receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.receiverMethod();
    }
}
