package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;

@Controller
@Scope("prototype")
public class PersonAction extends BaseAction<User> {

	private Long departmentId;
	private Long[] roleIds;
	private String oldPassword;
	private String password2;
	

	/** 个人信息 */
	public String show() throws Exception {
		//准备个人信息 user
		User user = getCurrentUser(); 
		ActionContext.getContext().put("user", user);
		return "show";
	}

	/** 修改密码页面 */
	public String editUI() throws Exception {
		return "editUI";
	}

	/** 修改密码 */
	public String edit() throws Exception {
		//1 获得原对象
		User user= getCurrentUser();

		String md5Digest = DigestUtils.md5Hex(oldPassword);

		if(md5Digest.equals(user.getPassword())){//如果原密码正确
			if(model.getPassword().equals(password2)){//两次输入的密码一样
				md5Digest = DigestUtils.md5Hex(model.getPassword());//设置新密码进行MD5加密
				//2 设置要修改的属性
				user.setPassword(md5Digest);
				//3 保存更新到数据库
				userService.update(user);
				addFieldError("user", "保存成功！");
				return "editUI";
			} else {
				addFieldError("password", "两次输入的密码不一样！");
				return "editUI";
			}
		} else {
			addFieldError("oldPassword", "原密码密码不正确！");
			return "editUI";
		}

		//return "toShow";
	}
	
	

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	

}
