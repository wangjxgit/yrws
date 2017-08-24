package com.yrws.share.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrws.share.utils.Util;
import com.yrws.share.dao.DiscussMapper;
import com.yrws.share.dao.FollowMapper;
import com.yrws.share.dao.PublishGoodMapper;
import com.yrws.share.dao.UserMapper;
import com.yrws.share.entity.Discuss;
import com.yrws.share.entity.Follow;
import com.yrws.share.entity.PublishGood;
import com.yrws.share.entity.User;
import com.yrws.share.service.ShareService;
import com.yrws.share.view.UserDiscuss;
import com.yrws.share.view.UserPublish;

@Service
@Transactional
public class ShareServiceImpl implements ShareService{
        
        @Autowired
        private UserMapper userMapper;
        @Autowired
        private FollowMapper followMapper;
        @Autowired
        private PublishGoodMapper publishGoodMapper;
        @Autowired
        private DiscussMapper discussMapper;
        

        
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
         //评论列表
          public  List<UserDiscuss> selectCondition(Integer publishId){
                return this.userMapper.selectCondition(publishId);
            }
        //统计评论数
        public int pinCount(Integer publishId){
            return this.selectCondition(publishId).size();
        }
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

        
        
}
