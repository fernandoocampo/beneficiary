/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.controller;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.Filter;
import com.example.beneficiary.model.Result;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test beneficiary controller.
 * 
 * @author fernando.ocampo
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = BeneficiaryController.class, secure = false)
public class BeneficiaryControllerShould {
    
    @Autowired
    private MockMvc mockMvc;
    
    public BeneficiaryControllerShould() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class BeneficiaryController.
     */
    @Test
    public void allow_to_search_by_affiliate_id() throws Exception {
        // GIVEN the following request body
        String requestbody = "{\"affiliateid\":\"0001\"}";
        String expected = "{\"code\":null,\"message\":null,\"data\":[{\"id\":\"1\",\"code\":\"001\",\"forename\":\"Frank\",\"lastname\":\"Sinatra\",\"relationship\":\"son\",\"affiliateId\":\"0001\"},{\"id\":\"2\",\"code\":\"0002\",\"forename\":\"Paul\",\"lastname\":\"Anka\",\"relationship\":\"son\",\"affiliateId\":\"0001\"}]}";
        
        // WHEN
        String request = "/beneficiaries";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(request)
                .content(requestbody)
                .contentType("application/json")
                .accept(MediaType.ALL);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        
        // THEN
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    /**
     * Test of getBeneficiary method, of class BeneficiaryController.
     */
    @Test
    public void get_beneficiary_by_id() throws Exception {
        // GIVEN the following request to query an affiliatedid
        String affiliatedid = "0001";
        String expected = "{\"code\":10,\"message\":null,\"data\":null}";
        
        // WHEN
        String request = "/beneficiaries/{id}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(request, affiliatedid);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        
        // THEN
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    /**
     * Test of create method, of class BeneficiaryController.
     */
    @Test
    public void create_a_beneficiary() throws Exception {
        // GIVEN the following request to create a beneficiary
        String requestbody = "{\"code\":\"100532\", \"forename\":\"Fernando\", \"lastname\":\"Ocampo\", \"relationship\":\"son\", \"affiliateId\":\"0001\"}";
        String expected = "{\"code\":10,\"message\":null,\"data\":null}";
        
        // WHEN
        String request = "/beneficiaries";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(request)
                .content(requestbody)
                .contentType("application/json")
                .accept(MediaType.ALL);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        
        // THEN
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    /**
     * Test of update method, of class BeneficiaryController.
     */
    @Test
    public void update_a_beneficiary() throws Exception {
        // GIVEN the following request to create a beneficiary
        String requestbody = "{\"id\":\"1003\", \"code\":\"100532\", \"forename\":\"Fernando\", \"lastname\":\"Calero\", \"relationship\":\"son\", \"affiliateId\":\"0001\"}";
        String expected = "{\"code\":10,\"message\":null,\"data\":null}";
        
        // WHEN
        String request = "/beneficiaries";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(request)
                .content(requestbody)
                .contentType("application/json")
                .accept(MediaType.ALL);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        
        // THEN
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    /**
     * Test of delete method, of class BeneficiaryController.
     */
    @Test
    public void delete_a_beneficiary() throws Exception {
        // GIVEN the following request to query an affiliatedid
        String affiliatedid = "0001";
        String expected = "{\"code\":10,\"message\":null,\"data\":null}";
        
        // WHEN
        String request = "/beneficiaries/{id}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(request, affiliatedid);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        
        // THEN
        assertEquals(expected, result.getResponse().getContentAsString());
    }
    
}
