package com.github.liyibo1110.pattern.proxy.metric;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liyibo
 * @date 2025-10-27 18:07
 */
@Getter
@AllArgsConstructor
public enum MetricTag {

    /** 通用的tag */
    PATH("path"),    // 请求路径
    HOST("host"),    // 服务地址
    UID("uid"),      // 租户ID
    APP_VERSION("app_version"),     // APP版本
    APP_PLATFORM("app_platform"),   // APP平台

    /** 业务用的tag */
    BIZ_TAG("biz_tag"),             // 业务标签
    BIZ_SUB_TAG("biz_sub_tag") ;    // 业务副标签

    private final String code;
}
