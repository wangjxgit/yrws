package com.yrws.share.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrws.share.dao.ShareMaper;
import com.yrws.share.entity.Publish;
import com.yrws.share.entity.PublishGood;
import com.yrws.share.entity.Share;
import com.yrws.share.service.UserShareService;
import com.yrws.share.utils.Page;

@Service
@Transactional
public class UserShareServiceImpl implements UserShareService {
    
    @Autowired
    private ShareMaper userShareDao;
    //从表publish中查询单个用户的分享
    public List<Share> selectAllByUserName(Page<Share> page) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("index", page.getStartRecord());
        map.put("size", page.getPageSize());
        return userShareDao.selectAllByUserName(map);
    }
    //从表publish中查询所有用户的所有分享
    public List<Share> selectAll(Page<Share> page) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("index", page.getStartRecord());
        map.put("size", page.getPageSize());
        return userShareDao.selectAll(map);
    }
    
    //从表publish中查询有多少条数据
    public int count() {
        return userShareDao.count();
    }
    //从表publish_good中查询用户的点赞记录
    public List<PublishGood> selectPoint(String username){;
        return userShareDao.selectPoint(username);
    }
        
    //向表publish_good中添加用户的点赞记录
    public void addGood(String user2, Integer id){
        userShareDao.addGood(user2,id);
    }
    //从表publish_good中查询有多少条记录
    public int countPoint(int id) {
		return userShareDao.countPoint(id);
	}
	public void deletePoint(int id) {
		userShareDao.deletePoint(id);
	}
	
	//添加
		public int addPubLishShare(Publish publish){
			int n=this.userShareDao.addPubLishShare(publish);
			return n;
		}
}
