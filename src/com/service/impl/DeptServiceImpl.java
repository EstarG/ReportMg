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
	
	//ɾ������
	public boolean delete(TDept dept) throws Exception {
		//System.out.println("service Ҫɾ���Ķ����ID "  + dept.getId());
		//����ɾ��ʱ����Ӧ�����Ȼ�øĶ����ʵ��
		this.deptDao.delete(deptDao.queryById(dept.getId()));
		return true;
	}
   
	//��ò�ѯʱ����ҳ��
	public int getAllPage(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		int total = this.deptDao.getAllPage(dept);
		return total;
	}
   
	//����������ѯ
	public List<Map<String, String>> query(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		this.deptDao.setCurrentPage(currentPage);
		List<Map<String, String>> depts = this.deptDao.query(dept);
		return depts;
	}
    //������в��ŵ�K - V
	public List<Map<String, String>> queryAllKV() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, String>> depts = this.deptDao.queryAllKV();
		return depts;
	}
    
	//����ID���Ҳ���
	public TDept queryById(long id) throws Exception {
		// TODO Auto-generated method stub
		TDept dept = this.deptDao.queryById(id);
		return dept;
	}
    //����IDs���ҳ�����ID de ����
	public Set<TDept> queryByIds(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		Set<TDept> depts = this.deptDao.queryByIds(ids);
		return depts;
	}
    
	//������ĿID��������õ�����Ŀ�Ĳ���
	public List<Map<String, String>> queryConfiged(String id) throws Exception {
		List<Map<String, String>> depts = this.deptDao.queryConfiged(id);
		return depts;
	}
    //���沿��
	public boolean save(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		this.deptDao.save(dept);
		return true;
	}
    //���²���
	public boolean update(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		this.deptDao.update(dept);
		return true;
	}
	//���ݲ���ID���Ҹò��ŵ�Ա��
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
