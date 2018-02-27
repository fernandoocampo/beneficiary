/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.model;

/**
 * Signals that an argument's value is illegal or inappropriate.
 * 
 * @author fernando.ocampo
 */
public class InvalidDataException extends BaseException {

    public InvalidDataException(String code) {
        super(code);
    }

    public InvalidDataException(String code, String message) {
        super(code, message);
    }

    public InvalidDataException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
    
}
