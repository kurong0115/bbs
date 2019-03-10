package com.yc.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.bean.TblTopic;
import com.yc.dao.TopicDao;

public class TopicBiz {
	private TopicDao td=new TopicDao();
	
	/**
	 * 发帖功能
	 * @param topic
	 * @throws BizException
	 */
	public void post(TblTopic topic) throws BizException {
		if(topic.getTitle().length()<2) {
			throw new BizException("标题不能少于两个字符");
		}
		if(topic.getContent().length()<10) {
			throw new BizException("内容不能少于10个字符");
		}
		td.insert(topic);
	}
	
	/**
	 * 根据帖子id查询数据
	 * @param topicid
	 * @return
	 */
	public List<Map<String, Object>> selectByDetail(String topicid) {		
		return td.selectByDetail(topicid);
	}
}
