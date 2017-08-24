package com.yrws.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrws.chat.entity.Discuss;

public interface DiscussMapper {
    int deleteByPrimaryKey(Integer discussId);

    //int insert(Discuss record);

    int insertSelective(Discuss record);

    Discuss selectByPrimaryKey(Integer discussId);

    int updateByPrimaryKeySelective(Discuss record);

    int updateByPrimaryKey(Discuss record);
    
    List<Discuss> selectDiscussCount(Integer discussId);
    
    //支鹏宇
    //添加评论
    int addDiscuss(Discuss discuss);
    //添加方法
    int insert(Discuss discuss);
    //
    String selectSelectFlooer(@Param("publishId")int  publish_id);
    //查询评论的方法
    Discuss selectComment(@Param("publishId")int publishId,@Param("discussFloor")String discussFloor);
}