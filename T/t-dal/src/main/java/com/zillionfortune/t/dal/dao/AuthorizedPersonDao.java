package com.zillionfortune.t.dal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zillionfortune.t.dal.entity.AuthorizedPerson;

@Repository
public interface AuthorizedPersonDao {
    int deleteByPrimaryKey(Long id);

    int insert(AuthorizedPerson record);

    int insertSelective(AuthorizedPerson record);

    AuthorizedPerson selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthorizedPerson record);

    int updateByPrimaryKey(AuthorizedPerson record);
    
    int updateByMemberIdSelective(AuthorizedPerson record);
    
    int discardOtherAuthorizedPerson(AuthorizedPerson record);
    
    List<AuthorizedPerson> selectByCriteria(AuthorizedPerson record);
    
    int selectCountByCriteria(AuthorizedPerson record);
    
}