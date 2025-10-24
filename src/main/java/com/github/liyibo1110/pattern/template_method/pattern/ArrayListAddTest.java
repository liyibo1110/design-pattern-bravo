package com.github.liyibo1110.pattern.template_method.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyibo
 * @date 2025-10-23 17:31
 */
public class ArrayListAddTest extends AbstractCodeTestTemplate {
    @Override
    protected void executeCode() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10000; i++)
            list.add(i);
    }
}
