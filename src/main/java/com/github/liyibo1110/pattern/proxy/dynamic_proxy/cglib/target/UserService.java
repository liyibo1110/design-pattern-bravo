package com.github.liyibo1110.pattern.proxy.dynamic_proxy.cglib.target;

import com.github.liyibo1110.pattern.proxy.metric.Metric;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author liyibo
 * @date 2025-10-28 10:34
 */
@Slf4j
public class UserService implements IUserService {
    @Metric(bizTag="user", bizSubTag="user_register")
    @Override
    public Long register(String nickname, String mobile, String gender) {
        this.sleep(ThreadLocalRandom.current().nextInt(3));
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
