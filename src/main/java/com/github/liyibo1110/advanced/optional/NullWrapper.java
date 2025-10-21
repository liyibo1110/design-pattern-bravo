package com.github.liyibo1110.advanced.optional;

import java.util.Objects;
import java.util.function.Function;

/**
 * 模拟Optional的实现
 * @author liyibo
 * @date 2025-10-21 11:28
 */
public class NullWrapper<T> {

    private static final NullWrapper<?> EMPTY = new NullWrapper<>();

    private final T value;

    private NullWrapper() {
        this.value = null;
    }

    /**
     * value必须不能null
     * @param value
     */
    private NullWrapper(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public static <T> NullWrapper<T> empty() {
        NullWrapper<T> t = (NullWrapper<T>) EMPTY;
        return t;
    }

    public static <T> NullWrapper<T> of(T value) {
        return new NullWrapper<>(value);
    }

    public static <T> NullWrapper<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public <U> NullWrapper<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if(isPresent())
            return NullWrapper.ofNullable(mapper.apply(value));
        else
            return empty();
    }

    public T orElse(T other) {
        return this.value != null ? this.value : other;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof NullWrapper))
            return false;
        NullWrapper<?> other = (NullWrapper<?>) obj;
        return Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public String toString() {
        return this.value != null
                ? String.format("Optional[%s]", this.value)
                : "Optional.empty";
    }
}
