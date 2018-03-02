package cn.itcast.customer.entity;

import java.util.Date;

public class Customer implements java.io.Serializable {
	
	/**
	 * 用来表明类的不同版本间的兼容性
	 */
	private static final long serialVersionUID = 1L;
	private Long customerId;
	private String name;
	private String address;
	private Date createdDate;
	
	//getter and setter methods
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



}
