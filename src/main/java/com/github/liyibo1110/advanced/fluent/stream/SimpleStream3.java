package com.github.liyibo1110.advanced.fluent.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 版本3：将不同的算子抽象成了Stage类型，可以正常运行。
 * @author liyibo
 * @date 2025-10-20 14:38
 */
public class SimpleStream3<T> {

    private final List<T> source;

    /** 所有的具体算子 */
    private final List<Stage> stages = new ArrayList<>();

    private SimpleStream3(List<T> source) {
        this.source = source;
    }

    public static <T> SimpleStream3<T> of(List<T> source) {
        return new SimpleStream3<>(source);
    }

    public SimpleStream3<T> filter(Predicate<? super T> predicate) {
        this.stages.add(new FilterStage<>(predicate));
        return this;
    }

    public <R> SimpleStream3<R> map(Function<? super T, ? extends R> mapper) {
        this.stages.add(new MapStage<>(mapper));
        return (SimpleStream3<R>)this;
    }

    public void forEach(Consumer<? super T> action) {
        for(T e : this.source) {
            // 经过每一个Stage实现
            Object result = this.process(e);
            if(result == null)
                continue;
            // 最后执行action
            action.accept((T)result);
        }
    }

    private Object process(Object obj) {
        Object result = obj;
        for(Stage stage : this.stages) {
            result = stage.accept(result);
            if(result == null)
                return null;
        }
        return result;
    }

    interface Stage {
        Object accept(Object obj);
    }

    static class FilterStage<T> implements Stage {
        private final Predicate<? super T> predicate;

        FilterStage(Predicate<? super T> predicate) {
            this.predicate = predicate;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Object accept(Object obj) {
            System.out.println(obj + "_filter");
            if(this.predicate.test((T)obj))
                return obj;
            else
                return null;
        }
    }

    static class MapStage<T, R> implements Stage {
        private final Function<? super T, ? extends R> mapper;

        MapStage(Function<? super T, ? extends R> mapper) {
            this.mapper = mapper;
        }

        @Override
        public Object accept(Object obj) {
            System.out.println(obj + "_map");
            return mapper.apply((T)obj);
        }
    }

    public static void main(String[] args) {
        // 从结果可以看出，filter早于foreach执行，不符合stream的终端延迟启动流的特性
        List<String> names = Arrays.asList("张三1", "李四", "王五3");
        SimpleStream3<String> stream = com.github.liyibo1110.advanced.fluent.stream.SimpleStream3.of(names).filter(n -> n.length() > 2);
        System.out.println("---开始执行foreach---");
        stream.forEach(System.out::println);
    }
}
