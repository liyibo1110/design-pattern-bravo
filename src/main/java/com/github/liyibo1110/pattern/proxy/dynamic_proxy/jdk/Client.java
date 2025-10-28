package com.github.liyibo1110.pattern.proxy.dynamic_proxy.jdk;

import com.github.liyibo1110.pattern.proxy.dynamic_proxy.jdk.aop.ApplicationContext;
import com.github.liyibo1110.pattern.proxy.dynamic_proxy.jdk.target.IUserService;

/**
 * @author liyibo
 * @date 2025-10-28 10:33
 */
public class Client {
    public static void main(String[] args) {
        String path = "com.github.liyibo1110.pattern.proxy.dynamic_proxy.jdk.target.UserService";
        ApplicationContext context = new ApplicationContext();
        IUserService service = (IUserService)context.getBean(path);
        service.register("张三", "12345678901", "male");
    }
}
