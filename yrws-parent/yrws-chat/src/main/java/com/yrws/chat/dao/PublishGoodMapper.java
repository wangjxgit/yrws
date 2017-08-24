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
    //
    List<PublishGood> selectGoodCount(Integer publishId);
    //
    List<PublishGood> selectByPrimaryName(String usernameGood);
    
    //支鹏宇
  //检查是否已赞
    PublishGood selectIfGood(PublishGood publishGood);
    //点赞
    int addGood(PublishGood publishGood);
    //取消点赞
    int deleteGood(PublishGood publishGood);
    //点赞列表
    List<PublishGood> selectGood(Integer publishId);
    //评论点赞
    int addpGood(PublishGood publishGood);
    //评论取消点赞
    int deletepGood(PublishGood publishGood);
    //
    PublishGood selectPubGood(PublishGood publishGood);

}