package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.PersonService;
import cn.itcast.oa.util.QueryHelper;


@Service
@Transactional
public class PersonSeivceImpl extends DaoSupportImpl<User> implements
		PersonService {

	
}
