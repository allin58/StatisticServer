package com.project.userobserver.dao;

import com.project.userobserver.entity.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface AttendanceDao extends CrudRepository<Attendance, Integer> {

    @Query("from Attendance b where b.timestamp >= :startTimestamp and b.timestamp <= :endTimeStamp ")
    List<Attendance> findByRangeTimeStamp(@Param("startTimestamp") Timestamp startTimestamp,
                                          @Param("endTimeStamp") Timestamp endTimeStamp);



}
