package com.yrws.chat.dao;

import java.util.List;

import com.yrws.chat.entity.User;
import com.yrws.chat.view.UserDiscuss;
import com.yrws.chat.view.UserPublish;

public interface UserMapper {
    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //支鹏宇
    //主用户信息
    User selectByUsername(String username);
    //详情上部联查
    UserPublish selectAll(Integer publishId);
    //评论联查
    List<UserDiscuss> selectCondition(Integer publishId);
}