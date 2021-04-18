package com.cat.pojo;

import javax.persistence.Entity;

@Entity
public class UrineRoutine extends AbstractEntity {
    private String vitamin;
    private String acidityAndAlkalinity;
    private String leukocytes;
    private String urineSpecificGravity;
    private String glucose;
    private String nitrite;
    private String protein;
    private String occultBlood;
    private String ketoneBody;
    private String urobilinogen;
    private String bilirubin;

    public String getVitamin() {
        return vitamin;
    }

    public void setVitamin(String vitamin) {
        this.vitamin = vitamin;
    }

    public String getAcidityAndAlkalinity() {
        return acidityAndAlkalinity;
    }

    public void setAcidityAndAlkalinity(String acidityAndAlkalinity) {
        this.acidityAndAlkalinity = acidityAndAlkalinity;
    }

    public String getLeukocytes() {
        return leukocytes;
    }

    public void setLeukocytes(String leukocytes) {
        this.leukocytes = leukocytes;
    }

    public String getUrineSpecificGravity() {
        return urineSpecificGravity;
    }

    public void setUrineSpecificGravity(String urineSpecificGravity) {
        this.urineSpecificGravity = urineSpecificGravity;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    public String getNitrite() {
        return nitrite;
    }

    public void setNitrite(String nitrite) {
        this.nitrite = nitrite;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getOccultBlood() {
        return occultBlood;
    }

    public void setOccultBlood(String occultBlood) {
        this.occultBlood = occultBlood;
    }

    public String getKetoneBody() {
        return ketoneBody;
    }

    public void setKetoneBody(String ketoneBody) {
        this.ketoneBody = ketoneBody;
    }

    public String getUrobilinogen() {
        return urobilinogen;
    }

    public void setUrobilinogen(String urobilinogen) {
        this.urobilinogen = urobilinogen;
    }

    public String getBilirubin() {
        return bilirubin;
    }

    public void setBilirubin(String bilirubin) {
        this.bilirubin = bilirubin;
    }
}
