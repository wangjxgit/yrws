package com.yrws.share.dao;

import java.util.List;

import com.yrws.share.entity.PublishGood;

public interface PublishGoodMapper {
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
    
    PublishGood selectPubGood(PublishGood publishGood);
    
}