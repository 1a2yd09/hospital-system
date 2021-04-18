package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class Feces extends AbstractEntity {
    private String fecesColor;
    private String fecesShape;
    private String fecesMucus;
    private String fecesPusBall;
    private String occultBlood;

    public String getFecesColor() {
        return fecesColor;
    }

    public void setFecesColor(String fecesColor) {
        this.fecesColor = fecesColor;
    }

    public String getFecesShape() {
        return fecesShape;
    }

    public void setFecesShape(String fecesShape) {
        this.fecesShape = fecesShape;
    }

    public String getFecesMucus() {
        return fecesMucus;
    }

    public void setFecesMucus(String fecesMucus) {
        this.fecesMucus = fecesMucus;
    }

    public String getFecesPusBall() {
        return fecesPusBall;
    }

    public void setFecesPusBall(String fecesPusBall) {
        this.fecesPusBall = fecesPusBall;
    }

    public String getOccultBlood() {
        return occultBlood;
    }

    public void setOccultBlood(String occultBlood) {
        this.occultBlood = occultBlood;
    }
}
