package com.example.demo.model;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import lombok.Data;

import java.util.Date;


@Data
public class VideoDto {
    private long id;
    private String userName;
    private String fileName;
    private String url;
    private Date createdAt;
    private Date updatedAt;
    private int version;
}
