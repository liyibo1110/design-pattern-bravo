package com.github.liyibo1110.pattern.builder.step.demo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liyibo
 * @date 2025-10-23 14:37
 */
public class BatchResultTest {

    @Test
    public void test() {
        List<Student> students = Arrays.asList(
                new Student(1L, "张三"),
                new Student(2L, "李四"),
                new Student(3L, "王五")
        );
        String tag = "这里是tag信息";
        BatchResult<Student> result = this.batchAttachTagForStudent(students, tag);
        System.out.println("是否全部成功：" + result.isAllCompleted());

        // 还可以用内置的convert方法来转换成其它类型的对象
        BatchResult<StudentDTO> rpcResult = result.convert(s -> new StudentDTO(s.getId()));
    }

    /**
     * 批量给学生打标
     * @param students
     * @param tag
     * @return
     */
    private BatchResult<Student> batchAttachTagForStudent(List<Student> students, String tag) {
        if(CollUtil.isEmpty(students) || StrUtil.isBlank(tag))
            throw new IllegalArgumentException("参数错误");
        List<Student> completedStudents = new ArrayList<>(students.size());
        for(Student s : students) {
            if(!this.attachTag(s, tag)) {
                // 中断批量操作
                return BatchResult.<Student>builder()
                        .interrupted()
                        .reason(1001, "打标失败")
                        .result(students.size(), completedStudents)
                        .build();
            }
            completedStudents.add(s);
        }
        // 批量操作成功
        return BatchResult.<Student>builder()
                .finished()
                .result(students.size(), completedStudents)
                .build();
    }

    private boolean attachTag(Student student, String tag) {
        return ThreadLocalRandom.current().nextInt(10) > 3;
    }

    @Data
    @AllArgsConstructor
    static class Student {
        private Long id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class StudentDTO {
        private Long id;
    }
}
