package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class Glycation extends AbstractEntity {
    private String hemoglobin;

    public String getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin;
    }
}
