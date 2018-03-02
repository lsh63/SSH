package cn.itcast.oa.service.impl;


import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

@Transactional
@Service
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements
		PrivilegeService {

	@SuppressWarnings("unchecked")
	public List<Privilege> findTopList() {
		
		return getSession().createQuery(//
				"FROM Privilege p WHERE p.parent IS NULL")//
				.list();
	}

	@SuppressWarnings("unchecked")
	public Collection<String> getAllPrivilegeUrls() {
		return getSession().createQuery(//
				"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL")//
				.list();
	}

	
}
