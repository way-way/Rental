package com.rental.service.impl;

import java.util.List;

import com.rental.entity.User;
import com.rental.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	public User getUserByNameAndPwd(User user) {
		String hql = "select u from User u where name=? and pwd=?";
		List list = baseDAO.findQuery(hql, user.getName(),user.getPwd());
		if (list.size()==0) {
			return null;
		}
		return (User) list.get(0);
	}

}
