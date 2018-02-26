/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.service;

import com.example.beneficiary.mediation.storage.BeneficiaryRepository;
import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.BeneficiaryDataException;
import com.example.beneficiary.model.Filter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements basic business logic for beneficiary service. It makes use of a
 * database template to store and retrieve information about beneficiaries.
 * 
 * @author fernando.ocampo
 */
@Service
public class BasicBeneficiaryService implements BeneficiaryService {
    
    @Autowired
    private BeneficiaryRepository dao;

    @Override
    public Beneficiary findById(String id) {
        return dao.findBeneficiaryById(id);
    }

    @Override
    public void create(Beneficiary beneficiary) throws BeneficiaryDataException {
        BeneficiaryServiceHelper.checkBeneficiaryData(beneficiary, false);
        beneficiary.setState(1);
        dao.insert(beneficiary);
    }

    @Override
    public void update(Beneficiary beneficiary) throws BeneficiaryDataException {
        BeneficiaryServiceHelper.checkBeneficiaryData(beneficiary, true);        
        dao.save(beneficiary);
    }

    @Override
    public void delete(String id) throws BeneficiaryDataException {
        dao.delete(id);
    }

    @Override
    public List<Beneficiary> search(Filter filter) throws BeneficiaryDataException {
        if(filter == null || filter.getAffiliateId() == null || 
                filter.getAffiliateId().equals("")) {
            throw new BeneficiaryDataException("001", "Must provide a valid filter");
        }
        return dao.findBeneficiaryByAffiliateId(filter.getAffiliateId());
    }
}
