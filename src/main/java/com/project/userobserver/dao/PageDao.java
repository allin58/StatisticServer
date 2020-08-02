package com.project.userobserver.dao;

import com.project.userobserver.entity.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageDao  extends CrudRepository<Page, Integer> {

    boolean existsByPageIdentity(String pageIdentity);

    List<Page> findByPageIdentity(String pageIdentity);
}
