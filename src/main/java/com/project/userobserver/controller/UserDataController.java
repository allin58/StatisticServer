package com.project.userobserver.controller;


import com.project.userobserver.entity.ResponseEntity;
import com.project.userobserver.exception.BadDateFormatException;
import com.project.userobserver.service.AttendanceService;
import com.project.userobserver.service.StatisticServise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class UserDataController {

    Logger logger = LoggerFactory.getLogger(UserDataController.class);

    @Autowired
    AttendanceService attendanceService;

    @Autowired
    StatisticServise statisticServise;

    @RequestMapping("/event")
    public ResponseEntity createEvent(@RequestParam(value="userId", required=true) String userId,
                                      @RequestParam(value="pageId", required=true) String pageId) {
        logger.info("new attendance: " + "userId - " + userId + ", pageId - " + pageId );
        return  attendanceService.addAttendance(pageId, userId);
    }

    @RequestMapping("/statistic")
    public ResponseEntity getStatistic(@RequestParam(value="startTime", required=true) String startTime,
                                       @RequestParam(value="endTime", required=true) String endTime) {

        Timestamp startTimestamp = null;
        Timestamp endTimestamp = null;
        try {
            startTimestamp = Timestamp.valueOf(startTime);
            endTimestamp = Timestamp.valueOf(endTime);
        } catch (Exception e) {
            logger.error("Date format is wrong");
            throw new BadDateFormatException();
        }
        logger.info("Statistic was requested");
        return  statisticServise.getStatistic(startTimestamp, endTimestamp);


    }

}
