package com.theforest.cacheservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class CacheController {


    @Cacheable(
            value = "squareCache",
    key = "#num")
    @GetMapping("/check/{num}")
    public Long timeWait(@PathVariable Integer num) {
        log.debug("time begin " + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("time end " + new Date());
        return Long.valueOf(num);
    }
}
