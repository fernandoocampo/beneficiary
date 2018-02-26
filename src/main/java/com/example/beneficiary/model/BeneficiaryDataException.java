/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.model;

/**
 * Identifies data validation exceptions.
 * 
 * @author Fernando.Ocampo
 */
public class BeneficiaryDataException extends BeneficiaryException {
    
    public BeneficiaryDataException(String code, String message) {
        super(code, message);
    }

    public BeneficiaryDataException(String code, String message, Throwable ex) {
        super(code, message, ex);
    }
    
}
