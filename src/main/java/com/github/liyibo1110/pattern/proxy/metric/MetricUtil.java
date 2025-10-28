package com.github.liyibo1110.pattern.proxy.metric;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author liyibo
 * @date 2025-10-27 18:11
 */
@Slf4j
public final class MetricUtil {

    private MetricUtil() {}

    /**
     * 监控打tag
     * @param targetMethod 目标方法
     * @param tagSetter 标签设置器
     * @return 目标方法执行的结果
     * @param <T>
     */
    public static <T> T metric(Supplier<T> targetMethod, MetricTagSetter<T> tagSetter) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        T result = targetMethod.get();
        stopWatch.stop();
        try {
            Map<MetricTag, String> tagMap = initTagMap();
            tagSetter.apply(result, tagMap);
            doMetric(tagMap, stopWatch.getTotalTimeMillis());
        } catch (MetricException e) {
            log.error("executeMetric打点失败", e);
        }
        return result;
    }

    /**
     * 填充单个的tagMap
     * @return
     */
    private static Map<MetricTag, String> initTagMap() {
        Map<MetricTag, String> tag = new HashMap<>();
        try {
            // 请求路径
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            if(attributes != null) {
                ServletRequestAttributes requestAttributes = ((ServletRequestAttributes)attributes);
                tag.put(MetricTag.PATH, requestAttributes.getRequest().getRequestURI());
            }
            // 服务地址
            tag.put(MetricTag.HOST, "TODO");
            // 租户ID
            tag.put(MetricTag.UID, "TODO");
            // APP版本
            tag.put(MetricTag.APP_VERSION, "TODO");
            // APP平台
            tag.put(MetricTag.APP_PLATFORM, "TODO");
        } catch (Exception e) {
            log.error("MetricUtil#initTagMap error={}", e.getMessage());
        }
        return tag;
    }

    /**
     * 打印耗时和对应的tag数据
     * @param tagMap
     * @param totalTime
     * @throws MetricException
     */
    private static void doMetric(Map<MetricTag, String> tagMap, long totalTime) throws MetricException {
        log.info("接口耗时：{}毫秒, 上传打点数据：{}", totalTime, JSON.toJSONString(tagMap));
    }
}
