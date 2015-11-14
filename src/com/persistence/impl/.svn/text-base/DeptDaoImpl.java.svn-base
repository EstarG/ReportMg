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
	
	//删除部门
	public boolean delete(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(dept);
		return true;
	}

	public int getAllPage(TDept dept) throws Exception {
		// TODO Auto-generated method stub
		//获得条件参数
		final long id = dept.getId();
		final String name = dept.getName();
		final String pid = dept.getPid();
		final String phone = dept.getPhone();
		final String fax = dept.getFax();
		
		//回调获得总页数
		Object allPage = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					
					public Object doInHibernate(Session s) throws HibernateException,
							SQLException {
						// TODO Auto-generated method stub
						StringBuilder hql = new StringBuilder("select count(*) from TDept where 1 = 1 and pid > 0");
						List<Object> params = new ArrayList<Object>();
						
						//拼接HQL语句
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
						//利用session 获得Query
						Query q = s.createQuery(hql.toString());
						for (int i = 0; i < params.size(); ++i) {
							q.setParameter(i, params.get(i));
						}
						System.out.println("查询到的 总记录数      " + q.uniqueResult().toString());
						int allPage = (Integer.parseInt(q.uniqueResult().toString()) + pageSize - 1) / pageSize;
						System.out.println("总页数  " + allPage);
						return allPage;
					}
				}
		);
		
		return Integer.parseInt(allPage.toString());
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> query(TDept dept) throws Exception {
		//获得条件参数
		final long id = dept.getId();
		final String name = dept.getName();
		final String pid = dept.getPid();
		final String phone = dept.getPhone();
		final String fax = dept.getFax();
		
		List<Map<String,String>> depts = (ArrayList<Map<String,String>>)this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session s) throws HibernateException,
							SQLException {
						//记录查询所得数据
						List<Map<String,String>> depts = new ArrayList<Map<String,String>>();
						
						StringBuilder hql = new StringBuilder("select new map(d1.id as id, d1.name as name, d2.name as pname, d1.phone as phone, d1.fax as fax) from TDept d1,TDept d2 where d1.pid = d2.id");
						List<Object> params = new ArrayList<Object>();
						
						//拼接HQL语句
						
						if (id != 0) {
							hql.append(" and d1.id = ?");
							System.out.println("1 ID  = >>> " + id);
							params.add(id);
						}
						if (name != null && !name.trim().equals("") && !name.trim().equals("0")) {
							hql.append(" and d1.name like ?");
							params.add("%" + name + "%");
							System.out.println("参数 name  + " + name);
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
						
						//利用session 获得Query
						Query q = s.createQuery(hql.toString());
						for (int i = 0; i < params.size(); ++i) {
							q.setParameter(i, params.get(i));
						}
						System.out.println((currentPage - 1)*pageSize);
						q.setFirstResult((currentPage - 1)*pageSize);
						q.setMaxResults(pageSize);
						
						depts = q.list();
						System.out.println("查询到" + depts.size() + "条数据" + "参数个数为" + params.size());
						return depts;
					}
				}
		);
		return depts;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryAllKV() throws Exception {
		// TODO Auto-generated method stub
		//前两项在下拉列表中用，后一项在获得部门树时用。。
		List<Map<String, String>> deptOptions = this.getHibernateTemplate().find("select new map(to_char(d.id) as fkey, d.name as fvalue, d.pid as parentfkey) from TDept d ");
		
		return deptOptions;
	}
    
	//根据部门ID查找部门
	public TDept queryById(long id) throws Exception {
		// TODO Auto-generated method stub
		
		TDept dept = (TDept)this.getHibernateTemplate().get(TDept.class, id);
		return dept;
	}
    
	//是否可以一条语句查询 ,一条一条的查
	public Set<TDept> queryByIds(List<String> ids) throws Exception {
		Set<TDept> depts = new HashSet<TDept>();
		
		for (int i = 0; i < ids.size(); ++i) {
			TDept dept = queryById(Long.parseLong(ids.get(i)));
			depts.add(dept);
		}
		return depts;
	}
    
	//根据项目ID查找配置到该项目的部门 
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryConfiged(String id) throws Exception {
		String hql = "select new map(d.id, d.name) from TDept d, d.TProjects p where p.projectId = ? and p.deptId = d.id";
		List<Map<String, String>> deptOptions = this.getHibernateTemplate().find(hql, id);
		return deptOptions;
	}
    
	//添加部门
	public boolean save(TDept dept) throws Exception {
		System.out.println(this.getHibernateTemplate());
		this.getHibernateTemplate().save(dept);
		return true;
	}
    //更新部门
	public boolean update(TDept dept) throws Exception {
		this.getHibernateTemplate().merge(dept);
		return true;
	}
	//根据部门的ID查找部门的员工
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
		dept.setName("质量部");
		dept.setPhone("12345");
		dept.setFax("12345");
		dept.setPid("0");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IDeptDao deptDao = (IDeptDao)ctx.getBean("deptDao");
		deptDao.save(dept);
		
	}

}
