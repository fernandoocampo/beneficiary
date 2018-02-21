/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.model;

/**
 * Models the data used for Beneficiaries.
 * 
 * @author fernando.ocampo
 */
public class Beneficiary {
    private String id;
    private String code;
    private String forename;
    private String lastname;
    private String relationship;
    private String affiliateId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", code=" + code + ", forename=" + forename + ", lastname=" + lastname + ", relationship=" + relationship + ", affiliateId=" + affiliateId + '}';
    }
    
    public static void main(String[] args) {
        System.out.println(new Beneficiary());
    }
}
