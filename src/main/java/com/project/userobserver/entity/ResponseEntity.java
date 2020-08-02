package com.project.userobserver.entity;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseEntity {

    private Integer attendanceQuantity;

    private Integer uniqueUsers;


    private Integer constantUsers;

    public Integer getConstantUsers() {
        return constantUsers;
    }

    public void setConstantUsers(Integer constantUsers) {
        this.constantUsers = constantUsers;
    }

    public Integer getAttendanceQuantity() {
        return attendanceQuantity;
    }

    public void setAttendanceQuantity(Integer attendanceQuantity) {
        this.attendanceQuantity = attendanceQuantity;
    }

    public Integer getUniqueUsers() {
        return uniqueUsers;
    }

    public void setUniqueUsers(Integer uniqueUsers) {
        this.uniqueUsers = uniqueUsers;
    }
}
