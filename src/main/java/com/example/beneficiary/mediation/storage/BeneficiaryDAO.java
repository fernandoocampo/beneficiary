/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.mediation.storage;

import com.example.beneficiary.model.Beneficiary;
import java.util.List;

/**
 * Specifies the behavior for beneficiary data persistence.
 * 
 * @author fernando.ocampo
 */
public interface BeneficiaryDAO {
    Beneficiary findOne(Long id);

    List<Beneficiary> findAll();

    void create(Beneficiary entity);

    Beneficiary update(Beneficiary entity);

    void delete(Beneficiary entity);

    void deleteById(Long entityId);
    
    List<Beneficiary> findBeneficiaryByAffiliateId(Long affiliatedId);
}
