/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.mediation.storage;

import com.example.beneficiary.model.Beneficiary;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Specifies the behavior for beneficiary data persistence.
 * 
 * @author fernando.ocampo
 */
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
    
    List<Beneficiary> findBeneficiariesByAffiliateId(Long affiliateId);
}
