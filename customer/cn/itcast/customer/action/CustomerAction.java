package cn.itcast.customer.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.itcast.customer.entity.Customer;
import cn.itcast.customer.service.CustomerBo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class CustomerAction implements ModelDriven{
	//ModelDriven（模型驱动传参数）此类提供实体getter and setter方法；
	@Resource
	CustomerBo customerBo;
	
	Customer customer = new Customer();
	public Object getModel() {
		return customer;
	}
	
	List<Customer> customerList = new ArrayList<Customer>();
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	//save customer
	public String addCustomer() throws Exception{	
		//save it
		customer.setCreatedDate(new Date());
		customerBo.addCustomer(customer); 
		//reload the customer list
		customerList = null;
		customerList = customerBo.listCustomer();
		return "addCustomer";
	}
	
	//list all customers
	public String listCustomer() throws Exception{
		customerList = customerBo.listCustomer();
		/*ActionContext.getContext().put("customerList", customerList);*/
		return "listCustomer";
	}
	
	//delete customer
	public String deleteCustomer(){
		customerBo.delete(customer);
		return "deleteCustomer";
	}
	
	public String getCustomerById(){
		return "getCustomerById";
	}
	
	//delete customer by id
	public String deleteCustomerById(){
		/*customer = customerBo.getById(customer.getCustomerId());*/
		customerBo.deleteById(customer.getCustomerId());
		return "deleteCustomerById";
	}
	
	//update customer
	public String updateCustomer(){
		customerBo.update(customer);
		return "updateCustomer";
	}

}
