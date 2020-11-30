package com.example.demo;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ExternalAPIController {

    @RequestMapping(value = "/v1/post/{id}",method = RequestMethod.GET)
    public ResponseEntity<ExternalResponse> getPost(@PathVariable Integer id)
    {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String,Integer> params = new HashMap<>();
        params.put("id",id);

        long reqTime = System.currentTimeMillis();
        ExternalResponse externalResponse = restTemplate.getForObject(url,ExternalResponse.class, params);
        long resTime = System.currentTimeMillis();
        long elapsedTime = resTime - reqTime;

        externalResponse.setReqTime(reqTime);
        externalResponse.setResTime(resTime);
        externalResponse.setResTime(elapsedTime);

        return new ResponseEntity<>(externalResponse, HttpStatus.OK);

    }

    @RequestMapping(value = "/v1/post",method = RequestMethod.POST)
    public ResponseEntity<ExternalResponse> postExternal(@RequestBody ExternalResponse externalResponse)
    {
        String url = "https://jsonplaceholder.typicode.com/posts";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();


        Map<String, Object> data = new HashMap<>();
        data.put("userId",externalResponse.getUserId());
        data.put("title","TEST Title");
        data.put("body",externalResponse.getBody());

        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(data,httpHeaders);

        long reqTime = System.currentTimeMillis();
        ResponseEntity<ExternalResponse> response = restTemplate.postForEntity(url,entity,ExternalResponse.class);
        return response;
    }
}
