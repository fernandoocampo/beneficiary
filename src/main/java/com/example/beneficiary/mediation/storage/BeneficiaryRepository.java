/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.mediation.storage;

import com.example.beneficiary.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Specifies the behavior for beneficiary data persistence.
 * 
 * @author fernando.ocampo
 */
@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
}
