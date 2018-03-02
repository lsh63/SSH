package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

public interface ReplyService extends DaoSupport<Reply>{

	/**
	 * 查询指定主题中所有的回复列表，排序：按发表时间升序排列。
	 * @param topic
	 * @return
	 */
	List<Reply> findByTopic(Topic topic);

	/**
	 * 分页查询：查询指定主题中所有的回复列表，排序：按发表时间升序排列。
	 * @param pageNum 当前页
	 * @param pageSize 每页显示多少条
	 * @param topic 主题
	 * @return
	 */
	PageBean getPageBeanByTopic(int pageNum, int pageSize, Topic topic);

}
