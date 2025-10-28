package com.github.liyibo1110.pattern.proxy.dynamic_proxy.cglib;

import com.github.liyibo1110.pattern.proxy.dynamic_proxy.cglib.aop.ApplicationContext;
import com.github.liyibo1110.pattern.proxy.dynamic_proxy.cglib.target.IUserService;

/**
 * @author liyibo
 * @date 2025-10-28 11:00
 */
public class Client {
    public static void main(String[] args) {
        String path = "com.github.liyibo1110.pattern.proxy.dynamic_proxy.cglib.target.UserService";
        ApplicationContext context = new ApplicationContext();
        IUserService service = (IUserService)context.getBean(path);
        service.register("张三", "12345678901", "male");
    }
}
