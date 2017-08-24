package com.yrws.chat.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yrws.chat.entity.Discuss;
import com.yrws.chat.entity.Follow;
import com.yrws.chat.entity.Publish;
import com.yrws.chat.entity.PublishGood;
import com.yrws.chat.service.ChatService;
import com.yrws.chat.utils.Util;
import com.yrws.chat.view.UserPublish;

@Controller
public class ChatController {
   
    @Autowired
    private ChatService chatService;
    //范鹏举
    @RequestMapping("pubLishChat")
    public ModelAndView hello(ModelAndView mv, HttpServletRequest request) {
            String basepath = request.getScheme() + "://"
                            + request.getHeader("Host") + request.getContextPath();// 获取路径
            mv.addObject("basepath", basepath);
            mv.setViewName("chat/pubLishChat");
            return mv;
    }
   //跳转添加
    @RequestMapping("add")
    public String add() {
            return "chat/pubLishChat";
    }
    // 添加
    @RequestMapping("addPubLishChat")
    public ModelAndView addPubLishChat(ModelAndView mv, Publish publish,
                    MultipartFile[] files, HttpServletRequest request) {
            String basepath = request.getScheme() + "://"
                            + request.getHeader("Host") + request.getContextPath();// 获取路径
            mv.addObject("basepath", basepath);
            StringBuffer sb=new StringBuffer();
            String[] filename = new String[files.length];
            StringBuffer append = null;
            for(int i=0;i<files.length;i++){
                    filename[i]=this.onUpload(files[i], request);
                    append = sb.append(filename[i]+",");
            }
            //获取当前时间
            Date date = new Date();
            publish.setUsername("模拟主用户");
            publish.setPublishDate(date);   
            publish.setPublishImg(append.toString());
            int n = this.chatService.addPubLishChat(publish);
            if (n > 0) {
                    
                    return new ModelAndView("redirect:chatMain.html");
            } else {
                    return new ModelAndView("redirect:/err.vm");
            }
    }
    //上传
    private String onUpload(MultipartFile files,HttpServletRequest request){
            
            //1.获取文件位置
            String uploadUrl=request.getSession().getServletContext().getRealPath("/")+"uplod/";
            //2.获取上传文件原文件名
            String fileName=files.getOriginalFilename();
            //3.创建新文件名
            String uuid = UUID.randomUUID().toString();
            //4.获取源文件的后缀名
            if(fileName==""){
                    return "err";
            }else{
            String s = fileName.substring(fileName.indexOf("."));
            //5.拼接
            String photoName=uuid + s;
            //6.在存储路径下创建一个新文件，把上传文件路径传过去,
            File dir=new File(uploadUrl);//存的是文件目录
            if(!dir.exists()){      
                    dir.mkdirs();
                    } 
            //7.在uuid + s下创建新文件
            File targetFile=new File(uploadUrl+photoName);
             if (!targetFile.exists()) {
                try {
                    targetFile.createNewFile();//内容
                    files.transferTo(targetFile); 
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            return  photoName;      
            }  
    }
    
//chatMain列表--王巨星
    @RequestMapping(value = "chatMain")
    public ModelAndView list(ModelAndView mv, HttpServletRequest request) {
        //获取当前服务器地址
        mv.addObject("basepath",
        request.getScheme() + "://" + request.getHeader("Host") + request.getContextPath());// 获取路径
     
        List<UserPublish> list=chatService.selectAll("模拟主用户");
        //System.out.println(list);
        //对添加图片的路径数组进行分割
        String[] ss=null;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getPublishimg()!=null){
                ss =list.get(i).getPublishimg().toString().split(",");
                list.get(i).setPublishimg(ss[0]);
            }
        }       
        //最新导航栏列表
        System.out.println("++++list++++"+list);
        mv.addObject("list", list);
        List<UserPublish> listg=chatService.selectGoodCount("模拟主用户");
        //对添加图片的路径数组进行分割
        if(chatService.selectGoodCount("模拟主用户")!=null){
            for(int i=0;i<listg.size();i++){
                if(list.get(i).getPublishimg()!=null){
                    ss =listg.get(i).getPublishimg().toString().split(",");
                    listg.get(i).setPublishimg(ss[0]);
                }
            }       
        //最火导航栏列表
        mv.addObject("listgood", listg);
        }
        if(chatService.selectDiscussCount("模拟主用户")!=null){
        List<UserPublish> listd=chatService.selectDiscussCount("模拟主用户");
        //对添加图片的路径数组进行分割
        
        for(int i=0;i<listd.size();i++){
            if(list.get(i).getPublishimg()!=null){
                ss =listd.get(i).getPublishimg().toString().split(",");
                listd.get(i).setPublishimg(ss[0]);
            }
        }      
        //最新列表
        mv.addObject("listdiscuss", listd);
        }
        //回到chatMain.vm页面
        mv.setViewName("chat/chatMain");
       
        return mv;
    }
    //点赞
    @RequestMapping("chatajax")
    @ResponseBody
    public Map<String, String> cacheName(String username) {
        Map<String, String> map = new HashMap<String, String>();
       //获取","下标
        int i=username.indexOf(",");
        //取username","前面的字符串给publish_id
        int publish_id=Integer.parseInt(username.substring(0, i));
        //取username","后面的字符串给name
        String name=username.substring(i+1);
        if (chatService.insertGood(new PublishGood("模拟主用户", publish_id))) {
            // mv.addObject("list",chatMainService.selectAll());
            map.put("username", "点赞成功!");
        }
        return map;
    }
     //取消点赞
    @RequestMapping("dchatajax")
    @ResponseBody
    public Map<String, String> dcacheName(String username) {
        Map<String, String> map = new HashMap<String, String>();
        int i=username.indexOf(",");
        int publish_id=Integer.parseInt(username.substring(0, i));
        String name=username.substring(i+1);
        if (chatService.delectGood(new PublishGood("模拟主用户", publish_id)) > 0) {
            map.put("username", "取消点赞!");
        }
        return map;
    }
    //支鹏宇+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  //支鹏宇+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //进入详情页面
    @RequestMapping("go")
    public ModelAndView selectById(HttpServletRequest request, ModelAndView mv, Integer publishId,String name) {
        mv.addObject("basepath",
                request.getScheme() + "://" + request.getHeader("Host") + request.getContextPath());// 获取路径

        //联查指定帖子+关注回显
        //mv.addObject("lian", this.chatService.selectAll(publishId,new Follow("模拟主用户", "公子小白")));
        UserPublish listup = chatService.selectAll(publishId,new Follow("模拟主用户", "公子小白"));
        String[] str = null;
        if( listup.getPublishImg() !=null){
            str = listup.getPublishImg().toString().split(",");
            listup.setPublishImg(str[0]);;
        }
        
        mv.addObject("lian", listup);
        System.out.println("12345678900"+chatService.selectAll(publishId,new Follow("模拟主用户", "公子小白")));
        //System.out.println(chatService.selectAll(1,new Follow("模拟主用户", "公子小白")).isPubGood());
        //评论列表联查
        mv.addObject("lie", this.chatService.selectCondition(publishId,"模拟主用户"));
        System.out.println(chatService.selectCondition(publishId,"模拟主用户"));
        //统计评论数
        mv.addObject("pcount", this.chatService.pinCount(publishId));
        //统计点赞数
        mv.addObject("zcount", this.chatService.zanCount(publishId));
        //主用户信息查询
        mv.addObject("users",this.chatService.selectByUsername("模拟主用户"));
        // 跳转的页面
        mv.setViewName("chat/chatInfo");
        return mv;
    }
    //关注
    
