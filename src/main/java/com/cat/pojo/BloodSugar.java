package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class BloodSugar extends AbstractEntity {
    private String sugar;

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }
}
