package com.example.demo.conf;

import com.example.demo.entity.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;

@Configuration
public class RedisConfiguration {

    @Bean
    JedisConnectionFactory jedisConnectionFactory()
    {
        RedisStandaloneConfiguration conf = new RedisStandaloneConfiguration("localhost",6379);

        return new JedisConnectionFactory(conf);
    }
    @Bean
    RedisTemplate<UUID, Response> responseRedisTemplate()
    {
        RedisTemplate<UUID,Response> redisTemplate= new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

}
