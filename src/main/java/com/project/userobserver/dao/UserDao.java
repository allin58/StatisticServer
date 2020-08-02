package com.project.userobserver.dao;

import com.project.userobserver.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    boolean existsByUserIdentity(String userIdentity);

    List<User> findByUserIdentity(String userIdentity);

    @Query("from User b where b.timestamp >= :startTimestamp and b.timestamp <= :endTimeStamp ")
    List<User> findByRangeTimeStamp(@Param("startTimestamp") Timestamp startTimestamp,
                                    @Param("endTimeStamp") Timestamp endTimeStamp);

}

