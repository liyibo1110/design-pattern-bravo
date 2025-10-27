package com.github.liyibo1110.pattern.chain_of_responsibility.pipeline.biz;

import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author liyibo
 * @date 2025-10-27 14:11
 */
@Data
@AllArgsConstructor
public class UserMessage {
    private String user;
    private String inputContent;
    private Date date;

    @Override
    public String toString() {
        return DateUtil.formatDateTime(date) + " " + user + "说: " + inputContent;
    }
}
