package com.r2.hunter.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Performer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long performerId;

    private String firstName;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    private Date birthDate;

    private String gender;

    private String lastName;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    @OneToMany(mappedBy = "performer")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    public long getPerformerId() {
        return performerId;
    }

    public void setPerformerId(long performerId) {
        this.performerId = performerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Performer performer = (Performer) o;
        return Objects.equals(firstName, performer.firstName) &&
                Objects.equals(lastName, performer.lastName) &&
                Objects.equals(email, performer.email) &&
                Objects.equals(password, performer.password) &&
                Objects.equals(resume, performer.resume) &&
                Objects.equals(group, performer.group) &&
                Objects.equals(customer, performer.customer) &&
                Objects.equals(birthDate, performer.birthDate) &&
                Objects.equals(gender, performer.gender) &&
                Objects.equals(role, performer.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password, resume, role, group, customer, birthDate, gender);
    }

}
