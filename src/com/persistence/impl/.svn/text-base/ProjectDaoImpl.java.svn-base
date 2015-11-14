package com.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;
import com.persistence.IDeptDao;
import com.persistence.IProjectDao;
import com.persistence.entity.TDept;
import com.persistence.entity.TEmp;
import com.persistence.entity.TProject;
import com.persistence.entity.TPrp;

public class ProjectDaoImpl extends HibernateDaoSupport implements IProjectDao {

	private int currentPage = 1;
	private int pageSize = 4;

	//给项目配置员工
	public boolean ConfigEmp(TProject project, Set<String> ids)
			throws Exception {
		 //首先该对象已经在Actionn获得。并且拥有了个个的负责人。。
       System.out.println("输出项目ID " + project.getId() + " " + project.getName() + " " + project.getMkmanager());
        //自己new 一个set然后在往里面放
        Set<TEmp> emps = new HashSet<TEmp>();
        for (String s : ids) {
			System.out.println("员工 I  ：" + s);
			emps.add(new TEmp(Long.parseLong(s)));
        }
		//将set放入
		project.setTEmps(emps);
		this.getHibernateTemplate().saveOrUpdate(project);
		return true;
	}
    
	//给项目配置部门
	@SuppressWarnings("unchecked")
	public boolean configDept(TProject project, List<String> ids)
			throws Exception {
        System.out.println("要配置的项目号 : +   " + project.getId());
        
        //首先获得对象
        project = this.queryById(project.getId());
        System.out.println("project name =  " + project.getName() + " 部门个数  " + ids.size());
        //自己new 一个set然后在往里面放
        Set<TDept> depts = new HashSet<TDept>();
		for (int i = 0; i < ids.size(); ++i) {
			depts.add(new TDept(Long.parseLong(ids.get(i))));
		}
		project.setTDepts(depts);
		//???????  到底改怎么处理
		//??必须是对象project??  如果dept存在还是会加入啊。。
		//this.getHibernateTemplate().saveOrUpdate(project);  这样如果在第三张表有过的dept还会加入进去。。
		this.getHibernateTemplate().saveOrUpdate(project);
		return true;
	}

	//给项目配置PRp
	@SuppressWarnings("unchecked")
	public boolean configPrp(TProject project, List<String> ids)
			throws Exception {
		
		  //首先获得对象
        project = this.queryById(project.getId());
        System.out.println("project name =  " + project.getName() );
        //必须首先自己建立set
        Set<TPrp> prps = new HashSet<TPrp>();
		for (int i = 0; i < ids.size(); ++i) {
			prps.add(new TPrp(Long.parseLong(ids.get(i).trim())));
		}
		project.setTPrps(prps);
		this.getHibernateTemplate().saveOrUpdate(project);
		return true;
	}

	public boolean delete(TProject project) throws Exception {
		this.getHibernateTemplate().delete(project);
		return true;
	}
	
	public boolean deleteAll(List<String> ids) throws Exception {
		Set<TProject> pros = new HashSet<TProject>();
		TProject project = null;
		for (int i = 0; i < ids.size(); ++i) {
			System.out.println("要删除对象的id " + ids.get(i));
			pros.add(new TProject(Long.parseLong(ids.get(i).trim())));
		}
		this.getHibernateTemplate().deleteAll(pros);
		return true;
	}

