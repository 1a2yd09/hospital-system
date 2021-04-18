package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class Serum extends AbstractEntity {
    private String thyrotropin;

    public String getThyrotropin() {
        return thyrotropin;
    }

    public void setThyrotropin(String thyrotropin) {
        this.thyrotropin = thyrotropin;
    }
}
