package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;

public interface ForumManageService extends DaoSupport<Forum> {

	/**
	 * 上移
	 */
	void moveUp(Long id);

	/**
	 * 下移
	 */
	void moveDown(Long id);

}
