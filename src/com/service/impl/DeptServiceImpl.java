package com.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.persistence.IDeptDao;
import com.persistence.entity.TDept;
import com.service.IDeptService;

public class DeptServiceImpl implements IDeptService {
	private int currentPage = 1;
	private int pageSize = 3;
	private IDeptDao deptDao;
	
	//删除部门
	public boolean delete(TDept dept) throws Exception {
		//System.out.println("service 要删除的对象的ID "  + dept.getId());
		//级联删除时我们应该首先获得改对象的实体
		this.deptDao.delete(deptDao.queryById(dept.getId()));
		return true;
	}
   
	//获得查询时的总页数
	public int getAllPage(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		int total = this.deptDao.getAllPage(dept);
		return total;
	}
   
	//根据条件查询
	public List<Map<String, String>> query(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		this.deptDao.setCurrentPage(currentPage);
		List<Map<String, String>> depts = this.deptDao.query(dept);
		return depts;
	}
    //获得所有部门的K - V
	public List<Map<String, String>> queryAllKV() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, String>> depts = this.deptDao.queryAllKV();
		return depts;
	}
    
	//根据ID查找部门
	public TDept queryById(long id) throws Exception {
		// TODO Auto-generated method stub
		TDept dept = this.deptDao.queryById(id);
		return dept;
	}
    //根据IDs查找出所有ID de 部门
	public Set<TDept> queryByIds(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		Set<TDept> depts = this.deptDao.queryByIds(ids);
		return depts;
	}
    
	//根据项目ID获得已配置到该项目的部门
	public List<Map<String, String>> queryConfiged(String id) throws Exception {
		List<Map<String, String>> depts = this.deptDao.queryConfiged(id);
		return depts;
	}
    //保存部门
	public boolean save(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		this.deptDao.save(dept);
		return true;
	}
    //更新部门
	public boolean update(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		this.deptDao.update(dept);
		return true;
	}
	//根据部门ID查找该部门的员工
	public List<Map<String, String>> deptEmps(String deptId) throws Exception {
		return this.deptDao.deptEmps(deptId);
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}

	
}
