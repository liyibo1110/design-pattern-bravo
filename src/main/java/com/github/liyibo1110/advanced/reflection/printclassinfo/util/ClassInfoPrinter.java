package com.github.liyibo1110.advanced.reflection.printclassinfo.util;

import java.lang.reflect.Executable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyibo
 * @date 2025-10-17 11:38
 */
public final class ClassInfoPrinter {

    private ClassInfoPrinter() {}

    /**
     * 打印泛型信息
     * @param type
     */
    public static void print(Type type) {
        if(type instanceof ParameterizedType) {
            ParameterizedType parameterizedTypeSuperclass = (ParameterizedType)type;
            // 得到泛型类型集合
            Type[] actualTypeArguments = parameterizedTypeSuperclass.getActualTypeArguments();
            List<String> genericTypeNames = new ArrayList<>();
            for(Type actualTypeArgument : actualTypeArguments) {
                Class<?> actualTypeClass = (Class<?>)actualTypeArgument;
                genericTypeNames.add(actualTypeClass.getName());
            }
            System.out.println(type.getTypeName() + "\n\t\t- " + genericTypeNames);
        }else {
            System.out.println(type.getTypeName() + "： " + "\n\t\t- 没有泛型信息");
        }
    }

    /**
     * 打印class/Method信息
     * @param targets
     */
    public static void print(Executable[] targets) {
        for(Executable target : targets) {
            // 修饰符
            StringBuilder sb = new StringBuilder(getModifierDesc(target.getModifiers()) + " ");
            // 方法名
            sb.append(target.getName());
            // 参数列表
            sb.append('(');
            Class<?>[] parameterTypes = target.getParameterTypes();
            for(Class<?> parameterType : parameterTypes)
                sb.append(parameterType.getName()).append(", ");
            if(parameterTypes.length != 0) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append(')');
            System.out.println(sb.toString());
        }
    }

    public static void print(Executable target) {
        print(new Executable[]{target});
    }

    private static String getModifierDesc(int modifier) {
        if(Modifier.isPublic(modifier))
            return "public";
        else if(Modifier.isPrivate(modifier))
            return "private";
        else if(Modifier.isProtected(modifier))
            return "protected";
        else if(Modifier.isStatic(modifier))
            return "static";
        else if(Modifier.isFinal(modifier))
            return "final";
        else
            return "";
    }
}
