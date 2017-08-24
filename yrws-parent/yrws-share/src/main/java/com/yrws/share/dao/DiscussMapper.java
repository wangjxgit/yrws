package com.yrws.share.dao;

import org.apache.ibatis.annotations.Param;

import com.yrws.share.entity.Discuss;

public interface DiscussMapper {
    //支鹏宇
    //添加评论
    int addDiscuss(Discuss discuss);
    //添加方法
    int insert(Discuss discuss);
    
    String selectSelectFlooer(@Param("publishId")int  publish_id);
    
    //查询评论的方法
    Discuss selectComment(@Param("publishId")int publishId,@Param("discussFloor")String discussFloor);
    
}