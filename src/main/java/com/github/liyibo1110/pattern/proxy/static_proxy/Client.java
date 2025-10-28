package com.github.liyibo1110.pattern.proxy.static_proxy;

import com.github.liyibo1110.pattern.proxy.static_proxy.proxy.ProxyUserService;
import com.github.liyibo1110.pattern.proxy.static_proxy.target.UserService;

/**
 * @author liyibo
 * @date 2025-10-27 17:47
 */
public class Client {
    public static void main(String[] args) {
        ProxyUserService service = new ProxyUserService(new UserService());
        service.register("张三", "12345678901", "male");
    }
}
