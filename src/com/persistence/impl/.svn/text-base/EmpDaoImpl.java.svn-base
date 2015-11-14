package com.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.TempFile;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.persistence.IDeptDao;
import com.persistence.IEmpDao;
import com.persistence.entity.TEmp;


public class EmpDaoImpl extends HibernateDaoSupport implements IEmpDao{
	private int currentPage = 1;
	private int pageSize = 5;
	//--------------------删除
	public boolean delete(TEmp emp) throws Exception {
		this.getHibernateTemplate().delete(emp);
		return true;
	}
	//----------------------得到总页数
	public int getAllPage(final TEmp emp,final String deptId) throws Exception {
		Object rows = this.getHibernateTemplate().execute(
			new HibernateCallback() {
 				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
 					String name = emp.getName();
 					String sex = emp.getSex();
 					String erole = emp.getErole();
 					String nation = emp.getNation();
 					
					StringBuilder hql = new StringBuilder("select count(*) from TEmp e join e.TDepts d where 1=1 and e.id != '1'");
					List<Object> params = new ArrayList<Object>();
					if(deptId != null && !deptId.equals("") && !deptId.equals("0")){
						hql.append(" and d.id = ?");
						params.add(Long.parseLong(deptId));
					}
					if(name != null && !name.equals("")){
						hql.append(" and e.name like ?");
						params.add("%"+name+"%");
					}
					if(sex != null && !sex.equals("") && !sex.equals("0")){
						hql.append(" and e.sex = ?");
						params.add(sex);
					}
					if(erole != null && !erole.equals("") && !erole.equals("0")){
						hql.append(" and e.erole = ?");
						params.add(erole);
					}
					if(nation != null && !nation.equals("") && !nation.equals("0")){
						hql.append(" and e.nation = ?");
						params.add(nation);
					}
					System.out.println("参数个数   " + params.size());
					Query q = session.createQuery(hql.toString());
					for(int i = 0;i < params.size(); i++){
					q.setParameter(i, params.get(i));
					}	
				return q.uniqueResult();
				}
			}
		);
		int allPage = (Integer.parseInt(rows.toString())+this.pageSize-1)/this.pageSize;
		System.out.println("dao>>>>>>>>>>>>>>"+allPage);
		return allPage;
	}
	//---------------------分页查询
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> find(final TEmp emp,final String deptId) throws Exception {
		return (List<Map<String, String>>) this.getHibernateTemplate().execute(
			new HibernateCallback() {
 				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
 					System.out.println(">>>>>>>>>Dao " + "currentPage" + currentPage);
 					String name = emp.getName();
 					String sex = emp.getSex();
 					String erole = emp.getErole();
 					String nation = emp.getNation();
 					
					StringBuilder hql = new StringBuilder(
							"select new map(d.id as did,e.id as id,d.name as dname,e.name as name,s1.fvalue as sex,s2.fvalue as erole,s3.fvalue as nation) " +
							"from TEmp e join e.TDepts d,TSyscode s1,TSyscode s2,TSyscode s3 " +
							"where e.id != '1' and s1.fname = 'sex' and s1.fkey = e.sex and s2.fname = 'eRole' and s2.fkey = e.erole and s3.fname = 'nation' and s3.fkey = e.nation");
					List<Object> params = new ArrayList<Object>();
					if(deptId != null && !deptId.equals("") && !deptId.equals("0")){
						hql.append(" and d.id = ?");
						params.add(Long.parseLong(deptId));
					}
					if(name != null && !name.equals("")){
						hql.append(" and e.name like ?");
						params.add("%"+name+"%");
					}
					if(sex != null && !sex.equals("") && !sex.equals("0")){
						hql.append(" and e.sex = ?");
						params.add(sex);
					}
					if(erole != null && !erole.equals("") && !erole.equals("0")){
						hql.append(" and e.erole = ?");
						params.add(erole);
					}
					if(nation != null && !nation.equals("") && !nation.equals("0")){
						hql.append(" and e.nation = ?");
						params.add(nation);
					}
					Query q = session.createQuery(hql.toString());
					for(int i = 0;i < params.size(); i++){
					q.setParameter(i, params.get(i));
					}	
					q.setMaxResults(pageSize);
					q.setFirstResult((currentPage-1)*pageSize);
					
					List<Map<String, String>> list = new ArrayList<Map<String,String>>();
					list = q.list();
					return list;
				}
			}
		);
	}
	//------------------按ID查询
	public TEmp getEmpById(long id) throws Exception {
		System.out.println(">>>>>>进入DAO");
		return (TEmp) this.getHibernateTemplate().get(TEmp.class, id);
		
	}
	//------------------查询员工和Id
	public List<Map<String, String>> getEmpOptions() throws Exception {
		String hql = "select new map(id as id,name as name) from TEmp";
		return this.getHibernateTemplate().find(hql);
		
	}

	public List<Map<String, String>> getUnselectedEmp(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	//-----------------------登录
	
	public TEmp login(TEmp emp) throws Exception {
		System.out.println("diaoyond>>>>>>>>>>>>>>>>aaaaa");
		List<Map<String, String>> users = null;
		String hql = "select new map(to_char(e.id) as id) from TEmp e where e.username = ? and e.userpassword = ?";
		Object[] params = {emp.getUsername(),emp.getUserpassword()};
		users = this.getHibernateTemplate().find(hql, params);
		System.out.println(users.size());
		
		TEmp emp1 =  null;
		
		if (users.size() != 0){
			long id = Long.parseLong(users.get(0).get("id"));
			emp1 = (TEmp)this.getHibernateTemplate().get(TEmp.class, id);
		}
		return emp1;
	}
	public boolean isUsed(String name){
		String hql = "select new map(name,userpassword) from TEmp where username = ?";
		List<TEmp> list = this.getHibernateTemplate().find(hql, name);
		if(list.size() != 0){
			return true;
		}else{
			return false;
		}
	}
	//-----------------------查询下属员工
	public List<Map<String, String>> queryofOneDept(long id) throws Exception {
		String id2 = null;
		String hql1 = "select new map(to_char(d.id) as id,d.name as name) from TEmp e join e.TDepts d where e.id = ? ";
		List<Map<String, String>> list = this.getHibernateTemplate().find(hql1, id);
		for(Map<String, String> map:list){
			id2= map.get("id");
		}
		System.out.println(id2);
		long id3 = Long.parseLong(id2);
		Object args[] = { id3,id };
		String hql = "select new map(to_char(e.id) as id,e.name as name) from TEmp e join e.TDepts d where d.id = ? and e.id != ?"; 
		List<Map<String, String>> list2 = this.getHibernateTemplate().find(hql,args);
		System.out.println(list2);
		return list2;
	}

	public List<Map<String, String>> queryEmpByDeptId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	//-----------------------------添加
	public boolean save(TEmp emp) throws Exception {
		System.out.println("姓名："+emp.getName());
		this.getHibernateTemplate().save(emp);
		return true;
	}
	//-----------------------------更新
	public boolean update(TEmp emp) throws Exception {
		this.getHibernateTemplate().update(emp);
		return true;
	}
    //------------
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Map<String, String>> getOldPassword(TEmp emp) throws Exception{
		String hql = "select new map(username as username,password as password) from TEmp"; 
		return this.getHibernateTemplate().find(hql);
	}
	//-----------------更改密码----------------
	public boolean updateNewPassword(TEmp emp) throws Exception {
		System.out.println("EMP  " + emp);
		this.getHibernateTemplate().merge(emp);
		return true;
	}
	//----------------找回密码-------------------
	public TEmp getBackPass(TEmp emp) throws Exception{
		String name = null;
		String password = null;
		String hql = "select new map(id as id ,userpassword as userpassword,username as username)" +
				" from TEmp where name = ? and email = ?";
		Object[] objs = {emp.getName(),emp.getEmail()};
		List<Map<String, String>> list = this.getHibernateTemplate().find(hql,objs);
		if(list.size() > 0){
			for(Map<String, String> map : list){
				name = map.get("username");
				password = map.get("userpassword");
			}
		}
		System.out.println("name + pass:" + name + password);
		TEmp emp1 = new TEmp();
		emp1.setUsername(name);
		emp1.setUserpassword(password);
		System.out.println("Dao 输出》》》》》"+emp1);
		return emp1;
	}
	public long queryEmpId(String empName) throws Exception {
		String idString = null;
		long id2;
		String hql = "select new map(to_char(e.id) as id) from TEmp e where e.name = ?";
		List<Map<String, String>> list = this.getHibernateTemplate().find(hql, empName);
		for(Map<String, String> map : list){
			idString = map.get("id");
		}
		if(idString != null){
			id2 = Long.parseLong(idString);
		}else{
			id2 = 0;
		}
		return id2;
	}
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IEmpDao empDao = (IEmpDao)ctx.getBean("empDao");
		
		boolean a = empDao.isUsed("liubang");
		System.out.println(a);
		//System.out.println(e.getName());
	}
}
