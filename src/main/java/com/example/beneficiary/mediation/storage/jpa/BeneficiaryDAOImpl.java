/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.mediation.storage.jpa;

import com.example.beneficiary.mediation.storage.BeneficiaryDAO;
import com.example.beneficiary.model.Beneficiary;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO implementation for beneficiary entity using jpa.
 * 
 * @author fernando.ocampo
 */
@Repository
public class BeneficiaryDAOImpl extends AbstractJpaDAO<Beneficiary> implements BeneficiaryDAO {
    
    public BeneficiaryDAOImpl() {
        super();

        setClazz(Beneficiary.class);
    }

    @Override
    public List<Beneficiary> findBeneficiaryByAffiliateId(Long affiliatedId) {
        return null;
    }
    
}
