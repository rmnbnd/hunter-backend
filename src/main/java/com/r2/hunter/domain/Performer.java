package com.r2.hunter.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Performer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long performerId;

    private String firstName;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    private String lastName;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
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
                Objects.equals(role, performer.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password, resume, role, group, customer);
    }

}
