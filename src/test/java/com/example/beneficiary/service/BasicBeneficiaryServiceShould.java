/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.service;

import com.example.beneficiary.mediation.storage.BeneficiaryRepository;
import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.util.TestHelper;
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
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test beneficiary service.
 * 
 * @author fernando.ocampo
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = BasicBeneficiaryService.class, secure = false)
public class BasicBeneficiaryServiceShould {
    
    @MockBean
    private BeneficiaryRepository dao;
    
    @Autowired
    private BasicBeneficiaryService service;
    
    public BasicBeneficiaryServiceShould() {
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
     * Test of create method, of class BasicBeneficiaryService.
     */
    @Test
    public void create_beneficiary() {
        // GIVEN the following beneficiary data
        int state = 1;
        String code = "100";
        String forename = "Fernando";
        String lastname = "Ocampo";
        String relationship = "son";
        String affiliateId = "1234-5678-9012";
        Beneficiary newbeneficiary = TestHelper.createAnyBeneficiary(state, null, code, forename,
                lastname, relationship, affiliateId);
        Beneficiary returnbeneficiary = TestHelper.createAnyBeneficiary(state, null, code, forename,
                lastname, relationship, affiliateId);
        
        // WHEN the creation of a beneficiary is requested
        Mockito.when(dao.insert(Mockito.any(Beneficiary.class))).thenReturn(returnbeneficiary);
        
        try {
            service.create(newbeneficiary);
        } catch (Exception ex) {        
        // THEN must not be any error.
            fail("must not be any error and was threw this: " + ex.getMessage());
        }
    }

    /**
     * Test of update method, of class BasicBeneficiaryService.
     */
    @Test
    public void update_beneficiary() {
        // GIVEN the following beneficiary data
        int state = 1;
        String id = "1999-2999-1922";
        String code = "100";
        String forename = "Fernando";
        String lastname = "Ocampo";
        String relationship = "son";
        String affiliateId = "1234-5678-9012";
        Beneficiary newbeneficiary = TestHelper.createAnyBeneficiary(state, id, code, 
                forename, lastname, relationship, affiliateId);
        Beneficiary returnbeneficiary = TestHelper.createAnyBeneficiary(state, id, code, 
                forename, lastname, relationship, affiliateId);
        
        // WHEN the creation of a beneficiary is requested
        Mockito.when(dao.save(Mockito.any(Beneficiary.class))).thenReturn(returnbeneficiary);
        
        try {
            service.create(newbeneficiary);
        } catch (Exception ex) {        
        // THEN must not be any error.
            fail("must not be any error and was threw this: " + ex.getMessage());
        }
    }
}
