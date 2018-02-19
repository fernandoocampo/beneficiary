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
        // GIVEN
        Filter filter = null;
        String expected = "{\"code\":null,\"message\":null,\"data\":[{\"id\":\"1\",\"code\":\"001\",\"forename\":\"Frank\",\"lastname\":\"Sinatra\",\"relationship\":\"son\",\"affiliateId\":\"0001\"},{\"id\":\"2\",\"code\":\"0002\",\"forename\":\"Paul\",\"lastname\":\"Anka\",\"relationship\":\"son\",\"affiliateId\":\"0001\"}]}";
        
        // WHEN
        String request = "/beneficiaries";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(request).
                content("{\"affiliateid\":\"0001\"}").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isBadRequest()).andReturn();
        
        // THEN
        assertEquals(expected, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBeneficiary method, of class BeneficiaryController.
     */
    @Test
    public void testGetBeneficiary() {
        System.out.println("getBeneficiary");
        String id = "";
        BeneficiaryController instance = new BeneficiaryController();
        ResponseEntity<Result> expResult = null;
        ResponseEntity<Result> result = instance.getBeneficiary(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class BeneficiaryController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Beneficiary beneficiary = null;
        BeneficiaryController instance = new BeneficiaryController();
        ResponseEntity<Result> expResult = null;
        ResponseEntity<Result> result = instance.create(beneficiary);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class BeneficiaryController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Beneficiary beneficiary = null;
        BeneficiaryController instance = new BeneficiaryController();
        ResponseEntity<Result> expResult = null;
        ResponseEntity<Result> result = instance.update(beneficiary);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BeneficiaryController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        BeneficiaryController instance = new BeneficiaryController();
        ResponseEntity<Result> expResult = null;
        ResponseEntity<Result> result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
