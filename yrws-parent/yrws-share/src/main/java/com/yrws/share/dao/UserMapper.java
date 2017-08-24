package com.yrws.share.dao;

import java.util.List;

import com.yrws.share.entity.User;
import com.yrws.share.view.UserDiscuss;
import com.yrws.share.view.UserPublish;

public interface UserMapper {

    //支鹏宇
    //
    User selectByUsername(String username);
    //详情上部联查
    UserPublish selectAll(Integer publishId);
    //评论联查
    List<UserDiscuss> selectCondition(Integer publishId);
    
}