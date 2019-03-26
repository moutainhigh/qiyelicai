package com.zillionfortune.t.dal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zillionfortune.t.dal.entity.GradeScore;

@Repository
public interface GradeScoreDao {
    int deleteByPrimaryKey(Integer id);

    int insert(GradeScore record);

    int insertSelective(GradeScore record);

    GradeScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GradeScore record);

    int updateByPrimaryKey(GradeScore record);
    
    List<GradeScore> selectByCriteria(GradeScore recode);
    
    /**
     * selectByTotalScore:根据总得分查询等级信息. <br/>
     *
     * @param score
     * @return
     */
    GradeScore selectByTotalScore(Integer totalScore);
}