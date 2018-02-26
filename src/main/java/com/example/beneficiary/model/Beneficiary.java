/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.model;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Models the data used for Beneficiaries.
 * 
 * @author fernando.ocampo
 */
@Document(collection = "beneficiaries")
public class Beneficiary {
    @Id
    private String id;
    @Indexed(unique = true)
    private String code;
    private String forename;
    private String lastname;
    private String relationship;
    private String affiliateId;
    private Integer state;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.code);
        hash = 59 * hash + Objects.hashCode(this.forename);
        hash = 59 * hash + Objects.hashCode(this.lastname);
        hash = 59 * hash + Objects.hashCode(this.relationship);
        hash = 59 * hash + Objects.hashCode(this.affiliateId);
        hash = 59 * hash + Objects.hashCode(this.state);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Beneficiary other = (Beneficiary) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.forename, other.forename)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.relationship, other.relationship)) {
            return false;
        }
        if (!Objects.equals(this.affiliateId, other.affiliateId)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beneficiary{" + "id:" + id + ", code:" + code + ", forename:" + forename + ", lastname:" + lastname + ", relationship:" + relationship + ", affiliateId:" + affiliateId + ", state:" + state + '}';
    }
    
//    public static void main(String[] args) {
//        Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setId("1");
//        beneficiary.setCode("0001");
//        beneficiary.setForename("Fernando");
//        beneficiary.setLastname("Ocampo");
//        beneficiary.setRelationship("Son");
//        beneficiary.setState(1);
//        beneficiary.setAffiliateId("0006");
//        
//        String serialized = new Gson().toJson(beneficiary);
//        
//        System.out.println("> " + serialized);
//        
//        Beneficiary fromJson = new Gson().fromJson(serialized, Beneficiary.class);
//        
//        System.out.println("+ " + fromJson);
//    }
}
