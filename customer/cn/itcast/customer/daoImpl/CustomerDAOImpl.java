package cn.itcast.customer.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.customer.dao.CustomerDAO;
import cn.itcast.customer.entity.Customer;

public class CustomerDAOImpl extends HibernateDaoSupport implements CustomerDAO{

	//add the customer
	public void addCustomer(Customer customer){
		getHibernateTemplate().save(customer);
	}
	
	//return all the customers in list
	@SuppressWarnings("unchecked")
	public List<Customer> listCustomer(){
		return getHibernateTemplate().find("from Customer");		
	}

	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	@Override
	public void update(Customer customer) {
		getHibernateTemplate().update(customer);	
	}

	@Override
	public Customer getById(Long id) {
		Customer getCustomerById = null;
		getCustomerById = (Customer) this.getHibernateTemplate().get(Customer.class, id);
		return getCustomerById;
	}

	@Override
	public void deleteById(Long id) {
		//obj是根据id封装好的对象
		Object obj = getById(id);
		//将封装好的对象删除
		getHibernateTemplate().delete(obj);
	}

}
