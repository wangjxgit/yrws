package com.yrws.chat.dao;

import java.util.List;

import com.yrws.chat.entity.PublishGood;

public interface PublishGoodMapper {
    int deleteByPrimaryKey(Integer goodId);

    int deleteByPrimaryId(PublishGood record);
    
    int insert(PublishGood record);

    int insertSelective(PublishGood record);

    PublishGood selectByPrimaryKey(Integer goodId);

    int updateByPrimaryKeySelective(PublishGood record);

    int updateByPrimaryKey(PublishGood record);
   
    List<PublishGood> selectGoodCount(Integer publishId);
    
    List<PublishGood> selectByPrimaryName(String usernameGood);
}