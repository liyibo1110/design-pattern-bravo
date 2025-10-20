package com.github.liyibo1110.advanced.fluent.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 版本1：filter早于foreach执行，不符合stream的终端延迟启动流的特性
 * @author liyibo
 * @date 2025-10-20 10:37
 */
public class SimpleStream1<T> {

    private List<T> source;

    private SimpleStream1(List<T> source) {
        this.source = source;
    }

    public static <T> SimpleStream1<T> of(List<T> source) {
        return new SimpleStream1<>(source);
    }

    public SimpleStream1<T> filter(Predicate<? super T> predicate) {
        List<T> newSource = new ArrayList<>(this.source.size());
        for(T e : this.source) {
            System.out.println(e + "_filter");
            if(predicate == null || predicate.test(e))
                newSource.add(e);
        }
        this.source = newSource;
        return this;
    }

    public void forEach(Consumer<? super T> action) {
        for(T e : this.source)
            action.accept(e);
    }

    public static void main(String[] args) {
        // 从结果可以看出，filter早于foreach执行，不符合stream的终端延迟启动流的特性
        List<String> names = Arrays.asList("张三1", "李四", "王五3");
        SimpleStream1<String> stream = SimpleStream1.of(names).filter(n -> n.length() > 2);
        System.out.println("---开始执行foreach---");
        stream.forEach(System.out::println);
    }
}
