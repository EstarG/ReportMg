package com.service;

import java.util.List;
import java.util.Map;

import com.persistence.entity.TEmp;

public interface IEmpService {
	public boolean save(TEmp emp) throws Exception;
	public boolean delete(TEmp emp) throws Exception;
	public boolean update(TEmp emp) throws Exception;
	public List<Map<String, String>> find(final TEmp emp,final String deptId) throws Exception;
	public TEmp getEmpById(long id) throws Exception;
	public List<Map<String, String>> getEmpOptions() throws Exception;//查找下属员工
	public List<Map<String, String>> queryEmpByDeptId(long id) throws Exception;
	public List<Map<String, String>> getUnselectedEmp(long id) throws Exception;
	public TEmp login(TEmp emp) throws Exception;
	public long queryEmpId(String empName) throws Exception;
	public int getAllPage(final TEmp emp,final String deptId) throws Exception;
	public List<Map<String, String>> queryofOneDept(long id) throws Exception;//查找下属员工
	public void setCurrentPage(int currentPage);
	public void setPageSize(int pageSize);
	public List<Map<String, String>> getOldPassword(TEmp emp) throws Exception;
	public boolean updateNewPassword(TEmp emp) throws Exception;
	public boolean isUsed(String name);
	public TEmp getBackPass(TEmp emp) throws Exception;
}
