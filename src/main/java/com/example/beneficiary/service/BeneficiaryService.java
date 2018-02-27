/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.service;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.Filter;
import com.example.beneficiary.model.InvalidDataException;
import com.example.beneficiary.model.NotFoundException;
import java.util.List;

/**
 * Defines the business logic for all the operations around a beneficiary.
 * 
 * @author fernando.ocampo
 */
public interface BeneficiaryService {

    /**
     * Search a beneficiary that has the given Id.
     * 
     * @param id
     * @return a beneficiary that has the given Id.
     */
    Beneficiary findById(String id) throws InvalidDataException;
    
    /**
     * Creates a beneficiary in some repository. If 
     * 
     * @param beneficiary data for the beneficiary.
     * @throws InvalidDataException if beneficiary data is invalid.
     */
    void create(Beneficiary beneficiary) throws InvalidDataException;
    
    /**
     * Updates a beneficiary in the repository.
     * 
     * @param beneficiary data to update in the beneficiary.
     * @throws InvalidDataException if beneficiary data is invalid.
     */
    void update(Beneficiary beneficiary) throws InvalidDataException;
    
    /**
     * Deletes a beneficiary from the repository.
     * 
     * @param id from the beneficiary.
     * @throws InvalidDataException if given id is not valid.
     * @throws NotFoundException if a beneficiary with the given Id doesn't exist.
     */
    void delete(String id) throws InvalidDataException, NotFoundException;
    
    /**
     * Search and return a list of beneficiaries that matches the given filters.
     * 
     * @param filter parameters to search the beneficiaries.
     * @return list of beneficiaries.
     * @throws InvalidDataException if the given filter doesn't contain data 
     * or is empty or null.
     */
    List<Beneficiary> search(Filter filter) throws InvalidDataException;
}
