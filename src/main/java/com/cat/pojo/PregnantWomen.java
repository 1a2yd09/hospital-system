package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class PregnantWomen extends AbstractEntity {
    private String bloodType;
    private String rh;
    private String hbsag;
    private String hbsab;
    private String rpr;
    private String hepatitis;
    private String hiv;

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getHbsag() {
        return hbsag;
    }

    public void setHbsag(String hbsag) {
        this.hbsag = hbsag;
    }

    public String getHbsab() {
        return hbsab;
    }

    public void setHbsab(String hbsab) {
        this.hbsab = hbsab;
    }

    public String getRpr() {
        return rpr;
    }

    public void setRpr(String rpr) {
        this.rpr = rpr;
    }

    public String getHepatitis() {
        return hepatitis;
    }

    public void setHepatitis(String hepatitis) {
        this.hepatitis = hepatitis;
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }
}
