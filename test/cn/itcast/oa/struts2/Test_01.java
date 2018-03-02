package cn.itcast.oa.struts2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class Test_01 extends ActionSupport{
	
	public String name;
	
	public String method_01() throws Exception{
		
		if ("SECRET".equals(name))
	      {
	         return SUCCESS;
	      }else{
	         return ERROR;  
	      }
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
