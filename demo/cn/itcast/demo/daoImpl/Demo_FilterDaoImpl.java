package cn.itcast.demo.daoImpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import cn.itcast.demo.dao.Demo_FilterDao;
import cn.itcast.demo.model.Demo_Filter;

@Repository
public class Demo_FilterDaoImpl implements Demo_FilterDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	} 

	@Override
	public void save(Demo_Filter filter) {
		getSession().save(filter);
	}

	@Override
	public void delete(Long id) {
		getSession().delete(id);
	}

	@Override
	public void updata(Demo_Filter filter) {
		getSession().update(filter);
	}

	@Override
	public void getbyID(Long id) {
		getSession().get(getClass(), id);
	}

}
