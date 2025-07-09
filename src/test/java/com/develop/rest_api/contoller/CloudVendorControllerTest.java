package com.develop.rest_api.contoller;

import com.develop.rest_api.model.CloudVendor;
import com.develop.rest_api.serviceLayer.CloudVendorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcRequestBuilders.*;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    // since this is url testing ,so in this webmvc test is mandatory and in then inject mockmvc as normal mock will not work
    @Autowired
    private MockMvc mockMvc;
    // since control layer is communicating with service layer, therefore mock service layer
    @MockitoBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor("1","Amazon","USA","xxxxx");
        cloudVendorTwo = new CloudVendor("2","Azure","Australia","yyyy");

        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetCloudVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllCloudVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/cloudvendor")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreateCloudVendorDetails() throws Exception {
        // converting object to json
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter objw = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = objw.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Cloud Vendor Created Successfully!");
        this.mockMvc.perform(post("/cloudvendor").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateCloudVendorDetails() throws Exception {
        // converting object to json
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter objw = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = objw.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.updateCloudVendor(cloudVendorOne)).thenReturn("Cloud Vendor Updated Successfully");
        this.mockMvc.perform(put("/cloudvendor").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testDeleteCloudVendorDetails() throws Exception {
        when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Cloud Vendor Deleted Successfully");
        this.mockMvc.perform(delete("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
    }
}