package com.r2.hunter.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Resume implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resumeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "performerId")
    private Performer performer;

    private String country;

    private String city;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobId")
    private Job desiredJob;

    public long getResumeId() {
        return resumeId;
    }

    public void setResumeId(long resumeId) {
        this.resumeId = resumeId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Job getDesiredJob() {
        return desiredJob;
    }

    public void setDesiredJob(Job desiredJob) {
        this.desiredJob = desiredJob;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(country, resume.country) &&
                Objects.equals(city, resume.city) &&
                Objects.equals(phone, resume.phone) &&
                Objects.equals(performer, resume.performer) &&
                Objects.equals(desiredJob, resume.desiredJob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, phone, desiredJob, performer);
    }

}
