package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class Pregnancy extends AbstractEntity {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
