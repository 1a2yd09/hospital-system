package com.cat.pojo;

import javax.persistence.Entity;


@Entity
public class Crp extends AbstractEntity {
    private String generalCrpResult;
    private String generalCrpReference;
    private String hsCrpResult;
    private String hsCrpReference;

    public String getGeneralCrpResult() {
        return generalCrpResult;
    }

    public void setGeneralCrpResult(String generalCrpResult) {
        this.generalCrpResult = generalCrpResult;
    }

    public String getGeneralCrpReference() {
        return generalCrpReference;
    }

    public void setGeneralCrpReference(String generalCrpReference) {
        this.generalCrpReference = generalCrpReference;
    }

    public String getHsCrpResult() {
        return hsCrpResult;
    }

    public void setHsCrpResult(String hsCrpResult) {
        this.hsCrpResult = hsCrpResult;
    }

    public String getHsCrpReference() {
        return hsCrpReference;
    }

    public void setHsCrpReference(String hsCrpReference) {
        this.hsCrpReference = hsCrpReference;
    }
}
