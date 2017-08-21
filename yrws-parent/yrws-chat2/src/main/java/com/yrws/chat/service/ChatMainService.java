package com.yrws.chat.service;

import java.util.List;

import com.yrws.chat.entity.PublishGood;
import com.yrws.chat.view.UserPublish;

public interface ChatMainService {
      List<UserPublish> selectAll();
      boolean insertGood(PublishGood good);
      int delectGood(PublishGood good);
      List<UserPublish> selectGoodCount();
      List<UserPublish> selectDiscussCount();
}
