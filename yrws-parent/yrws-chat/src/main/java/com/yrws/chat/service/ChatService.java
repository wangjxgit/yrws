package com.yrws.chat.service;

import java.util.List;
import java.util.Map;

import com.yrws.chat.entity.Discuss;
import com.yrws.chat.entity.Follow;
import com.yrws.chat.entity.Publish;
import com.yrws.chat.entity.PublishGood;
import com.yrws.chat.entity.User;
import com.yrws.chat.view.UserDiscuss;
import com.yrws.chat.view.UserPublish;

public interface ChatService {
      //返回最新列表
      List<UserPublish> selectAll(String name);
      boolean insertGood(PublishGood good);
      int delectGood(PublishGood good);
      //返回最火列表
      List<UserPublish> selectGoodCount(String name);
      //返回最热列表
      List<UserPublish> selectDiscussCount(String name);
      int addPubLishChat(Publish publish);
      
      
      //支鹏宇
    //联查指定帖子+关注回显
      UserPublish selectAll(Integer publishId,Follow follow);
      //评论列表及回显点赞
      List<UserDiscuss> selectCondition(Integer publishId,String name);
      //评论列表
      List<UserDiscuss> selectConditions(Integer publishId);//====
      //添加关注
      int addFollow(Follow follow);
      //取消关注
      int deleteFollow(Follow follow);
      //点赞
      int addGood(PublishGood publishGood);
      //取消点赞
      int deleteGood(PublishGood publishGood);
      //评论数量统计
      int pinCount(Integer publishId);
      //点赞列表
      List<PublishGood> selectGood(Integer publishId);
      //点赞数统计
      int zanCount(Integer publishId);    
      //评论点赞
      int addpGood(PublishGood publishGood);
      //评论取消点赞
      int deletepGood(PublishGood publishGood);
      
      //添加评论
      int addDiscuss(Discuss discuss);
      //添加回复
      public Map<String, Object> insert(String redId, String commentContext, String user1Id, String user2Id,
              String floorTo);
      
      //查询主用户
      User selectByUsername(String username);
}
