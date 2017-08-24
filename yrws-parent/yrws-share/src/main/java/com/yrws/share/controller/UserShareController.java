package com.yrws.share.controller;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;











import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;








import com.yrws.share.entity.Publish;
import com.yrws.share.entity.Share;
import com.yrws.share.service.UserShareService;
import com.yrws.share.utils.Page;

@Controller
public class UserShareController {
	@Autowired
	private UserShareService userShareService;
	
	//添加跳转
		@RequestMapping("addShare")
		public String addShare(){
			return "share/sharePublish";
		}
		//添加
		@RequestMapping("addPubLishShare")
		public ModelAndView addPubLishShare(MultipartFile files[],ModelAndView mv,HttpServletRequest request,Publish publish){
			String basepath = request.getScheme() + "://"
					+ request.getHeader("Host") + request.getContextPath();// 获取路径
			mv.addObject("basepath", basepath);
			if(files !=null){
			//获取图片
			StringBuffer sb=new StringBuffer();
			StringBuffer append=null;
			//String[] filename = new String[files.length];
			String[] filname=null;
			for (int i = 0; i < files.length; i++) {
				String fliename = onLoad(files[i], request);
				//append = sb.append(filename[i].toString()+",");
				append=sb.append(fliename+",");
			}
			publish.setPublishImg(append.toString());
			}
			//获取当前时间
			long time = System.currentTimeMillis();
			Date date = new Date(time);
			publish.setPublishDate(date);
			int n=this.userShareService.addPubLishShare(publish);
			if(n>0){
				return new ModelAndView("forward:shareMain.html");
			}else{
				return new ModelAndView("redirect:/err.vm");
			}
			
		}
		//上传图片
		public String onLoad(MultipartFile files,HttpServletRequest request){
			//1.获取文件位置
					String uploadUrl=request.getSession().getServletContext().getRealPath("/")+"photos/";
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
	@RequestMapping("shareMain")
	public ModelAndView basepath(HttpServletRequest request,ModelAndView mv,String currentPage,String username){
	        //定义整形变量count 调用userShareService中的count方法，统计表publish中有多少条数据
	        int count = this.userShareService.count();
	        //定义Page对象Page为工具类只用来实现分页功能
	        Page<Share> page = new Page<Share>(currentPage, count, "4");
	        //统一vm页面中的文件基本路径
			mv.addObject("basepath",request.getScheme() + "://" + request.getHeader("Host") + request.getContextPath());
			//调用userShareService中的selectAll方法查询表publish中所有的数据结果list集合的形式返回
			mv.addObject("list", this.userShareService.selectAll(page));
			//添加Page对象
			mv.addObject("page", page);
			//调用userShareService中的selectAllByUserName方法查询表publish中用户user1发表的所有分享结果list集合的形式返回
			mv.addObject("listbytype", this.userShareService.selectAllByUserName(page));
			//调用userShareService中selectPoint方法查询表publish_good中某一用户对那一条分享的点赞记录
			mv.addObject("status",this.userShareService.selectPoint(username));
			//定义字符串uesrname，并赋值用于方法下面代码中addGood中的参数赋值
			username = "user1";	
			mv.setViewName("share/shareMain");
			return mv;
	}
	
	
	
	
	@RequestMapping("addGood")
	@ResponseBody
	public Integer countPoint(String name,int id){
		
        Map<String,Integer> map = new HashMap<String,Integer>();
        name = "user1";
        try {
        	int ky = this.userShareService.countPoint(id);
        	if(ky==1){
        		this.userShareService.deletePoint(id);
        	}else{
        		this.userShareService.addGood(name, id);
        	}
        	System.out.println(id);
        	map.put("id",id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return id;
    }
	
	
	
	@RequestMapping("addUser")
	@ResponseBody
	public Integer userPoint(String name,int id){
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		name = "user1";
		try {
			int ky = this.userShareService.countPoint(id);
			if(ky==1){
				this.userShareService.deletePoint(id);
			}else{
				this.userShareService.addGood(name, id);
			}
			System.out.println(id);
			map.put("id",id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return id;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
