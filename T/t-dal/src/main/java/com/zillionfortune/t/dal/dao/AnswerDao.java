package com.zillionfortune.t.dal.dao;

import org.springframework.stereotype.Repository;

import com.zillionfortune.t.dal.entity.Answer;

@Repository
public interface AnswerDao {
    int deleteByPrimaryKey(Long id);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
    
    /**
     * selectBySubjectSerialNoAndAnswerSerialNo:根据问题编号、答案编号查询信息. <br/>
     *
     * @param subjectSerialNo
     * @param answerSerialNo
     * @return
     */
    Answer selectBySubjectSerialNoAndAnswerSerialNo(Integer subjectSerialNo, String answerSerialNo);
    
}