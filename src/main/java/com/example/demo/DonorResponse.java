package com.example.demo;

public class DonorResponse {
    Long id;
    String extra;
    String message;
    public Long getId()
    {
        return id;

    }
    public String getExtra()
    {
        return extra;
    }
    public String getMessage()
    {
        return message;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setExtra(String extra)
    {
        this.extra = extra;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
}
