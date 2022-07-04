package com.zqz.demo.elk.service;

import cn.hutool.json.JSONUtil;
import com.zqz.demo.elk.service.bean.RedisReq;
import com.zqz.demo.elk.service.bean.RedisResp;
import com.zqz.demo.elk.service.bean.Student;
import com.zqz.demo.elk.service.utils.RedisClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ZQZ
 * @Description:
 * @ClassName: LogTest
 * @Date: Created in 15:41 2022-6-14
 */
@RestController
@Slf4j
public class LogTest {
    @Autowired
    private RedisClient redisClient;

    @GetMapping("/log")
    public void log() {
        log.info("SpringBoot日志测试ELK...");
    }


    @PostMapping("/log2")
    public void log2(@RequestBody Student student) {
        log.info("请求参数:[{}]", JSONUtil.toJsonStr(student));

    }

    @PostMapping("/logRedisSet")
    public RedisResp logRedisSet(@RequestBody RedisReq req) {
        log.info("redis设置测试请求参数:[{}]", JSONUtil.toJsonStr(req));
        RedisResp resp = new RedisResp();
        try {
            redisClient.set(req.getKey(), JSONUtil.toJsonStr(req));
            resp.setKey(req.getKey());
            resp.setValue(JSONUtil.toJsonStr(req));
        } catch (Exception e) {
            log.error("redis测试出现异常:[{}]", e.getMessage(), e);
            return resp;
        }
        return resp;
    }

    @GetMapping("/logRedisGet")
    public Object logRedisGet(@RequestParam("key") String key) {
        log.info("redis获取测试请求参数:[{}]", key);
        try {
            String val = redisClient.get(key);
            if (ObjectUtils.isEmpty(val)) {
                log.info("未获取到redis缓存信息, key:[{}]", key);
                return null;
            }
            return val;
        } catch (Exception e) {
            log.error("redis测试出现异常:[{}]", e.getMessage(), e);
            return null;
        }
    }
}
