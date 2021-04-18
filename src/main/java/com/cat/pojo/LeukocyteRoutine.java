package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class LeukocyteRoutine extends AbstractEntity {
    private String cleanliness;
    private String pusBall;
    private String mold;
    private String trichomonas;
    private String gDiplococcus;

    public String getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }

    public String getPusBall() {
        return pusBall;
    }

    public void setPusBall(String pusBall) {
        this.pusBall = pusBall;
    }

    public String getMold() {
        return mold;
    }

    public void setMold(String mold) {
        this.mold = mold;
    }

    public String getTrichomonas() {
        return trichomonas;
    }

    public void setTrichomonas(String trichomonas) {
        this.trichomonas = trichomonas;
    }

    public String getgDiplococcus() {
        return gDiplococcus;
    }

    public void setgDiplococcus(String gDiplococcus) {
        this.gDiplococcus = gDiplococcus;
    }
}
