package com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.biz;

import com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.jar.Handler;

import java.util.Date;

/**
 * @author liyibo
 * @date 2025-10-27 14:20
 */
public class MessageHandler implements Handler<String, UserMessage> {
    @Override
    public UserMessage process(String input) {
        return new UserMessage("张三", input, new Date());
    }
}
