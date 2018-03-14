/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.service;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.InvalidDataException;

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
     * @throws InvalidDataException if the given data is not right.
     */
    protected static void checkBeneficiaryData(Beneficiary beneficiary, 
            boolean withID) {
        if(beneficiary == null) {
            throw new InvalidDataException("001","Must provide data for the beneficiary");
        }
        
        if(!isValid(beneficiary.getAffiliateId())) {
            throw new InvalidDataException("002", "Beneficiary must have an affiliate id");
        }
        
        if(!isValid(beneficiary.getCode())) {
            throw new InvalidDataException("003", "Beneficiary must have a code");
        }
        
        if(withID && !isValid(beneficiary.getId())) {
            throw new InvalidDataException("004", "Must provide the id of the beneficiary");
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
    
    /**
     * Return true if the given long is a valid number.
     * @param data String value
     * @return true if the given long contains characters.
     */
    private static boolean isValid(Long data) {
        boolean valid = true;
        if(data == null) {
            valid = false;
        }
        return valid;
    }
}
