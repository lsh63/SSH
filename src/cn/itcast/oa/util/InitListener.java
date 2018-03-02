package cn.itcast.oa.util;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

public class InitListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		// 获取容器与相关的Service对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");
		// 准备数据：topPrivilegeList
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		arg0.getServletContext().setAttribute("topPrivilegeList", topPrivilegeList);
		System.out.println("------------> 已准备数据 topPrivilegeList<------------");

		// 准备数据：allPrivilegeUrls
		Collection<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		arg0.getServletContext().setAttribute("allPrivilegeUrls", allPrivilegeUrls);
		System.out.println("------------> 已准备数据allPrivilegeUrls <------------");
	}

}
