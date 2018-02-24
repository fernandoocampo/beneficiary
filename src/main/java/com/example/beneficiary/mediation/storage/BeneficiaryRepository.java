/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.mediation.storage;

import com.example.beneficiary.model.Beneficiary;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Specifies the behavior for beneficiary persistence operations.
 * 
 * @author fernando.ocampo
 */
public interface BeneficiaryRepository 
        extends MongoRepository<Beneficiary, String>, BeneficiaryRepositoryCustom {
    
    Beneficiary findBeneficiaryById(String id);
    
    @Query("{affiliateId:'?0'")
    List<Beneficiary> findBeneficiaryByAffiliateId(String affiliateId);
    
    
}
