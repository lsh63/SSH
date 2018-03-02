package cn.itcast.customer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.customer.entity.Customer;
@Repository
public interface CustomerDAO{
	
	void addCustomer(Customer customer);
	List<Customer> listCustomer();
	
	
	void delete(Customer customer);
	void update(Customer customer);
	
	Customer getById(Long id);
	void deleteById(Long id);
	
}
