package com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.biz;

import com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.jar.Handler;

/**
 * @author liyibo
 * @date 2025-10-27 14:22
 */
public class BadLanguageHandler implements Handler<String, String> {
    @Override
    public String process(String input) {
        return input.replace("我靠", "**");
    }
}
