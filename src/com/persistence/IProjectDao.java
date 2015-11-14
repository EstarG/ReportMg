package com.persistence;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.persistence.entity.TProject;

public interface IProjectDao {
	
	boolean	save(TProject project) throws Exception;
	boolean	delete(TProject project) throws Exception;
	boolean	update(TProject project) throws Exception;
	TProject	queryById(long id) throws Exception;
	List<Map<String,String>>	query(TProject project) throws Exception;
	boolean	configPrp(TProject project,List<String> ids) throws Exception;
	boolean	configDept(TProject project,List<String> ids) throws Exception;
	boolean	ConfigEmp(TProject project,Set<String> ids) throws Exception;
	int 	getAllPage(TProject project) throws Exception;
	
	public void setCurrentPage(int currentPage);
	//����Ա��id�����Ŀ��K-V
	public List<Map<String,String>> queryAllKV(String empId)throws Exception;
    //����ɾ��
	public boolean deleteAll(List<String> ids) throws Exception ;
	//snow
	public List<Map<String, String>> getProjectPrps(String projectId) throws Exception;
	public List<Map<String, String>> getProjectDepts(String projectId) throws Exception; 
}
