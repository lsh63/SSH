package cn.itcast.demo.serviceImpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import cn.itcast.demo.model.Demo_Filter;
import cn.itcast.demo.service.Demo_FilterService;

@Service
public class Demo_FilterSerciveImpl implements Demo_FilterService {

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
