package com.example.demo.entity;


import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {
    private static final long serialId = 100L;
    private UUID correlationId;
    private long result;
    private boolean ready;

    public boolean getReady()
    {
        return ready;
    }
}
