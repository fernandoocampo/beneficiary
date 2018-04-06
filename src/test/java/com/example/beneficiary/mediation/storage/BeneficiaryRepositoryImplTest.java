/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.mediation.storage;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.util.TestHelper;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author fernando.ocampo
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BeneficiaryRepositoryImplTest {
    
    @Autowired
    private BeneficiaryRepository repository;
    
    public BeneficiaryRepositoryImplTest() {
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
     * Test of findBeneficiaryByAffiliateId method, of class BeneficiaryDAOImpl.
     */
    @Test
    public void find_a_new_beneficiary_by_its_id() {
        // given
        Beneficiary alexa = new Beneficiary();
        alexa.setCode("1003");
        alexa.setForename("Alexandra");
        alexa.setLastname("Sanauria");
        alexa.setRelationship("titular");
        alexa.setState(1);
        
        Beneficiary savedalexa = repository.save(alexa);
        
        String affiliatedId = savedalexa.getId();
        
        // when
        Beneficiary result = repository.findOne(affiliatedId);
        assertEquals(savedalexa, result);
    }
    
    @Test
    public void find_beneficiaries_that_have_a_given_affiliate_id() {
        // given
        Beneficiary newaffiliate = TestHelper.createAnyBeneficiary(1, null, "1004", 
            "Luis", "Ocampo", "titular", null);
        
        Beneficiary savedaffiliate = repository.save(newaffiliate);
        
        Beneficiary beneficiary1 = TestHelper.createAnyBeneficiary(1, null, "1005", 
            "Fernando", "Ocampo", "son", savedaffiliate.getId()); 
        
        Beneficiary beneficiary2 = TestHelper.createAnyBeneficiary(1, null, "1006", 
            "Johan", "Ocampo", "son", savedaffiliate.getId());
        
        Beneficiary beneficiary3 = TestHelper.createAnyBeneficiary(1, null, "1007", 
            "Luz", "Tello", "titular", null);
        
        repository.save(beneficiary1);
        repository.save(beneficiary2);
        repository.save(beneficiary3);
        
        // when
        List<Beneficiary> result = repository.findBeneficiaryByAffiliateId(savedaffiliate.getId());
        
        assertNotNull(result);
        assertTrue(!result.isEmpty());
        assertTrue(result.size() == 2);
        result.forEach(item -> {
            assertEquals(item.getRelationship(), "son");
            assertTrue(item.getForename().equals("Johan") || item.getForename().equals("Fernando"));
        });
        
    }
    
}
