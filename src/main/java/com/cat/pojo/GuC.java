package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class GuC extends AbstractEntity {
    private String glutamicPyruvicTransaminase;

    public String getGlutamicPyruvicTransaminase() {
        return glutamicPyruvicTransaminase;
    }

    public void setGlutamicPyruvicTransaminase(String glutamicPyruvicTransaminase) {
        this.glutamicPyruvicTransaminase = glutamicPyruvicTransaminase;
    }
}
