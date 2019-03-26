package com.zillionfortune.t.dal.dao;


import org.springframework.stereotype.Repository;

import com.zillionfortune.t.dal.entity.Subject;

@Repository
public interface SubjectDao {
    int deleteByPrimaryKey(Long id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}