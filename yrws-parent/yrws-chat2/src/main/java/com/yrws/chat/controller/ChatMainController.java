package com.yrws.chat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yrws.chat.entity.PublishGood;
import com.yrws.chat.service.ChatMainService;
import com.yrws.chat.view.UserPublish;

@Controller
public class ChatMainController {
    // @Autowired
    // private StaffService staffService;
    @Autowired
    private ChatMainService chatMainService;

    @RequestMapping(value = "chatMain")
    public ModelAndView list(ModelAndView mv, HttpServletRequest request) {

        mv.addObject("basepath",
                request.getScheme() + "://" + request.getHeader("Host") + request.getContextPath());// 获取路径
        mv.addObject("list", chatMainService.selectAll());
        for(UserPublish up:chatMainService.selectAll()){
            System.out.println(up.isGood());
        }
        mv.addObject("listgood", chatMainService.selectGoodCount());
        mv.addObject("listdiscuss", chatMainService.selectDiscussCount());
        mv.setViewName("chat/chatMain");
        return mv;
    }

    @RequestMapping("chatajax")
    @ResponseBody
    public Map<String, String> cacheName(String username) {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println("0------" + username);
        int i=username.indexOf(",");
        int publish_id=Integer.parseInt(username.substring(0, i));
        String name=username.substring(i+1);
        if (chatMainService.insertGood(new PublishGood(name, publish_id))) {
            // mv.addObject("list",chatMainService.selectAll());

            map.put("username", "已点赞!");
        }
        return map;
    }

    @RequestMapping("dchatajax")
    @ResponseBody
    public Map<String, String> dcacheName(String username) {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println("0------" + username);
        int i=username.indexOf(",");
        int publish_id=Integer.parseInt(username.substring(0, i));
        String name=username.substring(i+1);
        if (chatMainService.delectGood(new PublishGood(name, publish_id)) > 0) {
            // mv.addObject("list",chatMainService.selectAll());

            map.put("username", "取消点赞!");
        }
        return map;
    }
}
