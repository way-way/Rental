package com.rental.service.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.rental.entity.Record;
import com.rental.service.RecordService;

public class RecordServiceImpl extends BaseServiceImpl<Record> implements RecordService{

	@Override
	public long findTotalPage(int pagesize) {
		String hql = "select count(r) from Record r";
		@SuppressWarnings("unchecked")
		List<Long> list = baseDAO.findQuery(hql);
		if (list.size()==0) {
			return 0;
		}else{
			Long total = list.get(0);
			long totalpage = total%pagesize==0?total/pagesize:total/pagesize+1;
			return totalpage;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Record> searchCarName(String  record) {
		String hql="from Record r where r.brand LIKE"+"'"+"%"+record+"%"+"'";
				@SuppressWarnings("rawtypes")
		List list=baseDAO.findQuery(hql);
		
		if (list.size()==0) {
			return null;
		}
		return list;
	}

}
