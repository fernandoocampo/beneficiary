/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.service;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.model.Filter;
import com.example.beneficiary.model.InvalidDataException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.beneficiary.mediation.storage.BeneficiaryRepository;
import java.util.ArrayList;

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
    public Beneficiary findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void create(Beneficiary beneficiary) {
        BeneficiaryServiceHelper.checkBeneficiaryData(beneficiary, false);
        beneficiary.setState(1);
        dao.save(beneficiary);
    }

    @Override
    public void update(Beneficiary beneficiary) {
        BeneficiaryServiceHelper.checkBeneficiaryData(beneficiary, true);        
        dao.save(beneficiary);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Beneficiary> search(Filter filter) {
        if(filter == null || filter.getAffiliateId() == null || 
                filter.getAffiliateId().equals("")) {
            throw new InvalidDataException("001", "Must provide a valid filter");
        }
        return dao.findAll();
    }
}
