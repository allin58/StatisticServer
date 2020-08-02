package com.project.userobserver.service;

import com.project.userobserver.dao.AttendanceDao;
import com.project.userobserver.dao.PageDao;
import com.project.userobserver.dao.UserDao;
import com.project.userobserver.entity.Attendance;
import com.project.userobserver.entity.Page;
import com.project.userobserver.entity.ResponseEntity;
import com.project.userobserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AttendanceService {

    @Autowired
    UserDao userDao;

    @Autowired
    PageDao pageDao;

    @Autowired
    AttendanceDao attendenceDao;


    public ResponseEntity addAttendance(String pageId, String userId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = new User();
        if(!userDao.existsByUserIdentity(userId)) {
            user.setUserIdentity(userId);
            user.setTimestamp(timestamp);
            userDao.save(user);
        } else {
            user = userDao.findByUserIdentity(userId).get(0);
        }

        Page page = new Page();
        if(!pageDao.existsByPageIdentity(pageId)) {
            page = new Page();
            page.setPageIdentity(pageId);
            pageDao.save(page);
        } else {
            page = pageDao.findByPageIdentity(pageId).get(0);
        }


        Attendance attendance = new Attendance();
        attendance.setUser(user);
        attendance.setPage(page);
        attendance.setTimestamp(timestamp);
        attendenceDao.save(attendance);
        Timestamp startTimestamp = new Timestamp(timestamp.getTime() - 1000 * 60 * 60 * 24);
        Timestamp endTimestamp = timestamp;
        Integer attendenceSize = attendenceDao.findByRangeTimeStamp(startTimestamp, endTimestamp).size();
        Integer uniqueUsersSize = userDao.findByRangeTimeStamp(startTimestamp, endTimestamp).size();
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setUniqueUsers(uniqueUsersSize);
        responseEntity.setAttendanceQuantity(attendenceSize);
        return responseEntity;
    }

}
