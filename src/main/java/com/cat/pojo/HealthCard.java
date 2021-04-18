package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class HealthCard extends AbstractEntity {
    private String antigen;
    private String antibody;
    private String eAntigen;
    private String eAntibody;
    private String coreAntibody;
    private String hepatitis;

    public String getAntigen() {
        return antigen;
    }

    public void setAntigen(String antigen) {
        this.antigen = antigen;
    }

    public String getAntibody() {
        return antibody;
    }

    public void setAntibody(String antibody) {
        this.antibody = antibody;
    }

    public String geteAntigen() {
        return eAntigen;
    }

    public void seteAntigen(String eAntigen) {
        this.eAntigen = eAntigen;
    }

    public String geteAntibody() {
        return eAntibody;
    }

    public void seteAntibody(String eAntibody) {
        this.eAntibody = eAntibody;
    }

    public String getCoreAntibody() {
        return coreAntibody;
    }

    public void setCoreAntibody(String coreAntibody) {
        this.coreAntibody = coreAntibody;
    }

    public String getHepatitis() {
        return hepatitis;
    }

    public void setHepatitis(String hepatitis) {
        this.hepatitis = hepatitis;
    }
}
