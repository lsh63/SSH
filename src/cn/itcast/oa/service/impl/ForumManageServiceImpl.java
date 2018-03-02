package cn.itcast.oa.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.ForumManageService;

@Service
@Transactional
public class ForumManageServiceImpl extends DaoSupportImpl<Forum> implements
ForumManageService {



	@Override
	public List<Forum> findAll() {

		return getSession().createQuery(//
				"FROM Forum f ORDER BY f.position")//
				.list();
	}

	@Override
	public void save(Forum forum) {
		//保存
		super.save(forum);
		// 设置position的值
		forum.setPosition(forum.getId().intValue());
	}

	public void moveUp(Long id) {
		//获取信息
		Forum forum = getById(id);// 当前要移动的Forum
		Forum parent = (Forum) getSession().createQuery(//上级的Forum
				"FROM Forum f WHERE f.position<? order by f.position desc")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
		//最上面不能移动
		if(parent == null){
			return;
		}
		//互换position属性
		int temp = forum.getPosition();
		forum.setPosition(parent.getPosition());
		parent.setPosition(temp);

		// 更新到数据中（可以不写，因为对象现在是持久化状态）
		getSession().update(forum);
		getSession().update(parent);

	}

	public void moveDown(Long id) {
		//获取信息
		Forum forum = getById(id);// 当前要移动的Forum
		Forum parent = (Forum) getSession().createQuery(//下级的Forum
				"FROM Forum f WHERE f.position>? order by f.position asc")//
				.setParameter(0, forum.getPosition())
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();
		//最上面不能移动
		if(parent == null){
			return;
		}
		//互换position属性
		int temp = forum.getPosition();
		forum.setPosition(parent.getPosition());
		parent.setPosition(temp);

		// 更新到数据中（可以不写，因为对象现在是持久化状态）
		getSession().update(forum);
		getSession().update(parent);
	}


}
