package com.project.userobserver.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="user_id")
    private User user;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="page_id")
    private Page page;

    @Column(name = "date")
    private Timestamp timestamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
