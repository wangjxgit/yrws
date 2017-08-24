package com.yrws.share.dao;

import java.util.List;

import com.yrws.share.entity.Publish;
import com.yrws.share.view.UserPublish;

public interface PublishMapper {
    //支鹏宇
    //指定帖子
    Publish selectById(Integer publishId);
    //评论列表
    List<UserPublish> selectCondition();
  
}