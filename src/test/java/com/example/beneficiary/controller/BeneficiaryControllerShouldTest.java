/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.controller;

import com.example.beneficiary.mediation.storage.BeneficiaryDAO;
import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.Result;
import com.example.beneficiary.service.BasicBeneficiaryService;
import com.example.beneficiary.mediation.storage.jpa.BeneficiaryDAOImpl;
import com.example.beneficiary.util.TestHelper;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
@WebMvcTest(value = {BeneficiaryController.class, BasicBeneficiaryService.class, BeneficiaryDAOImpl.class}, secure = false)
public class BeneficiaryControllerShouldTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private BeneficiaryDAO dao;
    
    public BeneficiaryControllerShouldTest() {
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
        String requestbody = "{\"affiliateId\":\"0001\"}";
        String expected = "{\"code\":null,\"message\":null,\"data\":[{\"id\":1,\"state\":1,\"code\":\"0001\",\"forename\":\"Frank\",\"lastname\":\"Sinatra\",\"relationship\":\"son\",\"affiliateId\":1},{\"id\":2,\"state\":1,\"code\":\"0002\",\"forename\":\"Paul\",\"lastname\":\"Anka\",\"relationship\":\"son\",\"affiliateId\":1}]}";
        Long affiliateid = 1l;

        List<Beneficiary> daoMockedResult = new ArrayList<>();
        daoMockedResult.add(TestHelper.createAnyBeneficiary(1, 1l, "0001", "Frank",
                "Sinatra", "son", 1l));
        daoMockedResult.add(TestHelper.createAnyBeneficiary(1, 2l, "0002", "Paul",
                "Anka", "son", 1l));
        
        // WHEN
        String request = "/beneficiaries";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(request)
                .content(requestbody)
                .contentType("application/json")
                .accept(MediaType.ALL);
        
        // mock the dao result.
        Mockito.when(dao.findBeneficiaryByAffiliateId(affiliateid)).thenReturn(daoMockedResult);
        
        // execute the request.
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        
        Result expectedObject = new Gson().fromJson(expected, Result.class);
        Result resultObject = new Gson().fromJson(result.getResponse().getContentAsString(), Result.class);
        
        // THEN
        assertEquals(expectedObject, resultObject);
    }

    /**
     * Test of getBeneficiary method, of class BeneficiaryController.
     */
    @Test
    public void get_beneficiary_by_id() throws Exception {
        // GIVEN the following request to query an affiliatedid
        Long affiliatedid = 1l;
        String expected = "{\"code\":null,\"message\":null,\"data\":{\"id\":1,\"code\":\"0001\",\"forename\":\"Frank\",\"lastname\":\"Sinatra\",\"relationship\":\"son\",\"affiliateId\":1,\"state\":1}}";
        
        Beneficiary returnedBeneficiary = TestHelper.createAnyBeneficiary(1, 1l, "0001", "Frank",
                "Sinatra", "son", 1l);
        
        // WHEN
        String request = "/beneficiaries/{id}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(request, affiliatedid);
        // mock the dao result.
        Mockito.when(dao.findOne(affiliatedid)).thenReturn(returnedBeneficiary);
        
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
        String requestbody = "{\"code\":\"100532\", \"forename\":\"Fernando\", \"lastname\":\"Ocampo\", \"relationship\":\"son\", \"affiliateId\":1}";
        String expected = "{\"code\":null,\"message\":null,\"data\":null}";
        
        // WHEN
        String request = "/beneficiaries";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(request)
                .content(requestbody)
                .contentType("application/json")
                .accept(MediaType.ALL);
        
        Mockito.doNothing().when(dao).create(Mockito.any(Beneficiary.class));
        
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        
        System.out.println(expected);
        System.out.println(result.getResponse().getContentAsString());
        
        // THEN
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    /**
     * Test of update method, of class BeneficiaryController.
     */
    @Test
    public void update_a_beneficiary() throws Exception {
        // GIVEN the following request to create a beneficiary
        String requestbody = "{\"id\":1003, \"code\":\"100532\", \"forename\":\"Fernando\", \"lastname\":\"Calero\", \"relationship\":\"son\", \"affiliateId\":1}";
        String expected = "{\"code\":null,\"message\":null,\"data\":null}";
        
        // exptected beneficiary updated.
        Beneficiary returnedBeneficiary = TestHelper.createAnyBeneficiary(1, 1003l, "100532", "Fernando",
                "Calero", "son", 1l);
        
        // WHEN
        String request = "/beneficiaries";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(request)
                .content(requestbody)
                .contentType("application/json")
                .accept(MediaType.ALL);
        
        Mockito.when(dao.update(Mockito.any(Beneficiary.class))).thenReturn(returnedBeneficiary);
        
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
        Long affiliatedid = 1l;
        String expected = "{\"code\":null,\"message\":null,\"data\":null}";
        
        // WHEN
        String request = "/beneficiaries/{id}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(request, affiliatedid);
        
        Mockito.doNothing().when(dao).deleteById(affiliatedid);
        
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        
        // THEN
        assertEquals(expected, result.getResponse().getContentAsString());
    }
    
}
