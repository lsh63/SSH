package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.util.QueryHelper;

// @Transactional注解可以被继承
// @Transactional注解对父类中声明的方法无效
@Transactional
@SuppressWarnings("unchecked")
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource
	private SessionFactory sessionFactory;
	//@Resource
	//private HibernateTemplate hibernateTemplate;
	private Class<T> clazz;

	public DaoSupportImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		System.out.println("clazz ---> " + clazz);
	}

	//v2
	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters) {

		//查询本页数据
		Query queryList = getSession().createQuery(hql);
		if(parameters != null){
			for(int i = 0;i<parameters.size();i++){
				parameters.add(i,parameters.get(i));
			}
		}
		queryList.setFirstResult((pageNum-1)*pageSize);
		queryList.setMaxResults(pageSize);
		List list = queryList.list();
		
		//查询总记录数
		hql = "SELECT COUNT(*) " + hql; 
		Query query = getSession().createQuery(hql);
		if(parameters != null){
			for(int i = 0;i<parameters.size();i++){
				query.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) query.uniqueResult();
		
		return new PageBean(pageNum,pageSize,count.intValue(),list);
	}

	// 公共的查询分页信息的方法（最终版）
	@SuppressWarnings("rawtypes")
	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper) {
		
		//获取参数列表
		List<Object> parameters = queryHelper.getParameters();
		
		//查询本页数据
		Query queryList = getSession().createQuery(queryHelper.getQueryListHql());
		if(parameters != null){
			for(int i = 0;i<parameters.size();i++){
				queryList.setParameter(i, parameters.get(i));
			}
		}
		queryList.setFirstResult((pageNum-1)*pageSize);
		queryList.setMaxResults(pageSize);
		List list = queryList.list();
		
		//查询总记录数
		Query queryCount = getSession().createQuery(queryHelper.getQueryCountHql());
		if(parameters != null){
			for(int i = 0;i<parameters.size();i++){
				queryCount.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) queryCount.uniqueResult();
		return new PageBean(pageNum,pageSize,count.intValue(),list);
	}

	/**
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*增*/
	public void save(T entity) {
		getSession().save(entity);
	}

	/*改*/
	public void update(T entity) {
		getSession().update(entity);
	}

	/*删*/
	public void delete(Long id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	/*根据id获取对象*/
	public T getById(Long id) {
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}
	}

	/*根据id获取对象列表*/
	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();
		}
	}

	/*获取所有对象列表*/
	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

	
	public PageBean getPageBeanByClass(int pageNum, int pageSize, Class clazz) {
		getSession().createQuery(//
				"FROM ")//
				.list();
		
		return null;
	}

	
}
