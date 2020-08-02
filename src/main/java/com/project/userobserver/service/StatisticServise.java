package com.project.userobserver.service;

import com.project.userobserver.dao.AttendanceDao;
import com.project.userobserver.dao.PageDao;
import com.project.userobserver.dao.UserDao;
import com.project.userobserver.entity.Attendance;
import com.project.userobserver.entity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StatisticServise {

    @Autowired
    UserDao userDao;

    @Autowired
    PageDao pageDao;

    @Autowired
    AttendanceDao attendenceDao;

    public ResponseEntity getStatistic(Timestamp startTimestamp, Timestamp endTimestamp) {

        List<Attendance> attendances = attendenceDao.findByRangeTimeStamp(startTimestamp, endTimestamp);
        Integer attendenceSize  =attendances.size();
        Integer uniqueUsersSize = userDao.findByRangeTimeStamp(startTimestamp, endTimestamp).size();
        Map<String, Set<String>> userStatistic = new HashMap<>();
        for (Attendance attendance : attendances) {
            String userIdentity = attendance.getUser().getUserIdentity();
            if(userStatistic.containsKey(userIdentity)) {
                userStatistic.get(userIdentity).add(attendance.getPage().getPageIdentity());
            } else {
                HashSet<String> pageIdentities = new HashSet<>();
                pageIdentities.add(attendance.getPage().getPageIdentity());
                userStatistic.put(userIdentity,pageIdentities);
            }
        }

        AtomicInteger constantUsers = new AtomicInteger();
        userStatistic.forEach((k, v) -> { if(v.size() >= 10) {
            constantUsers.getAndIncrement();} });


        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setUniqueUsers(uniqueUsersSize);
        responseEntity.setAttendanceQuantity(attendenceSize);
        responseEntity.setConstantUsers(constantUsers.get());
        return responseEntity;
    }


}
