package com.yrws.chat.dao;

import java.util.List;
import com.yrws.chat.entity.Publish;
import com.yrws.chat.view.UserPublish;

public interface PublishMapper {
    int deleteByPrimaryKey(Integer publishId);

    int insert(Publish record);

    int insertSelective(Publish record);

    Publish selectByPrimaryKey(Integer publishId);

    int updateByPrimaryKeySelective(Publish record);
    int updateByPrimaryKey(Publish record);
    List<UserPublish> selectAll();
    int addPubLishChat(Publish publish);
    
    //支鹏宇
    //指定帖子
    Publish selectById(Integer publishId);
    //评论列表
    List<UserPublish> selectCondition();
}