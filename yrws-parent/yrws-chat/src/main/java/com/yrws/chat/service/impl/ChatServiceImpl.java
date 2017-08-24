package com.yrws.chat.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrws.chat.dao.DiscussMapper;
import com.yrws.chat.dao.FollowMapper;
import com.yrws.chat.dao.PublishGoodMapper;
import com.yrws.chat.dao.PublishMapper;
import com.yrws.chat.dao.UserMapper;
import com.yrws.chat.entity.Discuss;
import com.yrws.chat.entity.Follow;
import com.yrws.chat.entity.Publish;
import com.yrws.chat.entity.PublishGood;
import com.yrws.chat.entity.User;
import com.yrws.chat.service.ChatService;
import com.yrws.chat.utils.Util;
import com.yrws.chat.view.UserDiscuss;
import com.yrws.chat.view.UserPublish;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {
    @Autowired
    private PublishMapper publishMapper;
    @Autowired
    private PublishGoodMapper publishGoodMapper;
    @Autowired
    private DiscussMapper discussMapper;
    @Autowired
    private FollowMapper followMapper;
    @Autowired
    private UserMapper userMapper;
    
   
    //添加
    public int addPubLishChat(Publish publish){
            return this.publishMapper.addPubLishChat(publish);
    }
    //最新的列表
    public List<UserPublish> selectAll(String name) {
        
        for (UserPublish ls : publishMapper.selectAll()) {
            System.out.println("********"+ls);
       }
 
        //当前时间
        Date now = new Date();
        List<UserPublish> list = new ArrayList<UserPublish>();
        List<UserPublish> lists = new ArrayList<UserPublish>();
      if(publishMapper.selectAll()!=null){
          
     
        //遍历user表和publish表联查为添加时间字段
        for (UserPublish ls : publishMapper.selectAll()) {
            //时间差
            long time = now.getTime() - ls.getNowtime().getTime();
            int ftime = (int) time / 60000;
            String endtime;
            int m=0;
            if (ftime > 60) {
                if ((ftime / 60) > 24) {
                    //返回天数
                    endtime = ftime / (60 * 24) + "天前";
                } else {
                    //返回小时数
                    endtime = ftime / 60 + "小时前";
                }
            } else {
                //返回分钟数
                endtime = ftime + "分钟前";
            }
            //点赞回显
            //遍历点赞表查询改在线用户师傅对发布的所有信息师傅点赞
            for(PublishGood pg:publishGoodMapper.selectByPrimaryName(name)){
                //用户对该信息已点赞
                if(ls.getPublishId()==pg.getPublishId()){
                    lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                    ls.getPublishImg(), ls.getTitle(), ls.getComment(),true));
                    m=1;
                }    
            }
            //没有被点赞的内容
            if(m==0){
               lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                    ls.getPublishImg(), ls.getTitle(), ls.getComment(),false));
            }
        }//对表进行倒叙，以便在列表界面按时间顺序显示
        for (int i = lists.size() - 1; i >= 0; i--) {
            list.add(lists.get(i));
        }
        return list;}
      return null;
    }
    //最火列表
    public List<UserPublish> selectGoodCount(String name) {
        List<UserPublish> lists = new ArrayList<UserPublish>();
        List<PublishGood> listgoog;
        List<UserPublish> list = new ArrayList<UserPublish>();
        Date now = new Date();
        if(publishMapper.selectAll()!=null){
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
            //通过查询点赞的数量数据的集合的大小
            listgoog = publishGoodMapper.selectGoodCount(ls.getPublishId());
            for(PublishGood pg:publishGoodMapper.selectByPrimaryName(name)){
                if(ls.getPublishId()==pg.getPublishId()){
                   lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                   ls.getPublishImg(), ls.getTitle(), ls.getComment(),listgoog.size(),true));
                   m=1;
                }
                    
            }
            if(m==0){
                    lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                    ls.getPublishImg(), ls.getTitle(), ls.getComment(),listgoog.size(),false));
            }
            
            Collections.sort(lists);
        }
        for (int i = lists.size() - 1; i >= 0; i--) {
            list.add(lists.get(i));
        }
        return list;}
        return null;
    }
    //最热列表
   public List<UserPublish> selectDiscussCount(String name){
        List<UserPublish> lists = new ArrayList<UserPublish>();
        List<UserPublish> list = new ArrayList<UserPublish>();
        Date now = new Date();
        if(publishMapper.selectAll()!=null){
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
            //查询评论表的条数根据评论的条数来进行列表
            List<Discuss> listgoog =  discussMapper.selectDiscussCount(ls.getPublishId());
            for(PublishGood pg:publishGoodMapper.selectByPrimaryName(name)){
                if(ls.getPublishId()==pg.getPublishId()){
                   lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                    ls.getPublishImg(), ls.getTitle(), ls.getComment(),listgoog.size(),true));
                        m=1;
                }  
            }
            if(m==0){
                lists.add(new UserPublish(ls.getPublishId(), ls.getName(), ls.getSex(), ls.getUserimg(), endtime,
                 ls.getPublishImg(), ls.getTitle(), ls.getComment(),listgoog.size(),false));
            }
            Collections.sort(lists);
        }
        for (int i = lists.size() - 1; i >= 0; i--) {
            list.add(lists.get(i));
        }
        return list;}
        return null;
    }
    //向数据库添加点赞
    public boolean insertGood(PublishGood good) {
        return publishGoodMapper.insert(good) > 0;
    }
    //删除点赞
    public int delectGood(PublishGood good) {
        return publishGoodMapper.deleteByPrimaryId(good);
    }
    
    //支鹏宇---------------------------------------------------------------
  //添加关注
    public int addFollow(Follow follow){
        return this.followMapper.addFollow(follow);
    }
    //取消关注
    public int deleteFollow(Follow follow){
        return this.followMapper.deleteFollow(follow);
    }
    //查询是否已赞
    /*public PublishGood selectIfGood(Integer publishId,String usernameGood){
        return this.publishGoodMapper.selectIfGood(publishId,usernameGood);
    }*/
    //点赞
    public int addGood(PublishGood publishGood){
        return this.publishGoodMapper.addGood(publishGood);
    }
    //取消点赞
    public int deleteGood(PublishGood publishGood){
        return this.publishGoodMapper.deleteGood(publishGood);
    }
    //联查指定帖子+关注回显
    public UserPublish selectAll(Integer publishId,Follow follow){
        UserPublish userPublish=userMapper.selectAll(publishId);
        if(followMapper.selectLove(follow)==null){
            if(publishGoodMapper.selectIfGood(new PublishGood(follow.getFromUsername(),publishId))==null){
                return new UserPublish(userPublish.getUsername(), userPublish.getImg(), userPublish.getSex(), userPublish.getName(), userPublish.getPublishId(), userPublish.getPublishTitle(), userPublish.getPublishComment(), userPublish.getPublishImg(), userPublish.getPublishAddress(), userPublish.getPublishDate(), false,false);
            }else {
                return new UserPublish(userPublish.getUsername(), userPublish.getImg(), userPublish.getSex(), userPublish.getName(), userPublish.getPublishId(), userPublish.getPublishTitle(), userPublish.getPublishComment(), userPublish.getPublishImg(), userPublish.getPublishAddress(), userPublish.getPublishDate(), false,true);
            }
        }
        else{
            if(publishGoodMapper.selectIfGood(new PublishGood(follow.getFromUsername(),publishId))==null){
           
                return new UserPublish(userPublish.getUsername(), userPublish.getImg(), userPublish.getSex(), userPublish.getName(), userPublish.getPublishId(), userPublish.getPublishTitle(), userPublish.getPublishComment(), userPublish.getPublishImg(), userPublish.getPublishAddress(), userPublish.getPublishDate(), true,false);  
             }else {
               return new UserPublish(userPublish.getUsername(), userPublish.getImg(), userPublish.getSex(), userPublish.getName(), userPublish.getPublishId(), userPublish.getPublishTitle(), userPublish.getPublishComment(), userPublish.getPublishImg(), userPublish.getPublishAddress(), userPublish.getPublishDate(), true,true);
             }
         }
    }
    //评论列表及回显
    public List<UserDiscuss> selectCondition(Integer publishId ,String name){
        List<UserDiscuss> list=new ArrayList<UserDiscuss>();
        for(UserDiscuss ud: userMapper.selectCondition(publishId)){
            System.out.println(ud.toString());
            if(publishGoodMapper.selectPubGood(new PublishGood(name,ud.getPublishId(),ud.getDiscussId()))==null){
                ud.setGood(false);
                list.add(ud);
            }
            else {
                ud.setGood(true);
                list.add(ud);
            }
        }
        
        System.out.println(list + "xxxxwwww");
        list = improveCommentList(list, publishId);
        
        return list;
        
    }
    //------
     //评论列表
      public  List<UserDiscuss> selectConditions(Integer publishId){//与计数联系和上边的调同一个方法
            return this.userMapper.selectCondition(publishId);
        }
    //统计评论数
    public int pinCount(Integer publishId){
        return this.selectConditions(publishId).size();//联系上边的方法
    }
    //-----
    //点赞列表
    public List<PublishGood> selectGood(Integer publishId){
        return this.publishGoodMapper.selectGood(publishId);
    }
    //点赞数统计
    public int zanCount(Integer publishId){
        return this.selectGood(publishId).size();
    }
    //评论点赞
    public int addpGood(PublishGood publishGood){
        return this.publishGoodMapper.addpGood(publishGood);
    }
    //评论取消点赞
    public int deletepGood(PublishGood publishGood){
        return this.publishGoodMapper.deletepGood(publishGood);
    }
    
    //添加评论
    public int addDiscuss(Discuss discuss){
        
        return this.discussMapper.addDiscuss(discuss);
    }
    
    //插入评论2
    public Map<String, Object> insert(String redId, String commentContext, String user1Id, String user2Id,
            String floorTo) {
        Map<String, Object> map = new HashMap<String, Object>();
        int floor;
        if (redId == null || redId.trim().isEmpty()) {
            floor = 0;
        } else {
            floor = Util.toInt(discussMapper.selectSelectFlooer(Util.toInt(redId)));
        }

        if (user2Id != null && !user2Id.trim().isEmpty() && floorTo != null && !floorTo.trim().isEmpty()) {
            user2Id = floorTo + "|" + user2Id;
        }
        System.out.println(floor + "==floor");
        floor++;
        Discuss comment = new Discuss(Util.toInt(redId), user1Id, user2Id, commentContext, Integer.toString(floor), new Date());
        //进行插入 调用自己的方法
        int i = discussMapper.insert(comment);

        map.put("i", i);
        map.put("comment", comment);
        return map;
    }

    // 计算时间xxxxx等及评论的对象
    private List<UserDiscuss> improveCommentList(List<UserDiscuss> li, Integer userId) {
        // 循环遍历
        for (UserDiscuss di : li) {
            di.setPassTime(Util.toAfterTime(di.getDiscussDate()));
            //如果是评论的评论
            if (di.getDiscussbyUsername() != null && !di.getDiscussbyUsername().trim().isEmpty()) {
                //分割  得到user2_id
                System.out.println(di.getDiscussbyUsername());
                String str = di.getDiscussbyUsername();
                int i = str.indexOf("|");
                String str1 = str.substring(0, i);
                //使用redId和切割后的楼层号找到当前红包唯一对应唯一的评论（你评论的对象）
                Discuss discuss = discussMapper.selectComment(di.getPublishId(), str1);
                di.setRc(discuss);
            }
            //di.setCounts(discussMapper.selectCounts(di.getPublishId(), di.getDiscussFloor()
            //        , "2"));
            //di.setTag(thumbsUpMapper.selectLike(new ThumbsUp(userId, redComment.getFloor()
              //      .toString(), redComment.getRedId(), "2", new Date())));
        }
        return li;
    }
    
    
    //查询主用户信息
    public User selectByUsername(String username){
        return this.userMapper.selectByUsername(username);
    }
    //--------------------------------------------------------------------------
}
