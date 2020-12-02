package com.example.demo.repository;

import com.example.demo.entity.Response;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ResponseRepositoryImpl implements ResponseRepository {

    private RedisTemplate<UUID,Response> redisTemplate;
    private HashOperations hashOperations;

    public ResponseRepositoryImpl(RedisTemplate<UUID,Response> redisTemplate)
    {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Response response) {
        hashOperations.put("RESPONSE",response.getCorrelationId(),response);
    }

    @Override
    public Response findById(UUID id) {
        return (Response) hashOperations.get("RESPONSE",id);
    }
}
