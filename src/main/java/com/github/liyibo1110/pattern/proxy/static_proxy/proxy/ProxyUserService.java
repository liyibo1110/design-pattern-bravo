package com.github.liyibo1110.pattern.proxy.static_proxy.proxy;

import com.github.liyibo1110.pattern.proxy.metric.MetricTag;
import com.github.liyibo1110.pattern.proxy.metric.MetricUtil;
import com.github.liyibo1110.pattern.proxy.static_proxy.target.IUserService;
import lombok.extern.slf4j.Slf4j;

/**
 * 静态代理类，需要自己手动编写
 * @author liyibo
 * @date 2025-10-27 18:03
 */
@Slf4j
public class ProxyUserService implements IUserService {
    /** 目标对象 */
    private final IUserService userService;

    public ProxyUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public Long register(String nickname, String mobile, String gender) {
        return MetricUtil.metric(() -> userService.register(nickname, mobile, gender),
                (result, tagMap) -> {
                    log.info("ProxyUserService#register result: {}", result);
                    tagMap.put(MetricTag.BIZ_TAG, "user");
                    tagMap.put(MetricTag.BIZ_SUB_TAG, "user_register");
                });
    }
}
