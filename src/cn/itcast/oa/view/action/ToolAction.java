package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ToolAction extends ActionSupport {

	public String showtime() throws Exception {
		
		
		return "time";
	}

	
}
