package cn.itcast.customer.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.customer.dao.CustomerDAO;
import cn.itcast.customer.entity.Customer;
import cn.itcast.customer.service.CustomerBo;
@Service
public class CustomerBoImpl implements CustomerBo{
	@Resource
	CustomerDAO customerDAO;
	//DI via Spring
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	//call DAO to save customer
	public void addCustomer(Customer customer){
		customerDAO.addCustomer(customer);
	}
	
	//call DAO to return customers
	public List<Customer> listCustomer(){
		return customerDAO.listCustomer();
	}

	@Override
	public void delete(Customer customer) {
		customerDAO.delete(customer);	
	}

	@Override
	public void update(Customer customer) {
		customerDAO.update(customer);
	}

	@Override
	public Customer getById(Long id) {
		/*Customer getCustomerById = customerDAO.getById(id);
		return getCustomerById;*/
		return customerDAO.getById(id);
	}

	@Override
	public void deleteById(Long id) {
		customerDAO.deleteById(id);	
	}
}
