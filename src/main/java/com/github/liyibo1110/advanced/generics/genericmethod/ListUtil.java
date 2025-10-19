package com.github.liyibo1110.advanced.generics.genericmethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyibo
 * @date 2025-10-17 11:05
 */
public class ListUtil {

    public static <T> List<T> filter(List<T> list, Matcher<T> matcher) {
        List<T> result = new ArrayList<>();
        for(T e : list) {
            if(matcher.isMatch(e))
                result.add(e);
        }
        return result;
    }

    public static <T, R> List<R> map(List<T> list, Mapper<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for(T e : list)
            result.add(mapper.mapping(e));
        return result;
    }

    public interface Mapper<T, R> {
        R mapping(T item);
    }

    public interface Matcher<T> {
        boolean isMatch(T item);
    }
}
