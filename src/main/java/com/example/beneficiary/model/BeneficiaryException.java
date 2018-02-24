/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.model;

/**
 * Defines basic behavior for exceptions in beneficiary functionality.
 * 
 * @author Fernando.Ocampo
 */
public class BeneficiaryException extends Exception {
    /**
     * Exception code for the weird behavior.
     */
    private String code;
        
    public BeneficiaryException(String code, String message) {
        super(message);
        this.code = code;
    }
    
    public BeneficiaryException(String code, String message, Throwable ex) {
        super(message, ex);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
