package com.r2.hunter.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vacancy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vacancyId;

    private String vacancyName;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "vacancies_performers",
            joinColumns = @JoinColumn(name = "vacancy_id"),
            inverseJoinColumns = @JoinColumn(name = "performer_id"))
    private List<Performer> performers;

    private String country;

    private String city;

    private int salary;

    private int requiredExperienceYears;

    private String description;

    private String employmentType;

    public long getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(long vacancyId) {
        this.vacancyId = vacancyId;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getRequiredExperienceYears() {
        return requiredExperienceYears;
    }

    public void setRequiredExperienceYears(int requiredExperienceYears) {
        this.requiredExperienceYears = requiredExperienceYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return salary == vacancy.salary &&
                requiredExperienceYears == vacancy.requiredExperienceYears &&
                Objects.equals(vacancyName, vacancy.vacancyName) &&
                Objects.equals(country, vacancy.country) &&
                Objects.equals(city, vacancy.city) &&
                Objects.equals(description, vacancy.description) &&
                Objects.equals(customer, vacancy.customer) &&
                Objects.equals(performers, vacancy.performers) &&
                Objects.equals(employmentType, vacancy.employmentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacancyName, country, city, salary, requiredExperienceYears,
                description, employmentType, customer, performers);
    }

}
