package com.github.liyibo1110.pattern.command.pattern.invoker;

import com.github.liyibo1110.pattern.command.pattern.command.Command;

/**
 * 类似java.lang.Thread
 * @author liyibo
 * @date 2025-12-05 17:17
 */
public class Invoker {
    private final Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void request() {
        if(this.command != null)
            this.command.execute();
    }

    public void start() {
        this.request();
    }
}
