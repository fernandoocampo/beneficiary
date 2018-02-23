/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.service;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.BeneficiaryException;
import com.example.beneficiary.model.Filter;
import com.example.beneficiary.model.Result;

/**
 * Defines the business logic for all the operations around a beneficiary.
 * 
 * @author fernando.ocampo
 */
public interface BeneficiaryService {
    
    /**
     * Creates a beneficiary in some repository. If 
     * 
     * @param beneficiary data for the beneficiary.
     * @throws BeneficiaryException if something goes wrong.
     */
    void create(Beneficiary beneficiary) throws BeneficiaryException;
    
    /**
     * Updates a beneficiary in the repository.
     * 
     * @param beneficiary data to update in the beneficiary.
     * @throws BeneficiaryException if something goes wrong.
     */
    void update(Beneficiary beneficiary) throws BeneficiaryException;
    
    /**
     * Deletes a beneficiary from the repository.
     * 
     * @param id from the beneficiary.
     * @throws BeneficiaryException if something goes wrong.
     */
    void delete(String id) throws BeneficiaryException;
    
    /**
     * Search and return a list of beneficiaries that matches the given filters.
     * 
     * @param filter parameters to search the beneficiaries.
     * @return list of beneficiaries.
     * @throws BeneficiaryException 
     */
    Result find(Filter filter) throws BeneficiaryException;
}
