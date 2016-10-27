package com.r2.hunter.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class PerformersGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long groupId;

    private String groupName;

    @OneToMany(mappedBy = "group")
    private List<Performer> performers;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
        PerformersGroup group = (PerformersGroup) o;
        return Objects.equals(groupName, group.groupName) &&
                Objects.equals(performers, group.performers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, performers);
    }

}
