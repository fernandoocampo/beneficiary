/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.service;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.BeneficiaryDataException;
import com.example.beneficiary.model.Filter;
import java.util.List;

/**
 * Defines the business logic for all the operations around a beneficiary.
 * 
 * @author fernando.ocampo
 */
public interface BeneficiaryService {

    /**
     * 
     * @param id
     * @return 
     */
    Beneficiary findById(String id);
    
    /**
     * Creates a beneficiary in some repository. If 
     * 
     * @param beneficiary data for the beneficiary.
     * @throws BeneficiaryException if something goes wrong.
     */
    void create(Beneficiary beneficiary) throws BeneficiaryDataException;
    
    /**
     * Updates a beneficiary in the repository.
     * 
     * @param beneficiary data to update in the beneficiary.
     * @throws BeneficiaryException if something goes wrong.
     */
    void update(Beneficiary beneficiary) throws BeneficiaryDataException;
    
    /**
     * Deletes a beneficiary from the repository.
     * 
     * @param id from the beneficiary.
     * @throws BeneficiaryException if something goes wrong.
     */
    void delete(String id) throws BeneficiaryDataException;
    
    /**
     * Search and return a list of beneficiaries that matches the given filters.
     * 
     * @param filter parameters to search the beneficiaries.
     * @return list of beneficiaries.
     * @throws BeneficiaryException 
     */
    List<Beneficiary> search(Filter filter) throws BeneficiaryDataException;
}
