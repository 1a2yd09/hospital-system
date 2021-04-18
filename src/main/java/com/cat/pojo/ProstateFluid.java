package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class ProstateFluid extends AbstractEntity {
    private String appearance;
    private String lecithin;
    private String leukocyte;
    private String erythrocyte;
    private String epithelium;

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getLecithin() {
        return lecithin;
    }

    public void setLecithin(String lecithin) {
        this.lecithin = lecithin;
    }

    public String getLeukocyte() {
        return leukocyte;
    }

    public void setLeukocyte(String leukocyte) {
        this.leukocyte = leukocyte;
    }

    public String getErythrocyte() {
        return erythrocyte;
    }

    public void setErythrocyte(String erythrocyte) {
        this.erythrocyte = erythrocyte;
    }

    public String getEpithelium() {
        return epithelium;
    }

    public void setEpithelium(String epithelium) {
        this.epithelium = epithelium;
    }
}
