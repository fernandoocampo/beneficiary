/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.service;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.BeneficiaryDataException;

/**
 * checks if the beneficiary data and semantic is valid.
 * 
 * @author fernando.ocampo
 */
public class BeneficiaryServiceHelper {
    
    /**
     * Checks if the data of a given beneficiary is valid.
     * 
     * @param beneficiary data for a beneficiary.
     * @param withID it states if the id must be validated as well (true).
     * @throws BeneficiaryDataException if the given data is not right.
     */
    protected static void checkBeneficiaryData(Beneficiary beneficiary, 
            boolean withID) throws BeneficiaryDataException {
        if(beneficiary == null) {
            throw new BeneficiaryDataException("001","Must provide data for the beneficiary");
        }
        
        if(!isValid(beneficiary.getAffiliateId())) {
            throw new BeneficiaryDataException("002", "Beneficiary must have an affiliate id");
        }
        
        if(!isValid(beneficiary.getCode())) {
            throw new BeneficiaryDataException("003", "Beneficiary must have a code");
        }
        
        if(withID && !isValid(beneficiary.getId())) {
            throw new BeneficiaryDataException("004", "Must provide the id of the beneficiary");
        }
    }
    
    /**
     * Return true if the given String contains characters.
     * @param data String value
     * @return true if the given String contains characters.
     */
    private static boolean isValid(String data) {
        boolean valid = true;
        if(data == null || data.equals("") || data.trim().equals("")) {
            valid = false;
        }
        return valid;
    }
}
