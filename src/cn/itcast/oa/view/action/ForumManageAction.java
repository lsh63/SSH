package cn.itcast.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;

@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {
	
	/** 列表 */
	public String list() throws Exception {
		List<Forum> forumList = forumManageService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}
	/** 删除 */
	public String delete() throws Exception {
		forumManageService.delete(model.getId());
		return "toList";
	}
	/** 增加页面 */
	public String addUI() throws Exception {
		return "saveUI";
	}
	/** 增加 */
	public String add() throws Exception {
		forumManageService.save(model);
		return "toList";
	}
	/** 修改页面 */ 
	public String editUI() throws Exception {
		//准备数据
		Forum forum = forumManageService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(forum);

		return "saveUI";
	}
	/** 修改 */
	public String edit() throws Exception {
		//从数据库中取出原对象
		Forum forum = forumManageService.getById(model.getId());
		//设置要修改的属性
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		//更新到数据库中
		forumManageService.update(forum);
		return "toList";
	}
	/** 上移 */
	public String moveUp() throws Exception {
		forumManageService.moveUp(model.getId());
		return "toList";
	}
	/** 下移 */
	public String moveDown() throws Exception {
		forumManageService.moveDown(model.getId());
		return "toList";
	}
}
