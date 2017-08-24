package com.yrws.share.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yrws.share.utils.Util;
import com.yrws.share.view.UserPublish;
import com.yrws.share.entity.Discuss;
import com.yrws.share.entity.Follow;
import com.yrws.share.entity.PublishGood;
import com.yrws.share.service.ShareService;

@Controller
public class ShareController {
    @Autowired
    private ShareService shareService;
   
  //进入详情页面
    @RequestMapping("go")
    public ModelAndView selectById(HttpServletRequest request, ModelAndView mv, Integer publishId,String username) {
        mv.addObject("basepath",
                request.getScheme() + "://" + request.getHeader("Host") + request.getContextPath());// 获取路径
       
        //联查指定帖子+关注回显
        //mv.addObject("lian", this.shareService.selectAll(1,new Follow("模拟主用户", "公子小白")));
        UserPublish listup = shareService.selectAll(publishId,new Follow("模拟主用户", "公子小白"));
        String[] str = null;
        if( listup.getPublishImg() !=null){
            str = listup.getPublishImg().toString().split(",");
            listup.setPublishImg(str[0]);;
        }
        mv.addObject("lian", listup);
        //System.out.println(chatInfoService.selectAll(1,new Follow("模拟主用户", "公子小白")).isPubGood());
        //评论列表联查
        mv.addObject("lie", this.shareService.selectCondition(publishId,"模拟主用户"));
        System.out.println(shareService.selectCondition(publishId,"模拟主用户"));
        //统计评论数
        mv.addObject("pcount", this.shareService.pinCount(publishId));
        //统计点赞数
        mv.addObject("zcount", this.shareService.zanCount(publishId));
        //主用户信息查询
        mv.addObject("users",this.shareService.selectByUsername("模拟主用户"));
        // 跳转的页面
        mv.setViewName("share/shareInfo");
        return mv;
    }
    //关注
    
    @RequestMapping(value = "follows", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addFollow(String from_usetrname, String to_username, ModelAndView mv) {
        Follow follow = new Follow(from_usetrname, to_username);
        boolean b = this.shareService.addFollow(follow) > 0;
        if (b) {
            mv.setViewName("share/shareInfo");
            return mv;
        } else {
            return mv;
        }
    }
    //取消关注
    @RequestMapping(value = "deletefollow", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deleteFollow(String from_usetrname, String to_username, ModelAndView mv) {
        Follow follow = new Follow(from_usetrname, to_username);
        System.out.println("1233"+follow);
        boolean b = this.shareService.deleteFollow(follow) > 0;
        if (b) {
            mv.setViewName("share/shareInfo");
            return mv;
        } else {
            return mv;
        }
    }
    
    //点赞
    @RequestMapping(value = "good", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addGood(String username_good, int publish_id, ModelAndView mv) {
        PublishGood publishGood = new PublishGood(username_good,publish_id);
        boolean b = this.shareService.addGood(publishGood) > 0;
        if (b) {
            mv.setViewName("share/shareInfo");
            return mv;
        } else {
            return mv;
        }
    }
    //取消点赞
    @RequestMapping(value = "deletegood", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deleteGood(String username_good, int publish_id, ModelAndView mv) {
        PublishGood publishGood = new PublishGood(username_good,publish_id);
        boolean b = this.shareService.deleteGood(publishGood) > 0;
        if (b) {
            mv.setViewName("share/shareInfo");
            return mv;
        } else {
            return mv;
        }
    }
    //添加评论
    @RequestMapping(value="addDiscuss")
    @ResponseBody
    public Map<String,Object> addDiscuss(String discusses,String publish_id,String discussby_username,String discuss_comment,String discuss_floor,Date discuss_date){
        Map<String, Object> map = new HashMap<String, Object>();
        discuss_date= new Date();
        System.out.println(2222);
        
        Discuss discuss = new Discuss(Util.toInt(discusses), "模拟主用户", discussby_username, discuss_comment,discuss_floor,discuss_date);
        shareService.insert(discusses, discuss_comment , "模拟主用户", discussby_username, discuss_floor);
        System.out.println("----------------"+discuss);
        map.put("discusses", discuss);
        System.out.println(1111);
        return map;
    }
    
    //评论点赞
    @RequestMapping(value = "pgood", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addpGood(String username_good,int publish_id, int discuss_id, ModelAndView mv) {
        PublishGood publishGood = new PublishGood(username_good,publish_id,discuss_id);
        boolean b = this.shareService.addpGood(publishGood) > 0;
        if (b) {
            mv.setViewName("share/shareInfo");
            return mv;
        } else {
            return mv;
        }
    }
        //评论取消点赞
        @RequestMapping(value = "pdeletegood", method = RequestMethod.POST)
        @ResponseBody
        public ModelAndView deletepGood(String username_good,int publish_id, int discuss_id, ModelAndView mv) {
        PublishGood publishGood = new PublishGood(username_good,publish_id,discuss_id);
        boolean b = this.shareService.deletepGood(publishGood) > 0;
        if (b) {
            mv.setViewName("share/shareInfo");
            return mv;
        } else {
            return mv;
        }
    }

}
