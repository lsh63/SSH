package cn.itcast.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport {
	@Resource
	private PrivilegeService privilegeService;
	
	public String index() throws Exception {
		return "index";
	}

	public String top() throws Exception {
		return "top";
	}

	public String bottom() throws Exception {
		return "bottom";
	}

	public String left() throws Exception {
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);
			
		return "left";
	}

	public String right() throws Exception {
		return "right";
	}
}
