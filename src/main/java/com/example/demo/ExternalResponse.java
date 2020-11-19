package com.example.demo;

import lombok.Data;

@Data
public class ExternalResponse {
    private long userId;
    private long id;
    private String title;
    private String body;
    private long reqTime;
    private long resTime;
    private long elapsedTime;

}
