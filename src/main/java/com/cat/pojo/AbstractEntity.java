package com.cat.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {
    private Long id;
    private String patientName;
    private String patientGender;
    private String patientAge;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate reportingTime;
    private String sendingDoctor;
    private String department;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate collectingTime;
    private String phoneNumber;
    private LocalDateTime createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public LocalDate getReportingTime() {
        return reportingTime;
    }

    public void setReportingTime(LocalDate reportingTime) {
        this.reportingTime = reportingTime;
    }

    public String getSendingDoctor() {
        return sendingDoctor;
    }

    public void setSendingDoctor(String sendingDoctor) {
        this.sendingDoctor = sendingDoctor;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getCollectingTime() {
        return collectingTime;
    }

    public void setCollectingTime(LocalDate collectingTime) {
        this.collectingTime = collectingTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    public void preInsert() {
        this.setCreatedAt(LocalDateTime.now());
    }
}
