package com.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lowagie.text.PageSize;
import com.persistence.IDeptDao;
import com.persistence.entity.TDept;
import com.persistence.entity.TEmp;

public class DeptDaoImpl extends HibernateDaoSupport implements IDeptDao {
    
	private int pageSize = 5;
	private int currentPage = 1;
	
	//ɾ������
	public boolean delete(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(dept);
		return true;
	}

	public int getAllPage(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		//�����������
		final long id = dept.getId();
		final String name = dept.getName();
		final String pid = dept.getPid();
		final String phone = dept.getPhone();
		final String fax = dept.getFax();
		
		//�ص������ҳ��
		Object allPage = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					
					public Object doInHibernate(Session s) throws HibernateException,
							SQLException {
						// TODO Auto-generated method stub
						StringBuilder hql = new StringBuilder("select count(*) from TDept where 1 = 1 and pid > 0");
						List<Object> params = new ArrayList<Object>();
						
						//ƴ��HQL���
						if (id != 0) {
							hql.append(" and id = ?");
							params.add(id);
						}
						if (name != null && !name.trim().equals("") && !name.trim().equals("0")) {
							hql.append(" and name like ?");
							params.add("%" + name + "%");
						}
						if (pid != null && !pid.trim().equals("") && !pid.trim().equals("0")) {
							hql.append(" and pid = ?");
							params.add(pid);
						}
						if (phone != null && !phone.trim().equals("") && !phone.trim().equals("0")) {
							hql.append(" and phone = ?");
							params.add(phone);
						}
						if (fax != null && !fax.trim().equals("") && !fax.trim().equals("0")) {
							hql.append(" and fax = ?");
							params.add(fax);
						}
						//����session ���Query
						Query q = s.createQuery(hql.toString());
						for (int i = 0; i < params.size(); ++i) {
							q.setParameter(i, params.get(i));
						}
						System.out.println("��ѯ���� �ܼ�¼��      " + q.uniqueResult().toString());
						int allPage = (Integer.parseInt(q.uniqueResult().toString()) + pageSize - 1) / pageSize;
						System.out.println("��ҳ��  " + allPage);
						return allPage;
					}
				}
		);
		
		return Integer.parseInt(allPage.toString());
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> query(TDept dept) throws Exception {
		//�����������
		final long id = dept.getId();
		final String name = dept.getName();
		final String pid = dept.getPid();
		final String phone = dept.getPhone();
		final String fax = dept.getFax();
		
		List<Map<String,String>> depts = (ArrayList<Map<String,String>>)this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session s) throws HibernateException,
							SQLException {
						//��¼��ѯ��������
						List<Map<String,String>> depts = new ArrayList<Map<String,String>>();
						
						StringBuilder hql = new StringBuilder("select new map(d1.id as id, d1.name as name, d2.name as pname, d1.phone as phone, d1.fax as fax) from TDept d1,TDept d2 where d1.pid = d2.id");
						List<Object> params = new ArrayList<Object>();
						
						//ƴ��HQL���
						
						if (id != 0) {
							hql.append(" and d1.id = ?");
							System.out.println("1 ID  = >>> " + id);
							params.add(id);
						}
						if (name != null && !name.trim().equals("") && !name.trim().equals("0")) {
							hql.append(" and d1.name like ?");
							params.add("%" + name + "%");
							System.out.println("���� name  + " + name);
						}
						if (pid != null && !pid.trim().equals("") && !pid.trim().equals("0")) {
							hql.append(" and d1.pid = ?");
							params.add(pid);
						}
						if (phone != null && !phone.trim().equals("") && !phone.trim().equals("0")) {
							hql.append(" and d1.phone = ?");
							params.add(phone);
						}
						if (fax != null && !fax.trim().equals("") && !fax.trim().equals("0")) {
							hql.append(" and d1.fax = ?");
							params.add(fax);
						}
						
						//����session ���Query
						Query q = s.createQuery(hql.toString());
						for (int i = 0; i < params.size(); ++i) {
							q.setParameter(i, params.get(i));
						}
						System.out.println((currentPage - 1)*pageSize);
						q.setFirstResult((currentPage - 1)*pageSize);
						q.setMaxResults(pageSize);
						
						depts = q.list();
						System.out.println("��ѯ��" + depts.size() + "������" + "��������Ϊ" + params.size());
						return depts;
					}
				}
		);
		return depts;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryAllKV() throws Exception {
		// TODO Auto-generated method stub
		//ǰ�����������б����ã���һ���ڻ�ò�����ʱ�á���
		List<Map<String, String>> deptOptions = this.getHibernateTemplate().find("select new map(to_char(d.id) as fkey, d.name as fvalue, d.pid as parentfkey) from TDept d ");
		
		return deptOptions;
	}
    
	//���ݲ���ID���Ҳ���
	public TDept queryById(long id) throws Exception {
		// TODO Auto-generated method stub
		
		TDept dept = (TDept)this.getHibernateTemplate().get(TDept.class, id);
		return dept;
	}
    
	//�Ƿ����һ������ѯ ,һ��һ���Ĳ�
	public Set<TDept> queryByIds(List<String> ids) throws Exception {
		Set<TDept> depts = new HashSet<TDept>();
		
		for (int i = 0; i < ids.size(); ++i) {
			TDept dept = queryById(Long.parseLong(ids.get(i)));
			depts.add(dept);
		}
		return depts;
	}
    
	//������ĿID�������õ�����Ŀ�Ĳ��� 
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryConfiged(String id) throws Exception {
		String hql = "select new map(d.id, d.name) from TDept d, d.TProjects p where p.projectId = ? and p.deptId = d.id";
		List<Map<String, String>> deptOptions = this.getHibernateTemplate().find(hql, id);
		return deptOptions;
	}
    
	//��Ӳ���
	public boolean save(TDept dept) throws Exception {
		System.out.println(this.getHibernateTemplate());
		this.getHibernateTemplate().save(dept);
		return true;
	}
    //���²���
	public boolean update(TDept dept) throws Exception {
		this.getHibernateTemplate().merge(dept);
		return true;
	}
	//���ݲ��ŵ�ID���Ҳ��ŵ�Ա��
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> deptEmps(String deptId) throws Exception {
		String hql = "select new map(e.id as id, e.name as name) from TDept d join d.TEmps e where d.id = ?";
		return this.getHibernateTemplate().find(hql, Long.parseLong(deptId.trim()));	
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
	
	public static void main(String args[]) throws Exception {
		TDept dept = new TDept();
		dept.setName("������");
		dept.setPhone("12345");
		dept.setFax("12345");
		dept.setPid("0");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IDeptDao deptDao = (IDeptDao)ctx.getBean("deptDao");
		deptDao.save(dept);
		
	}

}
