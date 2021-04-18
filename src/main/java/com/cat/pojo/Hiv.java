package com.cat.pojo;

import javax.persistence.Entity;


@Entity
public class Hiv extends AbstractEntity {
    private String hivResult;
    private String rprResult;

    public String getHivResult() {
        return hivResult;
    }

    public void setHivResult(String hivResult) {
        this.hivResult = hivResult;
    }

    public String getRprResult() {
        return rprResult;
    }

    public void setRprResult(String rprResult) {
        this.rprResult = rprResult;
    }
}
