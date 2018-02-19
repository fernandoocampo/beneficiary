/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.model;

/**
 * Contains data for the allowed filters used to search in beneficiaries.
 * 
 * @author fernando.ocampo
 */
public class Filter {
    /**
     * It is the affiliate id.
     */
    private String affiliateId;

    public String getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }
}
