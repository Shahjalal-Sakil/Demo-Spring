package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
}
