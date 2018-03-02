package cn.itcast.ssh.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.customer.entity.Customer;
import cn.itcast.ssh.entity.SshUser;

@SuppressWarnings("rawtypes")
public class UserAction  implements ModelDriven{
	
	@Resource
	cn.itcast.ssh.service.UserService userService;
	
	SshUser user = new SshUser();
	Customer customer = new Customer();
	public Object getModel() {
		return user;
	}
	
	public String list(){
		List<SshUser> getList = userService.get();
		ActionContext.getContext().put("getList", getList);
		return "list";
	}
	
	public String add(){
		userService.save(user);
		return "add";
	}

}
