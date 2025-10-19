package com.github.liyibo1110.advanced.reflection.framework;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyibo
 * @date 2025-10-17 14:27
 */
@Slf4j
public class BaseDao<T> {

    /** 数据库相关初始化 */
    private static final BasicDataSource ds;

    static {
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/demo");
        ds.setUsername("root");
        ds.setPassword("123456");
    }

    /** 使用Spring的JdbcTemplate简化sql操作 */
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        entityClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void add(T obj) {
        // 构建column、value、以及实际参数
        StringBuilder columnBuilder = new StringBuilder();
        StringBuilder valueBuilder = new StringBuilder();
        List<Object> paramList = new ArrayList<>();

        try {
            for(Field f : entityClass.getDeclaredFields()) {
                f.setAccessible(true);
                Object value = f.get(obj);
                // 忽略null值
                if(value != null) {
                    columnBuilder.append(this.parseColumnName(f)).append(",");
                    valueBuilder.append("?").append(",");
                    paramList.add(value);
                }
            }
        } catch (IllegalAccessException e) {
            log.error("实体类字段属性设置错误, obj:{}", obj);
            throw new IllegalArgumentException("实体类字段属性设置错误");
        }
        String columns = columnBuilder.deleteCharAt(columnBuilder.length() - 1).toString();
        String values = valueBuilder.deleteCharAt(valueBuilder.length() - 1).toString();

        // 拼接sql
        String tableName = this.parseTableName(entityClass);
        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        System.out.println("sql: " + sql);

        // 执行sql
        Object[] params = paramList.toArray(new Object[0]);
        System.out.println("params: " + Arrays.toString(params));
        jdbcTemplate.update(sql, params);
    }

    private String parseTableName(Class<T> entityClass) {
        TableName anno = entityClass.getAnnotation(TableName.class);
        if(anno == null)
            return StrUtil.toUnderlineCase(entityClass.getSimpleName());
        else
            return anno.value();
    }

    private String parseColumnName(Field f) {
        if(f.isAnnotationPresent(TableField.class))
            return f.getAnnotation(TableField.class).value();
        else
            return StrUtil.toUnderlineCase(f.getName());
    }
}
