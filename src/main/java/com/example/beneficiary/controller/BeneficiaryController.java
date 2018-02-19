/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.controller;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.Result;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * It is a REST interface to expose Beneficiary functionalities to the external 
 * world.
 * 
 * @author fernando.ocampo
 */
@RestController
@RequestMapping("/beneficiaries")
public class BeneficiaryController {
    
    @RequestMapping(value = "", method = RequestMethod.POST, 
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> create(@RequestBody Beneficiary beneficiary) {
        return null;
    }
}
