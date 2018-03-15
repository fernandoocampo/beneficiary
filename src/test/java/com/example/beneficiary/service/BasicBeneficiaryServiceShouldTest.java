/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.service;

import com.example.beneficiary.mediation.storage.BeneficiaryDAO;
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
public class BasicBeneficiaryServiceShouldTest {
    
    @MockBean
    private BeneficiaryDAO dao;
    
    @Autowired
    private BasicBeneficiaryService service;
    
    public BasicBeneficiaryServiceShouldTest() {
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
        Long affiliateId = 1l;
        Beneficiary newbeneficiary = TestHelper.createAnyBeneficiary(state, null, code, forename,
                lastname, relationship, affiliateId);
        
        // WHEN the creation of a beneficiary is requested
        Mockito.doNothing().when(dao).create(Mockito.any(Beneficiary.class));
        
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
        Long id = 2l;
        String code = "100";
        String forename = "Fernando";
        String lastname = "Ocampo";
        String relationship = "son";
        Long affiliateId = 1l;
        Beneficiary beneficiaryToUpdate = TestHelper.createAnyBeneficiary(state, id, code, 
                forename, lastname, relationship, affiliateId);
        
        Beneficiary updatedBeneficiary = TestHelper.createAnyBeneficiary(state, id, code, 
                forename, lastname, relationship, affiliateId);
        
        // WHEN the creation of a beneficiary is requested
        Mockito.when(dao.update(Mockito.any(Beneficiary.class))).thenReturn(updatedBeneficiary);
        
        try {
            service.update(beneficiaryToUpdate);
        } catch (Exception ex) {        
        // THEN must not be any error.
            fail("must not be any error and was threw this: " + ex.getMessage());
        }
    }
}
