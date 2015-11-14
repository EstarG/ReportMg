package com.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.persistence.entity.TDept;

public interface IDeptService {
	//���Ӳ���
	boolean	save(TDept dept) throws Exception;
	//ɾ������
	boolean	delete(TDept dept)throws Exception;
	//���²���
	boolean	update(TDept dept)throws Exception;
	//����
	TDept	queryById(long id)throws Exception;
	List<Map<String,String >>	query(TDept dept)throws Exception;
	int 	getAllPage(TDept dept)throws Exception;
	List<Map<String,String >>	queryAllKV()throws Exception;
	Set<TDept>	queryByIds(List<String> ids)throws Exception;
	List<Map<String,String>>	queryConfiged(String id)throws Exception;
	//���ݲ���ID��øò��ŵ�Ա��
	List<Map<String, String>> deptEmps(String deptId) throws Exception;
	
	public void setCurrentPage(int currentPage);
	public void setPageSize(int pageSize);
}
