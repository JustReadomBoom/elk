package com.zqz.demo.elk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZQZ
 * @Description:
 * @ClassName: LogTest
 * @Date: Created in 15:41 2022-6-14
 */
@RestController
@Slf4j
public class LogTest {

    @GetMapping("/log")
    public void log() {
        log.info("SpringBoot日志测试ELK...");
    }
}
