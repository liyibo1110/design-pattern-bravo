package com.github.liyibo1110.advanced.fluent.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 版本2：缓存了Predicate，具备了终端延迟启动流的特性。
 * 但是不灵活，因为Predicate写死到了foreach里面，整体功能也不全。
 * @author liyibo
 * @date 2025-10-20 11:29
 */
public class SimpleStream2<T> {

    private final List<T> source;

    /** 保存Predicate */
    private Predicate<? super T> predicate;

    private SimpleStream2(List<T> source) {
        this.source = source;
    }

    public static <T> SimpleStream2<T> of(List<T> source) {
        return new SimpleStream2<>(source);
    }

    public SimpleStream2<T> filter(Predicate<? super T> predicate) {
        this.predicate = predicate;
        return this;
    }

    public void forEach(Consumer<? super T> action) {
        for(T e : this.source) {
            System.out.println(e + "_filter");
            if(predicate == null || predicate.test(e))
                action.accept(e);
        }

    }

    public static void main(String[] args) {
        // 从结果可以看出，filter早于foreach执行，不符合stream的终端延迟启动流的特性
        List<String> names = Arrays.asList("张三1", "李四", "王五3");
        SimpleStream2<String> stream = SimpleStream2.of(names).filter(n -> n.length() > 2);
        System.out.println("---开始执行foreach---");
        stream.forEach(System.out::println);
    }
}
