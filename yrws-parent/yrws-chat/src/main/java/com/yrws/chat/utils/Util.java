package com.yrws.chat.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Util {
    // String转int
    public static int toInt(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(str);
        }
    }

    //分割方法
    public static Map<String, String[]> slipList(String icon, String photourl){
        Map<String, String[]> map = new HashMap<String, String[]>();
        if (photourl != null && !photourl.trim().isEmpty()) {
            String[] imgs = photourl.split(icon);
            System.out.println(photourl);
            map.put("imgs", imgs);
            
           
        }else{
            String[] str = {"798736627587575035.jpg"};
            map.put("imgs", str);
        }
        
        for (int i = 0; i < map.get("imgs").length; i++) {
            System.out.println(map.get("imgs")[i] + i + "xxxx");
        }
        
        return map;
    }

    // 时间计算
    public static String toAfterTime(Date bgTime) {
        bgTime = bgTime == null ? new Date() : bgTime;
        long subTime = new Date().getTime() - bgTime.getTime();
        if (subTime > 0) {
            if (subTime < 60 * 60 * 1000) {
                int x = (int) subTime / (60 * 1000);
                return x + "分钟";
            } else if (60 * 60 * 1000 < subTime && subTime < 24 * 60 * 60 * 1000) {
                int x = (int) subTime / (60 * 60 * 1000);
                return x + "小时";
            } else if (24 * 60 * 60 * 1000 < subTime && subTime < 30 * 24 * 60 * 60 * 1000) {
                int x = (int) subTime / (24 * 60 * 60 * 1000);
                return x + "天";
            } else if (subTime < 365 * 24 * 60 * 60 * 1000 && 30 * 24 * 60 * 60 * 1000 < subTime) {
                int x = (int) subTime / (30 * 24 * 60 * 60 * 1000);
                return x + "月";
            } else {
                int x = (int) subTime / (365 * 24 * 60 * 60 * 1000);
                return x + "年";
            }
        }
        return "0分钟";
    }

    // 切割顺序切割为两个 有返回list 字符串按顺序存放 没有返回空list
    public static List<String> indexOfSlipe(String icon, String str) {
        List<String> li = new ArrayList<String>();
        int index = str.indexOf(icon);
        if (str != "" && !str.trim().isEmpty()) {
            if (index > 0) {
                String str1 = str.substring(0, index);
                String str2 = str.substring(index+1, str.length());
                li.add(str1);
                li.add(str2);
            } else if (index == -1) {
                li.add(str);
                li.add("");
            }
            return li;
        }

        return null;
    }
    
    
  //——————————————————————————文件上传————————————————————————————————————
//  文件上传
public String uploadImg(HttpServletRequest request,MultipartFile[] imageFile){
    String[] url= new String[imageFile.length];
     for(int i = 0; i< imageFile.length ; i++){
       url[i] = this.onUpload(imageFile[i],request);
        
    }
     StringBuffer sb = new StringBuffer();
     for(int i = 0; i < url.length; i++){
         sb. append(url[i]);
     }
     String imgurl = sb.toString();
     return imgurl;
         
 }
 private String onUpload(MultipartFile imageFile, HttpServletRequest request) {
//   获取路径
     String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"upload/";
//   获取上传文件的源文件名
     String filename = imageFile.getOriginalFilename();
     System.out.println(filename + "filename");
     if(filename==""){
         return "upload/girl.png";
     }else{
         System.out.println("2file");
   //    随机生成一个文件名
         String uuid = UUID.randomUUID().toString();
   //    获取源文件后缀名
         String s = filename.substring(filename.indexOf("."));
   //    拼接成新的文件名
         String photoname = uuid + s;
   //    在存储文件的路径下，创建一个新的文件
         File dir = new File(uploadUrl);
   //    判断dir是否存在，若不存在，创建
         if(!dir.exists()){
            dir.mkdirs();
         }
   //    uploadUrl + photoname在此路径下创建新的文件
         File targetFile = new File(uploadUrl + photoname);
         if(!targetFile.exists()){
             try {
                 targetFile.createNewFile();
   //    将上传文件转到新建的文件中
                 imageFile.transferTo(targetFile);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         return "upload/" + photoname;
     }
 }
    
    
}
