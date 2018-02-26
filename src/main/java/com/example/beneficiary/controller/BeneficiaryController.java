/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.controller;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.BeneficiaryException;
import com.example.beneficiary.model.Filter;
import com.example.beneficiary.model.Result;
import com.example.beneficiary.service.BeneficiaryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    private BeneficiaryService service;
    
    @RequestMapping(value = "", method = RequestMethod.GET, 
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> search(@RequestBody Filter filter) {
        Result<List<Beneficiary>> response = new Result();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            List<Beneficiary> data = service.search(filter);
            response.setData(data);
        } catch (BeneficiaryException ex) {
            response.setCode(ex.getCode());
            response.setMessage(ex.getMessage());
            response.setData(new ArrayList<>());
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, responseStatus);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Result> getBeneficiary(@PathVariable String id) {
        Result<Beneficiary> response = new Result();
        Beneficiary data = service.findById(id);
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, 
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> create(@RequestBody Beneficiary beneficiary) {
        Result<Beneficiary> response = new Result();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            service.create(beneficiary);
        } catch (BeneficiaryException ex) {
            response.setCode(ex.getCode());
            response.setMessage(ex.getMessage());
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, responseStatus);
    }
    
    @RequestMapping(value = "", method = RequestMethod.PUT, 
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> update(@RequestBody Beneficiary beneficiary) {
        Result<Beneficiary> response = new Result();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            service.update(beneficiary);
        } catch (BeneficiaryException ex) {
            response.setCode(ex.getCode());
            response.setMessage(ex.getMessage());
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, responseStatus);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Result> delete(@PathVariable String id) {
        Result response = new Result();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            service.delete(id);
        } catch (BeneficiaryException ex) {
            response.setCode(ex.getCode());
            response.setMessage(ex.getMessage()); 
            response.setData(new ArrayList<>());
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, responseStatus);
    }
}
