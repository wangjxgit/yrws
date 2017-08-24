package com.yrws.share.dao;

import com.yrws.share.entity.Follow;

public interface FollowMapper {
    //添加关注
    int addFollow(Follow follow);
    //取消关注
    int deleteFollow(Follow follow);
    //关注回显
    Follow selectLove(Follow follow);
}