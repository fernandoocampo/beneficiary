/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.mediation.storage.jpa;

import com.example.beneficiary.model.Beneficiary;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.beneficiary.mediation.storage.BeneficiaryRepository;

/**
 *
 * @author Fernando.Ocampo
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories(basePackages = { "com.example.beneficiary.mediation.storage.jpa" })
public class BeneficiaryDAOImplTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private BeneficiaryRepository repository;
    
    public BeneficiaryDAOImplTest() {
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
    
    public void findOne(Long id) {
        
    }

    public void findAll() {
        
    }

    public void create(Beneficiary entity) {
        
    }

    public void update(Beneficiary entity) {
        
    }

    public void delete(Beneficiary entity) {
        
    }

    public void deleteById(Long entityId) {
        
    }

    /**
     * Test of findBeneficiaryByAffiliateId method, of class BeneficiaryDAOImpl.
     */
    @Test
    public void testFindBeneficiaryByAffiliateId() {
        // given
        Beneficiary alexa = new Beneficiary();
        alexa.setCode("1003");
        alexa.setForename("Alexandra");
        alexa.setLastname("Sanauria");
        alexa.setRelationship("titular");
        alexa.setState(1);
                
        Beneficiary savedalexa = entityManager.persist(alexa);
        entityManager.flush();
        
        Long affiliatedId = savedalexa.getId();
        
        // when
        Beneficiary result = repository.findOne(affiliatedId);
        assertEquals(savedalexa, result);
    }
    
}