	@SuppressWarnings("unchecked")
	public int getAllPage(TProject project) throws Exception {
		// 多种条件
		final String projectId = project.getProjectid();
		final String name = project.getName();
		final Date beginDate = project.getBegindate();
		final Date endDate = project.getEnddate();
		final String status = project.getStatus();
		final String pManager = project.getPmanager();
		final String rdManger = project.getRdmanager();
		final String mkManager = project.getMkmanager();
		final String qtManager = project.getQtmanager();
		final String other = project.getOther();

		//
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session s)
							throws HibernateException, SQLException {
						// 记录查询所得数据

						StringBuilder hql = new StringBuilder(
								"select count(*) from TProject p where 1 = 1");
						List<Object> params = new ArrayList<Object>();

						// 拼接HQL语句
						if (projectId != null && !projectId.trim().equals("")
								&& !projectId.trim().equals("0")) {
							hql.append(" and p.projectid = ?");
							params.add(projectId);
							System.out.println(">>>>>>>>>1 " + projectId);
						}
						if (name != null && !name.trim().equals("")
								&& !name.trim().equals("0")) {
							hql.append(" and p.name like ?");
							params.add("%" + name + "%");
							System.out.println(">>>>>>>>>2 " + name);
						}
						if (beginDate != null) {
							hql.append(" and p.begindate >= ?");
							params.add(beginDate);
							System.out.println(">>>>>>>>>3 " + beginDate);
						}
						if (endDate != null) {
							hql.append("and p.enddate <= ?");
							params.add(endDate);
							System.out.println(">>>>>>>>>4 " + endDate);
						}
						if (status != null && !status.trim().equals("")
								&& !status.trim().equals("0")) {
							hql.append(" and p.status = ?");
							params.add(status);
							System.out.println(">>>>>>>>>5 " + status);
						}
						
						//根据得到的的输入的相关人员找到他参与的项目 other值保存了你输入的员工ID
						if (other != null && !other.trim().equals("")) {
							//可能是项目负责人
							hql.append(" and p.pmanager like ?");
							params.add("%" + other + "%");
							//可能是研发负责人
							hql.append(" or p.rdmanager like ?");
							params.add("%" + other + "%");
							//可能是市场负责人
							hql.append(" or p.mkmanager like ?");
							params.add("%" + other + "%");
							//质量负责人
							hql.append(" or p.qtmanager like ?");
							params.add("%" + other + "%");
							//其他
							hql.append(" or p.other like ?");
							params.add("%" + other + "%");
						}

						System.out.println("参数拼接结束....." + hql.toString());
						// 利用session 获得Query
						Query q = s.createQuery(hql.toString());

						for (int i = 0; i < params.size(); ++i) {
							System.out.println("参数   " + i + "   "
									+ params.get(i));
							q.setParameter(i, params.get(i));
						}
						Object allPage = q.uniqueResult();
						return allPage;
					}
				});
		return (Integer.parseInt(obj.toString()) + pageSize - 1) / pageSize;
	}
    
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> query(TProject project) throws Exception {
		// 多种条件
		final String projectId = project.getProjectid();
		final String name = project.getName();
		final Date beginDate = project.getBegindate();
		final Date endDate = project.getEnddate();
		final String status = project.getStatus();
		
		final String other = project.getOther();

		//
		List<Map<String, String>> projects = (ArrayList<Map<String, String>>) this
				.getHibernateTemplate().execute(new HibernateCallback() {
					public Object doInHibernate(Session s)
							throws HibernateException, SQLException {
						// 记录查询所得数据
						List<Map<String, String>> projects = new ArrayList<Map<String, String>>();

						StringBuilder hql = new StringBuilder(
								"select new map(p.id as id, p.projectid as projectId, p.name as name, to_char(p.begindate, 'yyyy-mm-dd') as beginDate, to_char(p.enddate,'yyyy-mm-dd') as endDate, s.fvalue as status) from TProject p, TSyscode s where s.fname = 'pstatus' and s.fkey = p.status ");
						List<Object> params = new ArrayList<Object>();

						// 拼接HQL语句
						if (projectId != null && !projectId.trim().equals("")
								&& !projectId.trim().equals("0")) {
							hql.append(" and p.projectid = ?");
							params.add(projectId);
						}
						if (name != null && !name.trim().equals("")
								&& !name.trim().equals("0")) {
							hql.append(" and p.name like ?");
							params.add("%" + name + "%");
						}
						if (beginDate != null) {
							hql.append(" and p.begindate >= ?");
							params.add(beginDate);
						}
						if (endDate != null) {
							hql.append(" and p.enddate <= ?");
							params.add(endDate);
						}
						if (status != null && !status.trim().equals("")
								&& !status.trim().equals("0")) {
							hql.append(" and p.status = ?");
							params.add(status);
						}
						
						
						//根据得到的的输入的相关人员找到他参与的项目 other值保存了你输入的员工ID
						if (other != null && !other.trim().equals("")) {
							//可能是项目负责人
							hql.append(" and ( p.pmanager like ?");
							params.add("%" + other + "%");
							//可能是研发负责人
							hql.append(" or p.rdmanager like ?");
							params.add("%" + other + "%");
							//可能是市场负责人
							hql.append(" or p.mkmanager like ?");
							params.add("%" + other + "%");
							//质量负责人
							hql.append(" or p.qtmanager like ?");
							params.add("%" + other + "%");
							//其他
							hql.append(" or p.other like ?) ");
							params.add("%" + other + "%");
						}
						
						hql.append(" order by p.begindate");

						// 利用session 获得Query
						Query q = s.createQuery(hql.toString());
						for (int i = 0; i < params.size(); ++i) {
							q.setParameter(i, params.get(i));
						}
						System.out.println("dao  当前页   ..." + currentPage );
						
						// 设置页面
						q.setFirstResult((currentPage - 1) * pageSize);
						q.setMaxResults(pageSize);

						projects = q.list();
						System.out.println(".......查询到项目数  " + projects.size()
								+ "参数个数" + params.size());
						System.out.println(" 项目   " + projects);
						return projects;
					}
				});

		return projects;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Map<String,String>> queryAllKV(String empId) throws Exception {
			System.out.println(" 员工ID =  " + empId);
		    String hql = "select new map(to_char(p.id) as id, p.name as name) from TProject p join p.TEmps e where e.id = ?";
			return this.getHibernateTemplate().find(hql, Long.parseLong(empId.trim()));
	}

	public TProject queryById(long id) throws Exception {
		// TODO Auto-generated method stub
		TProject project = (TProject) this.getHibernateTemplate().get(
				TProject.class, id);
		return project;
	}

	public boolean save(TProject project) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(project);
		return true;
	}

	public boolean update(TProject project) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("update  " + project);
		//System.out.println("update project 。。。" + project.getBegindate() + "  "
				//+ project.getEnddate());
		//this.getHibernateTemplate().merge(project);
		this.getHibernateTemplate().update(project);
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

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> getProjectPrps(String projectId)
			throws Exception {
		System.out.println("PRP   部门 ID>>" + projectId);
		
		String hql = "select new map(to_char(prp.id) as id, prp.abbreviate as ab, prp.name as name, prp.remarks as remarks) from TProject pro join pro.TPrps prp"
				+ " where pro.id = ?";
		
		List<Map<String, String>> pro_prps = this.getHibernateTemplate().find(hql, Long.parseLong(projectId.trim()));
		
		for (Map<String, String> r : pro_prps) {
			for (String key : r.keySet()) {
				System.out.println(key + "  " + r.get(key));
			}
		}
		
		return pro_prps;
	}
	

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> getProjectDepts(String projectId)
			throws Exception {
		String hql = "select new map(to_char(d.id) as id, d.name as name) from TProject p join p.TDepts d where p.id = ?";
		System.out.println("项目   " + projectId + "所对应的部门：");
		
		//List<Map<String, Object>> result = (List<Map<String, Object>>) this.getHibernateTemplate().find(hql, Long.parseLong(projectId));
		List<Map<String, String>> pro_depts = (List<Map<String, String>>) this.getHibernateTemplate().find(hql, Long.parseLong(projectId));
		
		System.out.println(">>>>>调用");
		
		for (Map<String, String> m : pro_depts) {
			for (String s : m.keySet()) {
				System.out.println(s + "  :  " + m.get(s));
			}
		}
		return pro_depts;
	}
	
	
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IProjectDao pDao = (IProjectDao)ctx.getBean("projectDao");
		
		List<Map<String,String>> ps = (List<Map<String,String>>)pDao.queryAllKV("101");
		
		for (Map<String,String> m : ps) {
				for (String key : m.keySet()) {
					System.out.println(key + " : " + m.get(key));
				}
			
		}
	}
}
