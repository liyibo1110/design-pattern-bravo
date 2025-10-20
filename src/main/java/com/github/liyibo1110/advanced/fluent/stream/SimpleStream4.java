package com.github.liyibo1110.advanced.fluent.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 版本4：在版本3的基础上，优化了过程。
 * 将Stage拆分出了Sink，专门用来处理数据，Stage只负责衔接上下游操作
 * @author liyibo
 * @date 2025-10-20 14:56
 */
public class SimpleStream4<T> {

    private final List<T> source;

    /** 所有的具体算子 */
    private final List<Stage> stages = new ArrayList<>();

    private SimpleStream4(List<T> source) {
        this.source = source;
    }

    public static <T> SimpleStream4<T> of(List<T> source) {
        return new SimpleStream4<>(source);
    }

    public SimpleStream4<T> filter(Predicate<? super T> predicate) {
        this.stages.add(new FilterStage<>(predicate));
        return this;
    }

    public <R> SimpleStream4<R> map(Function<? super T, ? extends R> mapper) {
        this.stages.add(new MapStage<>(mapper));
        return (SimpleStream4<R>)this;
    }

    public void forEach(Consumer<? super T> action) {
        Sink sink = this.wrapStages(new ForEachSink<>(action));
        for(T e : this.source)
            sink.accept(e);
    }

    private Sink wrapStages(Sink sink) {
        for(int i = this.stages.size(); i >= 0 ; i--)
            sink = this.stages.get(i).wrapSink(sink);
        return sink;
    }

    private interface Stage {
        Sink wrapSink(Sink downstream);
    }

    /**
     * 处理数据
     */
    private interface Sink {
        void accept(Object obj);
    }

    /**
     * 当前Sink包含了下游的Sink，形成链式结构
     */
    private static abstract class ChainedSink implements Sink {
        protected final Sink downstream;

        public ChainedSink(Sink downstream) {
            this.downstream = downstream;
        }
    }

    private static class FilterStage<T> implements Stage {
        private final Predicate<? super T> predicate;

        FilterStage(Predicate<? super T> predicate) {
            this.predicate = predicate;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Sink wrapSink(Sink downstream) {
            return new ChainedSink(downstream) {
                @Override
                public void accept(Object obj) {
                    // 执行filter
                    System.out.println(obj + "_filter");
                    if(predicate.test((T)obj))
                        downstream.accept(obj);
                }
            };
        }
    }

    private static class MapStage<T, R> implements Stage {
        private final Function<? super T, ? extends R> mapper;

        MapStage(Function<? super T, ? extends R> mapper) {
            this.mapper = mapper;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Sink wrapSink(Sink downstream) {
            return new ChainedSink(downstream) {
                @Override
                public void accept(Object obj) {
                    System.out.println(obj + "_map");
                    R result = mapper.apply((T)obj);
                    downstream.accept(result);
                }
            };
        }
    }

    private static class ForEachSink<T> implements Sink {
        private final Consumer<? super T> action;

        ForEachSink(Consumer<? super T> action) {
            this.action = action;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void accept(Object obj) {
            action.accept((T)obj);
        }
    }

    public static void main(String[] args) {
        // 从结果可以看出，filter早于foreach执行，不符合stream的终端延迟启动流的特性
        List<String> names = Arrays.asList("张三1", "李四", "王五3");
        SimpleStream4<String> stream = SimpleStream4.of(names).filter(n -> n.length() > 2);
        System.out.println("---开始执行foreach---");
        stream.forEach(System.out::println);
    }
}
