/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.mediation.storage;

/**
 *
 * @author Fernando.Ocampo
 */
public interface BeneficiaryRepositoryCustom {
    
    int updateBeneficiaryState(String id, Integer state);
}
