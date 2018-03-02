package cn.itcast.ssh.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Resource
	private SessionFactory sessionFactory;
	/*获取当前可用的Session*/
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected Class<T> clazz;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDaoImpl(){
		/*通过反射获取T的真实类型*/
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
		/*打印clazz名字,如cn.itcast.ssh.entity.User*/
		System.out.println("clazz = " + clazz.getName());
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> get() {
		/*clazz.getSimpleName() clazz的类名，如User*/
		List<T> getList = getSession().createQuery("FROM " + clazz.getSimpleName()).list();
		return getList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByIds(Long[] ids) {
		List<T> getListByIds = getSession().createQuery("FROM " + clazz.getSimpleName() +" WHERE id IN(:ids)").setParameter("ids", ids).list();
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		return getListByIds ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Long id) {
		T getById = (T) getSession().get(clazz, id);
		return getById;
	}

	@Override
	public void deleteById(Long id) {
		Object obj = getSession().get(clazz, id);
		getSession().delete(obj);
	}

}
