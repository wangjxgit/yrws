package com.yrws.chat.dao;

import com.yrws.chat.entity.Follow;

public interface FollowMapper {
    int insert(Follow record);

    int insertSelective(Follow record);
}