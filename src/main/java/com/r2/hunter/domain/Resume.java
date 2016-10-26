package com.r2.hunter.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Resume implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resumeId;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String gender;

    private String country;

    private String city;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Job desiredJob;

    public long getResumeId() {
        return resumeId;
    }

    public void setResumeId(long resumeId) {
        this.resumeId = resumeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(firstName, resume.firstName) &&
                Objects.equals(lastName, resume.lastName) &&
                Objects.equals(birthDate, resume.birthDate) &&
                Objects.equals(gender, resume.gender) &&
                Objects.equals(country, resume.country) &&
                Objects.equals(city, resume.city) &&
                Objects.equals(phone, resume.phone) &&
                Objects.equals(desiredJob, resume.desiredJob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, gender, country, city, phone, desiredJob);
    }

}
