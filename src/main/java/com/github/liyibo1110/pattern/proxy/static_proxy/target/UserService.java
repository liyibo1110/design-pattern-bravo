package com.github.liyibo1110.pattern.proxy.static_proxy.target;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author liyibo
 * @date 2025-10-27 18:01
 */
@Slf4j
public class UserService implements IUserService {
    @Override
    public Long register(String nickname, String mobile, String gender) {
        // 原始的业务逻辑
        sleep(ThreadLocalRandom.current().nextInt(3));
        log.info("UserService#register 注册成功, nickname:{}, mobile:{}, sex:{}", nickname, mobile, gender);
        return 1L;
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            log.error("sleep exception", e);
        }
    }
}
