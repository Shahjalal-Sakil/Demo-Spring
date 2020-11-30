package com.example.demo;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ExternalAPIController.class)
public class ExternalAPIControllerTest {

    @Autowired
    MockMvc mockMvc;




    @Mock
    RestTemplate restTemplate;





    @Test
    public void testGetPost_ReturnsExternalResponse() throws Exception {

        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        Map<String,Integer> params = new HashMap<>();
        params.put("id",1);
        ExternalResponse externalResponse=new ExternalResponse(1,1,"TT","TB",1234,1245,10);


        doReturn(externalResponse).when(restTemplate).getForObject(url,ExternalResponse.class,params);

         MvcResult mvcResult = this.mockMvc.perform(get("/v1/post/{id}",1))
                                            .andExpect(status().isOk())
                                           .andReturn();


        ObjectMapper mapper = new ObjectMapper();
        ExternalResponse res = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<ExternalResponse>() {
        });

        assertEquals(res.getTitle(),externalResponse.getTitle());
        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void testPostExternal_delegatesItToExternalAPI() throws Exception {

        String url = "https://jsonplaceholder.typicode.com/posts";
        ExternalResponse externalResponse=new ExternalResponse(1,1,"TT","TB",1234,1245,10);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(externalResponse);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> data = new HashMap<>();
        data.put("userId",externalResponse.getUserId());
        data.put("id",externalResponse.getId());
        data.put("title",externalResponse.getTitle());
        data.put("body",externalResponse.getBody());
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(data,httpHeaders);

        ResponseEntity<ExternalResponse> res = new ResponseEntity<>(externalResponse, HttpStatus.OK);
        doReturn(res).when(restTemplate).postForEntity(url,entity,ExternalResponse.class);


        MvcResult mvcResult=this.mockMvc.perform(post("/v1/post").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated())
                .andReturn();

        ExternalResponse result = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<ExternalResponse>() {
        });

       //verify(restTemplate).postForEntity(url,entity,ExternalResponse.class);
        assertEquals(result.getUserId(),externalResponse.getUserId());


    }
}
