package com.yrws.share.service;

import java.util.List;

import com.yrws.share.entity.Publish;
import com.yrws.share.entity.PublishGood;
import com.yrws.share.entity.Share;
import com.yrws.share.utils.Page;

public interface UserShareService {
    //从表publish中查询单个用户的分享
    List<Share> selectAllByUserName(Page<Share> page);
    //从表publish中查询所有用户的所有分享
    List<Share> selectAll(Page<Share> page);
    
    
    
    
    
    
    
    
    
    //从表publish中查询有多少条数据
    public int count();
    //从表publish_good中查询用户的点赞记录
    List<PublishGood> selectPoint(String username);
    //向表publish_good中添加用户的点赞记录
    void addGood(String user2, Integer id);
    //从表publish_good中查询有多少条记录
    public int countPoint(int id);
    //从表publish_good中删除记录
  	void deletePoint(int id);
  	
  //添加
  	int addPubLishShare(Publish publish);
  	
}
