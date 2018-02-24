/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.mediation.storage;

import com.example.beneficiary.model.Beneficiary;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 *
 * @author Fernando.Ocampo
 */
public class BeneficiaryRepositoryImpl implements BeneficiaryRepositoryCustom {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int updateBeneficiaryState(String id, Integer state) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("state",state);
        
        WriteResult result = mongoTemplate.updateFirst(query, update, Beneficiary.class);
        
        if(result != null) {
            return result.getN();
        }
        return 0;
    }
    
}
