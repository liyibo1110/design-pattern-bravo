package com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.jar;

/**
 * @author liyibo
 * @date 2025-10-27 11:54
 */
public class Pipeline<IN, OUT> {

    private final Handler<IN, OUT> current;

    public Pipeline(Handler<IN, OUT> current) {
        this.current = current;
    }

    /**
     * 把下一个处理器，追加到当前处理器的后置
     * @param next
     * @return
     * @param <K>
     */
    public <K> Pipeline<IN, K> addHandler(Handler<OUT, K> next) {
        return new Pipeline<>(input -> next.process(current.process(input)));
    }

    /**
     * 执行当前handler
     * @param input
     * @return
     */
    public OUT execute(IN input) {
        return this.current.process(input);
    }
}
