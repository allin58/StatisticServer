package com.project.userobserver.entity;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pages")
public class Page {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "page_identity")
    private  String pageIdentity;

    @OneToMany (mappedBy="page", fetch=FetchType.EAGER)
    private Collection<Attendance> attendances;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPageIdentity() {
        return pageIdentity;
    }

    public void setPageIdentity(String pageIdentity) {
        this.pageIdentity = pageIdentity;
    }

    public Collection<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Collection<Attendance> attendances) {
        this.attendances = attendances;
    }
}
