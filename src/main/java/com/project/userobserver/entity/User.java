package com.project.userobserver.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_identity")
    private  String userIdentity;

    @OneToMany (mappedBy="user", fetch=FetchType.EAGER)
    private Collection<Attendance> attendances;


    @Column(name = "creation_date")
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public Collection<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Collection<Attendance> attendances) {
        this.attendances = attendances;
    }
}
