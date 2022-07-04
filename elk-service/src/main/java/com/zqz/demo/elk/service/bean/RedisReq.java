package com.zqz.demo.elk.service.bean;

import lombok.Data;

import java.util.Date;

/**
 * @Author: ZQZ
 * @Description:
 * @ClassName: RedisReq
 * @Date: Created in 14:59 2022-6-22
 */
@Data
public class RedisReq {

    private String key;
    private String value;
    private String createTime;
    private String ip;
    private Integer status;
}
