package com.yrws.chat.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrws.chat.dao.DiscussMapper;
import com.yrws.chat.dao.PublishGoodMapper;
import com.yrws.chat.dao.PublishMapper;
import com.yrws.chat.entity.Discuss;
import com.yrws.chat.entity.PublishGood;
import com.yrws.chat.service.ChatMainService;
import com.yrws.chat.view.UserPublish;

@Service
@Transactional
public class ChatMainServiceImpl implements ChatMainService {
    @Autowired
    private PublishMapper publishMapper;
    @Autowired
    private PublishGoodMapper publishGoodMapper;
    @Autowired
    private DiscussMapper discussMapper;

    public List<UserPublish> selectAll() {
        Date now = new Date();
        List<UserPublish> list = new ArrayList<UserPublish>();
        List<UserPublish> lists = new ArrayList<UserPublish>();
      
        
        for (UserPublish ls : publishMapper.selectAll()) {
            long time = now.getTime() - ls.getNowtime().getTime();
            int ftime = (int) time / 60000;
            String endtime;
            int m=0;
            if (ftime > 60) {
                if ((ftime / 60) > 24) {
                    endtime = ftime / (60 * 24) + "天前";
                } else {
                    endtime = ftime / 60 + "小时前";
                }
            } else {
                endtime = ftime + "分钟前";
            }
            for(PublishGood pg:publishGoodMapper.selectByPrimaryName("you")){
                if(ls.getPublishId()==pg.getPublishId()){
                    lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                    ls.getPublishimg(), ls.getTitle(), ls.getComment(),true));
                    m=1;
                }    
            }
            if(m==0){
               lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                    ls.getPublishimg(), ls.getTitle(), ls.getComment(),false));
            }
        }
        for (int i = lists.size() - 1; i >= 0; i--) {
            list.add(lists.get(i));
        }
        return list;
    }

    public List<UserPublish> selectGoodCount() {
        List<UserPublish> lists = new ArrayList<UserPublish>();
        List<PublishGood> listgoog;
        List<UserPublish> list = new ArrayList<UserPublish>();
        Date now = new Date();
        for (UserPublish ls : publishMapper.selectAll()) {
            long time = now.getTime() - ls.getNowtime().getTime();
            int ftime = (int) time / 60000;
            String endtime;
            int m=0;
            if (ftime > 60) {
                if ((ftime / 60) > 24) {
                    endtime = ftime / (60 * 24) + "天前";
                } else {
                    endtime = ftime / 60 + "小时前";
                }
            } else {
                endtime = ftime + "分钟前";
            }
            listgoog = publishGoodMapper.selectGoodCount(ls.getPublishId());
            for(PublishGood pg:publishGoodMapper.selectByPrimaryName("you")){
                if(ls.getPublishId()==pg.getPublishId()){
                   lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                   ls.getPublishimg(), ls.getTitle(), ls.getComment(),listgoog.size(),true));
                   m=1;
                }
                    
            }
            if(m==0){
                    lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                    ls.getPublishimg(), ls.getTitle(), ls.getComment(),listgoog.size(),false));
            }
            
            Collections.sort(lists);
        }
        for (int i = lists.size() - 1; i >= 0; i--) {
            list.add(lists.get(i));
        }
        return list;
    }
   public List<UserPublish> selectDiscussCount(){
        List<UserPublish> lists = new ArrayList<UserPublish>();
        List<UserPublish> list = new ArrayList<UserPublish>();
        Date now = new Date();
        for (UserPublish ls : publishMapper.selectAll()) {
            long time = now.getTime() - ls.getNowtime().getTime();
            int ftime = (int) time / 60000;
            String endtime;
            int m=0;
            if (ftime > 60) {
                if ((ftime / 60) > 24) {
                    endtime = ftime / (60 * 24) + "天前";
                } else {
                    endtime = ftime / 60 + "小时前";
                }
            } else {
                endtime = ftime + "分钟前";
            }
            List<Discuss> listgoog =  discussMapper.selectDiscussCount(ls.getPublishId());
            for(PublishGood pg:publishGoodMapper.selectByPrimaryName("you")){
                if(ls.getPublishId()==pg.getPublishId()){
                   lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                    ls.getPublishimg(), ls.getTitle(), ls.getComment(),listgoog.size(),true));
                        m=1;
                }
                if(m==0){
                    lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                     ls.getPublishimg(), ls.getTitle(), ls.getComment(),listgoog.size(),false));
                }
            }
            Collections.sort(lists);
        }
        for (int i = lists.size() - 1; i >= 0; i--) {
            list.add(lists.get(i));
        }
        return list;
    }
    public boolean insertGood(PublishGood good) {
        return publishGoodMapper.insert(good) > 0;
    }

    public int delectGood(PublishGood good) {
        return publishGoodMapper.deleteByPrimaryId(good);
    }
}
