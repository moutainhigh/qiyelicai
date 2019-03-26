package com.zillionfortune.t.dal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zillionfortune.t.dal.entity.Score;

@Repository
public interface ScoreDao {
    int deleteByPrimaryKey(Long id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
    
    List<Score> selectByCriteria(Score record);
    
	int updateByMemberIdSelective(Score record);
}