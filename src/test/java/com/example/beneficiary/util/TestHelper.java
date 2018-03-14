/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.util;

import com.example.beneficiary.model.Beneficiary;

/**
 * Utility to build objects and so on.
 * 
 * @author fernando.ocampo
 */
public class TestHelper {
    
    public static Beneficiary createAnyBeneficiary(int state, Long id, String code, 
            String forename, String lastname, String relationship, 
            Long affiliateId) {
        
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setId(id);
        beneficiary.setCode(code);
        beneficiary.setForename(forename);
        beneficiary.setLastname(lastname);
        beneficiary.setRelationship(relationship);
        beneficiary.setState(state);
        beneficiary.setAffiliateId(affiliateId);
        return beneficiary;
    }
}
