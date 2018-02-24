/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.service;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.Filter;
import com.example.beneficiary.model.Result;
import java.util.List;

/**
 * Defines the business logic for all the operations around a beneficiary.
 * 
 * @author fernando.ocampo
 */
public interface BeneficiaryService {
    
    /**
     * 
     * @param filter
     * @return 
     */
    List<Beneficiary> search(Filter filter);
    
    /**
     * 
     * @param id
     * @return 
     */
    Beneficiary findById(String id);
    
    /**
     * 
     * @param beneficiary
     * @return 
     */
    Result create(Beneficiary beneficiary);
    
    /**
     * 
     * @param beneficiary
     * @return 
     */
    Result update(Beneficiary beneficiary);
        
    /**
     * 
     * @param id
     * @return 
     */
    Result delete(String id);
}
