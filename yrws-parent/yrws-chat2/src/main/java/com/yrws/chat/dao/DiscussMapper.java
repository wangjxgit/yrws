package com.yrws.chat.dao;

import java.util.List;

import com.yrws.chat.entity.Discuss;

public interface DiscussMapper {
    int deleteByPrimaryKey(Integer discussId);

    int insert(Discuss record);

    int insertSelective(Discuss record);

    Discuss selectByPrimaryKey(Integer discussId);

    int updateByPrimaryKeySelective(Discuss record);

    int updateByPrimaryKey(Discuss record);
    
    List<Discuss> selectDiscussCount(Integer discussId);
}