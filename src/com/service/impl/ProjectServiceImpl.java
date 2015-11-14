package com.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.persistence.IDeptDao;
import com.persistence.IProjectDao;
import com.persistence.entity.TProject;
import com.service.IProjectService;

public class ProjectServiceImpl implements IProjectService {
    //分页
	private int currentPage = 1;
    private int pageSize = 4;
    
    private IProjectDao projectDao;
    
	public boolean ConfigEmp(TProject project, Set<String> ids) throws Exception {
		// TODO Auto-generated method stub
		this.projectDao.ConfigEmp(project, ids);
		return true;
	}

	public boolean configDept(TProject project, List<String> ids) throws Exception {
		this.projectDao.configDept(project, ids);
		return true;
	}

	public boolean configPrp(TProject project, List<String> ids) throws Exception {
		this.projectDao.configPrp(project, ids);
		return true;
	}

	public boolean delete(TProject project) throws Exception {
		this.projectDao.delete(project);
		return true;
	}

	public int getAllPage(TProject project) throws Exception {
		int page = this.projectDao.getAllPage(project);
		return page;
	}

	public List<Map<String, String>> query(TProject project) throws Exception {
		this.projectDao.setCurrentPage(currentPage);
		List<Map<String, String>> projects = this.projectDao.query(project);
		return projects;
	}

	public TProject queryById(long id) throws Exception {
		// TODO Auto-generated method stub
		TProject project = this.projectDao.queryById(id);
		return project;
	}
	//红姐御用...
	public List<Map<String, String>> queryAllKV(String empId) throws Exception {
		// TODO Auto-generated method stub
		return this.projectDao.queryAllKV(empId);
	}

	public boolean save(TProject project) throws Exception {
		this.projectDao.save(project);
		return true;
	}

	public boolean update(TProject project) throws Exception {
		System.out.println("service project ID " + project.getId());
		this.projectDao.update(project);
		return true;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setProjectDao(IProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public List<Map<String, String>> getProjectPrps(String projectId)
			throws Exception {
		return this.projectDao.getProjectPrps(projectId);
	}

	public List<Map<String, String>> getProjectDepts(String projectId)
			throws Exception {
		
		return this.projectDao.getProjectDepts(projectId);
	}
    //批量删除
	
	public boolean deleteAll(List<String> ids) throws Exception {
		this.projectDao.deleteAll(ids);
		return true;
	}

	

	

}
