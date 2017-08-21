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
}