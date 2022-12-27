package com.chw5.spring.redis;

import com.sun.scenario.effect.impl.prism.PrImage;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplication.class, args);
        redissonMethod();
    }

    private static void redissonMethod(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        config.setCodec(JsonJacksonCodec.INSTANCE);
        RedissonClient redisson = Redisson.create(config);

        // 通用对象桶（Object Bucket）
        RBucket<String> bucket = redisson.getBucket("bucket");
        bucket.set("bucket name");
        String strBucket = bucket.get();

    }

}
