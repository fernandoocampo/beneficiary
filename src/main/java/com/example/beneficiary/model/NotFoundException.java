/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.model;

/**
 * Runtime exception thrown when an entity cannot be found for query or 
 * mutation operations.
 * 
 * @author fernando.ocampo
 */
public class NotFoundException extends BaseException {

    public NotFoundException(String code) {
        super(code);
    }

    public NotFoundException(String code, String message) {
        super(code, message);
    }

    public NotFoundException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
    
}
