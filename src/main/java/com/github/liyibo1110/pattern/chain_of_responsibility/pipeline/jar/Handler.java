package com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.jar;

/**
 * 管道操作
 * @author liyibo
 * @date 2025-10-27 11:53
 */
public interface Handler<IN, OUT> {
    OUT process(IN input);
}
