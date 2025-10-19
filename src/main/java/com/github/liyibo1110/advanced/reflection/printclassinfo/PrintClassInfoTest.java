package com.github.liyibo1110.advanced.reflection.printclassinfo;

import com.github.liyibo1110.advanced.reflection.printclassinfo.clazz.Son;
import com.github.liyibo1110.advanced.reflection.printclassinfo.util.ClassInfoPrinter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author liyibo
 * @date 2025-10-17 11:54
 */
public class PrintClassInfoTest {

    public static void main(String[] args) throws Exception {
        Class<Son> sonClass = Son.class;

        /** Son类 */
        System.out.println("\n------- Son类 -------");
        System.out.println(sonClass);

        System.out.println("\n------- Son类的注解信息 -------");
        for(Annotation anno : sonClass.getAnnotations())
            System.out.println(anno);

        /** Son类的构造器 */
        System.out.println("\n------- Son公共构造器 -------");
        Constructor<?>[] c1 = sonClass.getConstructors();
        ClassInfoPrinter.print(c1);

        System.out.println("\n------- Son所有构造器 -------");
        Constructor<?>[] c2 = sonClass.getDeclaredConstructors();
        ClassInfoPrinter.print(c2);

        System.out.println("\n------- 根据参数类型获取公共构造器 -------");
        Constructor<Son> constructorPublicOne = sonClass.getConstructor(int.class);
        ClassInfoPrinter.print(constructorPublicOne);
        Son son1 = constructorPublicOne.newInstance(1);

        System.out.println("\n------- 根据参数类型获取私有构造器 -------");
        Constructor<Son> constructorPrivateTwo = sonClass.getDeclaredConstructor(String.class, int.class);
        ClassInfoPrinter.print(constructorPrivateTwo);
        constructorPrivateTwo.setAccessible(true);
        Son son2 = constructorPrivateTwo.newInstance("a", 2);

        /** Son类的方法 */
        System.out.println("\n------- Son公共方法 -------");
        Method[] methods = sonClass.getMethods();
        ClassInfoPrinter.print(methods);

        System.out.println("\n------- Son所有方法 -------");
        Method[] declaredMethods = sonClass.getDeclaredMethods();
        ClassInfoPrinter.print(declaredMethods);

        System.out.println("\n------- sonPrivateMethod的泛型信息 -------");
        Method sonPrivateMethod = sonClass.getDeclaredMethod("sonPrivateMethod", List.class);
        for(Parameter p : sonPrivateMethod.getParameters())
            System.out.println(p.getParameterizedType().getTypeName());

        System.out.println("\n------- sonPrivateMethod方法上的注解信息 -------");
        for(Annotation anno : sonPrivateMethod.getAnnotations())
            System.out.println(anno);

        System.out.println("\n------- sonPrivateMethod参数上的注解信息 -------");
        for(Parameter p : sonPrivateMethod.getParameters()) {
            Annotation[] annotations = p.getAnnotations();
            for(Annotation anno : annotations)
                System.out.println(anno);
        }

        /** Son类的父类 */
        System.out.println("\n------- Son的父类（单继承） -------");
        Class<? super Son> superclass = sonClass.getSuperclass();
        System.out.println(superclass);

        System.out.println("\n------- Son的父类的泛型信息（无） -------");
        Type genericSuperclass = sonClass.getGenericSuperclass();
        ClassInfoPrinter.print(genericSuperclass);

        System.out.println("\n------- Son的父类的注解信息 -------");
        for(Annotation anno : superclass.getAnnotations())
            System.out.println(anno);

        System.out.println("\n------- Son父类的所有构造器 -------");
        ClassInfoPrinter.print(superclass.getDeclaredConstructors());

        System.out.println("\n------- Son父类的所有方法 -------");
        ClassInfoPrinter.print(superclass.getDeclaredMethods());

        /** Son类的父接口 */
        System.out.println("\n------- Son的父接口 -------");
        Class<?>[] interfaces = sonClass.getInterfaces();
        for(Class<?> clazz : interfaces)
            System.out.println(clazz);

        /** Son类的父接口的注解信息 */
        System.out.println("\n------- Son的父接口的注解信息 -------");
        for(Class<?> clazz : interfaces) {
            Annotation[] annotations = clazz.getAnnotations();
            if(annotations.length > 0) {
                System.out.println("\t\t" + clazz.getName());
                for(Annotation anno : annotations)
                    System.out.println("\t\t\t\t- " + anno);
            }else {
                System.out.println("\t\t" + clazz.getName() + "\n\t\t\t\t- 没有注解");
            }
        }

        /** Son类的父接口的泛型信息 */
        System.out.println("\n------- Son的父接口的泛型信息 -------");
        Type[] genericInterfaces = sonClass.getGenericInterfaces();
        for(Type genericInterface : genericInterfaces)
            ClassInfoPrinter.print(genericInterface);
    }
}
