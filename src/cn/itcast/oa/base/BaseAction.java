package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.service.ForumManageService;
import cn.itcast.oa.service.ForumService;
import cn.itcast.oa.service.PersonService;
import cn.itcast.oa.service.PrivilegeService;
import cn.itcast.oa.service.ReplyService;
import cn.itcast.oa.service.RoleService;
import cn.itcast.oa.service.TopicService;
import cn.itcast.oa.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	// =============== ModelDriven的支持 ==================

	protected T model;

	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

	// =============== Service实例的声明 ==================
	@Resource
	protected RoleService roleService;
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected ForumManageService forumManageService;
	@Resource
	protected ForumService forumService;
	@Resource
	protected TopicService topicService;
	@Resource
	protected ReplyService replyService;
	@Resource
	protected PersonService personService;
	
	
	
	/**
	 * 获取当前登录的用户
	 * 
	 * @return
	 */
	protected User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}
	
	//===============分页信息==============
	protected int pageNum = 1;
	protected int pageSize = 10;
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
