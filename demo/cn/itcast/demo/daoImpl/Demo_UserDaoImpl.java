package cn.itcast.demo.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.demo.dao.Demo_UserDao;
import cn.itcast.demo.model.Demo_User;

public class Demo_UserDaoImpl extends HibernateDaoSupport implements Demo_UserDao {
	
	/*@Resource
	SessionFactory sessionFactory;*/

	@Override
	public void save(Demo_User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public void delete(Long id) {
		Object obj = getbyID(id);
		getHibernateTemplate().delete(obj);
	}

	@Override
	public void updata(Demo_User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public Demo_User getbyID(Long id) {
		if(id!=null){
			return (Demo_User) getHibernateTemplate().get("Demo_User", id);
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Demo_User> findAll() {
		/*Hibernate使用Hibernate查询语言(HQL)查询数据。 HQL与我们所了解的数据库SQL语句有点不同。
		SQL：在表中查询数据
		HQL：在实体类中查询对象数据*/
		return getHibernateTemplate().find("from Demo_User");
		/*List<Demo_User> demo_UserList = this.getHibernateTemplate().find("from Demo_User");
		return demo_UserList;*/
	}

}

/*@Component
public class Demo_UserDaoImpl implements Demo_UserDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	//bean注入
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//获取session
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Demo_User user) {
		getSession().save(user);
	}

	@Override
	public void delete(Long id) {
		getSession().delete(id);
	}

	@Override
	public void updata(Demo_User user) {
		getSession().update(user);
	}

	@Override
	public Demo_User getbyID(Long id) {
		return (Demo_User) getSession().get(Demo_User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demo_User> fildAll() {
		return getSession().createQuery(
				"FROM " + Demo_User.class.getSimpleName())
				.list();
	}
	
}
*/