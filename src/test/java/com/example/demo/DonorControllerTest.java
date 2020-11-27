package com.example.demo;

import com.example.demo.api.DonorController;
import com.example.demo.model.DonorDto;
import com.example.demo.service.DonorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;


@WebMvcTest(controllers = DonorController.class)
public class DonorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DonorService donorService;

    @Test
    public void getDonors_ReturnDonorDtoListTest() throws Exception
    {
        List<DonorDto> list = new ArrayList<>();
        list.add(new DonorDto("TN","TG","1234"));
        list.add(new DonorDto("TN1","TG2","1234"));

        doReturn(list).when(donorService).getDonors();

        MvcResult mvcResult = this.mockMvc
                .perform(get("/donors"))
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();

        List<DonorDto> res = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                            new TypeReference<List<DonorDto>>() {});
        assertEquals(res,list);
        assertEquals(res.size(),2);
    }

    @Test
    public void getDonorsByGroup_returnsDonorDtoListTest() throws Exception {
        List<DonorDto> list = new ArrayList<>();
        list.add(new DonorDto("TN","TG","1234"));
        list.add(new DonorDto("TN1","TG","1234"));

        doReturn(list).when(donorService).getDonorsByBloodGroup("TG");

        MvcResult mvcResult = this.mockMvc
                                    .perform(get("/v1/donors/{bloodGroup}","TG"))
                                    .andExpect(status().isOk())
                                    .andReturn();

        ObjectMapper mapper = new ObjectMapper();

        List<DonorDto> res = mapper.readValue(mvcResult.getResponse().getContentAsString(),
                new TypeReference<List<DonorDto>>() {});

        for(DonorDto dto: res)
        {
            assertEquals(dto.getBloodGroup(),"TG");
        }

        assertEquals(res,list);
    }

    @Test
    public void createDonor_callsDonorServiceMethodTest() throws Exception {
        DonorDto donorDto = new DonorDto("TN","TG","1234");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(donorDto);

        this.mockMvc
                .perform(post("/donors").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());

        verify(donorService).createDonor(donorDto);

        //Alternative
        ArgumentCaptor<DonorDto> anyDonor = ArgumentCaptor.forClass(DonorDto.class);
        verify(donorService).createDonor(anyDonor.capture());

        assertEquals(anyDonor.getValue().getName(),donorDto.getName());

    }

    @Test
    public void getDonor_returnDonorByIdTest() throws Exception {
        DonorDto donorDto = new DonorDto("TN","TG","1234");

        doReturn(donorDto).when(donorService).getDonorById(1);

        MvcResult mvcResult = this.mockMvc
                .perform(get("/donors/{id}",1))
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();

        DonorDto res = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<DonorDto>() {
        });

        assertEquals(res,donorDto);
    }

    @Test
    public void deleteDonor_callDonorServiceDeleteDonorTest() throws Exception {

        this.mockMvc.perform(delete("/donors/{id}",1))
                .andExpect(status().isOk());

        verify(donorService).deleteDonor(1);
    }

    @Test
    public void updateDonor_invokeDonorServiceUpdate() throws Exception {
        DonorDto dto = new DonorDto("TN","TG","1234");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(dto);

        this.mockMvc
                .perform(put("/donors/{id}",1).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());

        verify(donorService).updateDonor(dto,1);

    }

}
