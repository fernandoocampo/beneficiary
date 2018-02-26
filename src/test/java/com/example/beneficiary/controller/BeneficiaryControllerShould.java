/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.controller;

import com.example.beneficiary.mediation.storage.BeneficiaryRepository;
import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.service.BasicBeneficiaryService;
import com.example.beneficiary.util.TestHelper;
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
@WebMvcTest(value = {BeneficiaryController.class, BasicBeneficiaryService.class}, secure = false)
public class BeneficiaryControllerShould {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private BeneficiaryRepository dao;
    
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
        String requestbody = "{\"affiliateId\":\"0001\"}";
        String expected = "{\"code\":null,\"message\":null,\"data\":[{\"id\":\"1\",\"state\":1,\"code\":\"0001\",\"forename\":\"Frank\",\"lastname\":\"Sinatra\",\"relationship\":\"son\",\"affiliateId\":\"0001\"},{\"id\":\"2\",\"state\":1,\"code\":\"0002\",\"forename\":\"Paul\",\"lastname\":\"Anka\",\"relationship\":\"son\",\"affiliateId\":\"0001\"}]}";
        String affiliateid = "0001";

        List<Beneficiary> daoMockedResult = new ArrayList<>();
        daoMockedResult.add(TestHelper.createAnyBeneficiary(1, "1", "0001", "Frank",
                "Sinatra", "son", "0001"));
        daoMockedResult.add(TestHelper.createAnyBeneficiary(1, "2", "0002", "Paul",
                "Anka", "son", "0001"));
        
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
        
        // THEN
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    /**
     * Test of getBeneficiary method, of class BeneficiaryController.
     */
    @Test
    public void get_beneficiary_by_id() throws Exception {
        // GIVEN the following request to query an affiliatedid
        String affiliatedid = "1";
        String expected = "{\"code\":10,\"message\":null,\"data\":{\"id\":\"1\",\"state\":1,\"code\":\"0001\",\"forename\":\"Frank\",\"lastname\":\"Sinatra\",\"relationship\":\"son\",\"affiliateId\":\"0001\"}}";
        
        Beneficiary returnedBeneficiary = TestHelper.createAnyBeneficiary(1, "1", "0001", "Frank",
                "Sinatra", "son", "0001");
        
        // WHEN
        String request = "/beneficiaries/{id}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(request, affiliatedid);
        // mock the dao result.
        Mockito.when(dao.findBeneficiaryById(affiliatedid)).thenReturn(returnedBeneficiary);
        
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
        
        Beneficiary returnedBeneficiary = TestHelper.createAnyBeneficiary(1, "1", "100532", "Fernando",
                "Ocampo", "son", "0001");
        
        // WHEN
        String request = "/beneficiaries";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(request)
                .content(requestbody)
                .contentType("application/json")
                .accept(MediaType.ALL);
        
        Mockito.when(dao.insert(Mockito.any(Beneficiary.class))).thenReturn(returnedBeneficiary);
        
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
        
        Beneficiary returnedBeneficiary = TestHelper.createAnyBeneficiary(1, "1", "100532", "Fernando",
                "Ocampo", "son", "0001");
        
        // WHEN
        String request = "/beneficiaries";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(request)
                .content(requestbody)
                .contentType("application/json")
                .accept(MediaType.ALL);
        
        Mockito.when(dao.save(Mockito.any(Beneficiary.class))).thenReturn(returnedBeneficiary);
        
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
        
        Mockito.doNothing().when(dao).delete(affiliatedid);
        
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        
        // THEN
        assertEquals(expected, result.getResponse().getContentAsString());
    }
    
}
