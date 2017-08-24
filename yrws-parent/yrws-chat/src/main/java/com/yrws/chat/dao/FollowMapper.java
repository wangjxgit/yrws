package com.yrws.chat.dao;

import com.yrws.chat.entity.Follow;

public interface FollowMapper {
    //支鹏宇
    //添加关注
    int addFollow(Follow follow);
    //取消关注
    int deleteFollow(Follow follow);
    //关注回显
    Follow selectLove(Follow follow);
    
    
    
    int insert(Follow record);

    int insertSelective(Follow record);
}