package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalResponse {
    private long userId;
    private long id;
    private String title;
    private String body;
    private long reqTime;
    private long resTime;
    private long elapsedTime;

}
