package com.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.persistence.entity.TDept;

public interface IDeptService {
	//增加部门
	boolean	save(TDept dept) throws Exception;
	//删除部门
	boolean	delete(TDept dept)throws Exception;
	//更新部门
	boolean	update(TDept dept)throws Exception;
	//查找
	TDept	queryById(long id)throws Exception;
	List<Map<String,String >>	query(TDept dept)throws Exception;
	int 	getAllPage(TDept dept)throws Exception;
	List<Map<String,String >>	queryAllKV()throws Exception;
	Set<TDept>	queryByIds(List<String> ids)throws Exception;
	List<Map<String,String>>	queryConfiged(String id)throws Exception;
	//根据部门ID获得该部门的员工
	List<Map<String, String>> deptEmps(String deptId) throws Exception;
	
	public void setCurrentPage(int currentPage);
	public void setPageSize(int pageSize);
}
