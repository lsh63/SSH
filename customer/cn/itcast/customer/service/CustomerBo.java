package cn.itcast.customer.service;

import java.util.List;

import cn.itcast.customer.entity.Customer;

public interface CustomerBo {
	
	void addCustomer(Customer customer);
	List<Customer> listCustomer();
	
	void delete(Customer customer);
	void update(Customer customer);
	
	Customer getById(Long id);
	void deleteById(Long id);

}
