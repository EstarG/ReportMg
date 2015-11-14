package com.service.impl;

import java.util.List;
import java.util.Map;

import com.persistence.IDeptDao;
import com.persistence.IEmpDao;
import com.persistence.entity.TEmp;
import com.service.IEmpService;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class EmpServiceImpl implements IEmpService{
	
	private IEmpDao empDao;
	public boolean delete(TEmp emp) throws Exception {
		this.empDao.delete(emp);
		return true;
	}

	public List<Map<String, String>> find(final TEmp emp,final String deptId) throws Exception{
		return empDao.find(emp, deptId);
	}

	public int getAllPage(final TEmp emp,final String deptId) throws Exception {	
		return empDao.getAllPage(emp, deptId);
	}

	public TEmp getEmpById(long id) throws Exception {
		return this.empDao.getEmpById(id);
	}

	public List<Map<String, String>> getEmpOptions() throws Exception {
		// TODO Auto-generated method stub
		return this.empDao.getEmpOptions();
	}

	public List<Map<String, String>> getUnselectedEmp(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public TEmp login(TEmp emp) throws Exception {
		// TODO Auto-generated method stub
		return empDao.login(emp);
	}

	public List<Map<String, String>> queryEmpByDeptId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public long queryEmpId(String empName) throws Exception {
		return this.empDao.queryEmpId(empName);
	}

	public boolean save(TEmp emp) throws Exception {
		this.empDao.save(emp);
		return true;
	}

	public void setCurrentPage(int currentPage) {
		this.empDao.setCurrentPage(currentPage);
	}

	public boolean update(TEmp emp) throws Exception {
		this.empDao.update(emp);
		return true;
	}

	public boolean updateNewPassword(TEmp emp)throws Exception {
		this.empDao.updateNewPassword(emp);
		return true;
	}

	public IEmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}

	public void setPageSize(int pageSize) {
		this.empDao.setPageSize(pageSize);
	}

	public List<Map<String, String>> getOldPassword(TEmp emp) throws Exception {
		
		return this.empDao.getOldPassword(emp);
	}

	public List<Map<String, String>> queryofOneDept(long id) throws Exception {
		// TODO Auto-generated method stub
		return this.empDao.queryofOneDept(id);
	}

	public boolean isUsed(String name) {
		// TODO Auto-generated method stub
		return this.empDao.isUsed(name);
	}

	public TEmp getBackPass(TEmp emp) throws Exception {
		// TODO Auto-generated method stub
		return this.empDao.getBackPass(emp);
	}	
}