    @RequestMapping(value = "follows", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addFollow(String from_username, String to_username, ModelAndView mv) {
        Follow follow = new Follow(from_username, to_username);
        boolean b = this.chatService.addFollow(follow) > 0;
        if (b) {
            mv.setViewName("chat/chatInfo");
            return mv;
        } else {
            return mv;
        }
    }
    //取消关注
    @RequestMapping(value = "deletefollow", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deleteFollow(String from_username, String to_username, ModelAndView mv) {
        Follow follow = new Follow(from_username, to_username);
        System.out.println("1233"+follow);
        boolean b = this.chatService.deleteFollow(follow) > 0;
        if (b) {
            mv.setViewName("chat/chatInfo");
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
        boolean b = this.chatService.addGood(publishGood) > 0;
        if (b) {
            mv.setViewName("chat/chatInfo");
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
        boolean b = this.chatService.deleteGood(publishGood) > 0;
        if (b) {
            mv.setViewName("chat/chatInfo");
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
        chatService.insert(discusses, discuss_comment , "模拟主用户", discussby_username, discuss_floor);
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
        boolean b = this.chatService.addpGood(publishGood) > 0;
        if (b) {
            mv.setViewName("chat/chatInfo");
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
        boolean b = this.chatService.deletepGood(publishGood) > 0;
        if (b) {
            mv.setViewName("chat/chatInfo");
            return mv;
        } else {
            return mv;
        }
    }
}
