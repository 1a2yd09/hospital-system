package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class AntigenAndAntibody extends AbstractEntity {
    private String surfaceAntigen;
    private String surfaceAntibody;

    public String getSurfaceAntigen() {
        return surfaceAntigen;
    }

    public void setSurfaceAntigen(String surfaceAntigen) {
        this.surfaceAntigen = surfaceAntigen;
    }

    public String getSurfaceAntibody() {
        return surfaceAntibody;
    }

    public void setSurfaceAntibody(String surfaceAntibody) {
        this.surfaceAntibody = surfaceAntibody;
    }
}
