package com.github.liyibo1110.pattern.chain_of_responsibility.pipeline;

import com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.biz.BadLanguageHandler;
import com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.biz.MessageHandler;
import com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.biz.SpaceHandler;
import com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.biz.UserMessage;
import com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.jar.Pipeline;

/**
 * @author liyibo
 * @date 2025-10-27 11:53
 */
public class Client {
    public static void main(String[] args) {
        Pipeline<String, UserMessage> steps = new Pipeline<>(new SpaceHandler())
                .addHandler(new BadLanguageHandler())
                .addHandler(new MessageHandler());
        UserMessage message = steps.execute("我靠，又没打着！");
        System.out.println(message);
    }
}
