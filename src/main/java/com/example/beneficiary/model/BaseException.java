/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.model;

/**
 * Base unchecked exception for all application errors.
 * 
 * @author fernando.ocampo
 */
public class BaseException extends RuntimeException {
    
    /**
     * code to identify the application error.
     */
    private String code;

    public BaseException(String code) {
        this.code = code;
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
