package com.persistence.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.servlet.theme.SessionThemeResolver;

import com.persistence.IReportDao;

import com.persistence.entity.TReport;

public class ReportDaoImpl extends HibernateDaoSupport implements IReportDao {
	
	private int MaxResult=3;
	private int currentPage=1;
	//更新操作
	public boolean update(TReport report) throws Exception {
		this.getHibernateTemplate().merge(report);
			return true;
		}
	//删除操作
	public boolean delete(TReport report) throws Exception {
		System.out.println("dao report ID " + report.getId());
		this.getHibernateTemplate().delete(this.queryEntityById(report.getId()));
		return true;
	}
	
	public TReport queryEntityById(long id) {
		return (TReport)this.getHibernateTemplate().get(TReport.class, id);
	}
	//根据id查询
	public Map<String, Object> queryById(final long id) throws Exception {
		System.out.println("dao id"+id);
		TReport report =(TReport)this.getHibernateTemplate().get(TReport.class, id);
		Map<String, Object> mReport = new HashMap<String, Object>();
		mReport.put("id", report.getId()+"");
		mReport.put("empId", report.getTEmp().getId()+"");
		mReport.put("projectId", report.getTProject().getId()+"");
		System.out.println("PRP Name " + report.getTPrp().getName());
		mReport.put("prpName",report.getTPrp().getName());
		
		mReport.put("prpId", report.getTPrp().getId()+"");
		mReport.put("status", report.getStatus());
		mReport.put("task", report.getTask());
		mReport.put("workload", report.getWorkload());
		mReport.put("overtime", report.getOvertime());
		mReport.put("cdate", report.getCdate());
		System.out.println("dao id"+mReport);
		return mReport;
	}
	//点击获取单个日报的详细信息
	@SuppressWarnings("unchecked")
	public List<Map<String,String>> queryOne(final long id){
		return	(List<Map<String,String>>)this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
			
				StringBuilder hql=new StringBuilder("select new map(r.id as id,r.auditCause as auditCause,e.name as empid,p.name as prpid,pr.name as projectid,to_char(r.cdate,'yyyy-mm-dd') as cdate,r.task as task,r.workload as workload,r.overtime as overtime,s.fvalue as status) from TReport r,TSyscode s,TPrp p,TProject pr,TEmp e where s.fname='rstatus' and s.fkey=r.status and r.TEmp.id=e.id and r.TPrp.id=p.id and pr.id = r.TProject.id and r.id=?");
				
				
				Query q = s.createQuery(hql.toString());
					q.setParameter(0, id);
			    List<Map<String, String>> reports = q.list();
			   
				return reports;
			}
		});
	}
	//单击日期,显示此日期下的日报信息
	@SuppressWarnings("unchecked")
	public List<Map<String,String>> queryDate(final String cdate){
		return	(List<Map<String,String>>)this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
			
				StringBuilder hql=new StringBuilder("select new map(r.id as id,e.name as empid,p.name as prpid,pr.name as projectid,to_char(r.cdate,'yyyy-mm-dd') as cdate,r.task as task,r.workload as workload,r.overtime as overtime,s.fvalue as status) from TReport r join r.TProject pr join r.TPrp p join r.TEmp e,TSyscode s " +
						"where s.fname='rstatus' and s.fkey=r.status  and r.cdate=to_date(?,'yyyy-mm-dd') order by r.id");
				
				
				Query q = s.createQuery(hql.toString());
				q.setParameter(0, cdate);
				q.setMaxResults(MaxResult);
				q.setFirstResult((currentPage-1)*MaxResult);
			    List<Map<String, String>> reports = q.list();
			   
				return reports;
			}
		});
	}
	public int queryAllPageOneDate(final String cdate){
		Object rows=this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				StringBuilder hql=new StringBuilder("select count(*) from TReport r where  r.cdate=to_date(?,'yyyy-mm-dd')");
				
				Query q = s.createQuery(hql.toString());
				
				q.setParameter(0, cdate);
				  Object all = 0;
	               all = q.uniqueResult();
	               if (all == null) all = 0;
	            	
				return all;
			}
		});
		
		int allPage = (Integer.parseInt(rows.toString())+MaxResult-1)/MaxResult;
		
		return allPage;
	}
	//添加
	public boolean save(TReport report) throws Exception {
		this.getHibernateTemplate().save(report);
		return true;
	}

	//多条件查询
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> query(final TReport report) {
		return	(List<Map<String,String>>)this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				StringBuilder hql=new StringBuilder("select new map(r.id as id,e.name as empid,p.name as prpid,pr.name as projectid,to_char(r.cdate,'yyyy-mm-dd') as cdate,r.task as task,r.workload as workload,r.overtime as overtime,s.fvalue as status) from TReport r join r.TEmp e join r.TProject pr join r.TPrp p,TSyscode s where s.fname='rstatus' and s.fkey=r.status   and r.TEmp.id=?");
				
				List<Object> param = new ArrayList<Object>();
				String begin = report.getBegin(); 
				String end = report.getEnd();
				String status =report.getStatus();
				long prp = report.getTPrp().getId();
				long project = report.getTProject().getId();
				long emp = report.getTEmp().getId();
				
				String task = report.getTask();
				
				param.add(emp);
				if(begin!=null && !begin.equals("")){
					hql.append(" and r.cdate>to_date(?,'yyyy-mm-dd')");
					param.add(begin);
				}
				if(end!=null && !end.equals("")){
					hql.append(" and r.cdate<to_date(?,'yyyy-mm-dd')");
					param.add(end);
				}
				if(status!=null&& !status.equals("")&& !status.equals("0")){
					hql.append(" and r.status=?");
					param.add(status);
				}
				if(project!=0 ){
					hql.append(" and r.TProject.id=?");
					param.add(project);
				}
				if(prp!=0 ){
					hql.append(" and r.TPrp.id=?");
					param.add(prp);
				}
				
				if(task!=null&& !task.equals("")){
					hql.append(" and r.task like ?");
					param.add("%"+task+"%");
				}
				
				Query q = s.createQuery(hql.toString());
				
				
				for(int i = 0;i<param.size();i++){
					System.out.println("参数 " + i + "  " + param.get(i));
					q.setParameter(i, param.get(i));
				}
				q.setMaxResults(MaxResult);
				q.setFirstResult((currentPage-1)*MaxResult);
			    List<Map<String, String>> reports = q.list();
			    System.out.println("参数个数  " + param.size() + " 查找到的个数     " + reports.size() );
				return reports;
			}
		});
		
	}

	//查询总页数
	public int queryAllPage(final TReport report) {
		Object rows=this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				StringBuilder hql=new StringBuilder("select count(*) from TReport r where  r.TEmp.id=?");
				List<Object> param = new ArrayList<Object>();
				String begin = report.getBegin();
				String end = report.getEnd();
				String status =report.getStatus();
				long project = report.getTProject().getId();
				long emp = report.getTEmp().getId();
				String task = report.getTask();
				param.add(emp);
				if(begin!=null && !begin.equals("")){
					hql.append(" and r.cdate>to_date(?,'yyyy-mm-dd')");
					param.add(begin);
				}
				if(end!=null && !end.equals("")){
					hql.append(" and r.cdate<to_date(?,'yyyy-mm-dd')");
					param.add(end);
				}
				if(status!=null&& !status.equals("")&& !status.equals("0")){
					hql.append(" and r.status=?");
					param.add(status);
				}
				if(project!=0 ){
					hql.append(" and r.TProject.id=?");
					param.add(project);
				}
				
				
				
				if(task!=null&& !task.equals("")&& !task.equals("0")){
					hql.append(" and r.task like ?");
					param.add("%"+task+"%");
				}
				
				Query q = s.createQuery(hql.toString());
				
				
				for(int i = 0;i<param.size();i++){
					q.setParameter(i, param.get(i));
				}
				  Object all = 0;
	                all = q.uniqueResult();
	                if (all == null) all = 0;
	            	
				return all;
			}
		});
		
		int allPage = (Integer.parseInt(rows.toString())+MaxResult-1)/MaxResult;
		return allPage;
	}


	//日报查询：根据时间段查询
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryByDate(final TReport report) {
		return	(ArrayList<Map<String,String>>)this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				
				StringBuilder hql=new StringBuilder("select new map(to_char(r.cdate,'yyyy-mm-dd') as cdate,sum(r.workload) as workload,sum(r.overtime) as overtime) from TReport r where 1=1");	
				List<Object> param = new ArrayList<Object>();
				String begin = report.getBegin();
				String end = report.getEnd();
				long emp = report.getTEmp().getId();
				if(begin!=null && !begin.equals("")){
					hql.append(" and r.cdate>to_date(?,'yyyy-mm-dd')");
					param.add(begin);
				}
				if(end!=null && !end.equals("")){
					hql.append(" and r.cdate<to_date(?,'yyyy-mm-dd')");
					param.add(end);
				}
				
				
				if(emp!=0 ){
					hql.append(" and r.TEmp.id=?");
					param.add(emp);
				}
				hql.append(" group by r.cdate order by r.cdate desc ");
				Query q = s.createQuery(hql.toString());
				for(int i = 0;i<param.size();i++){
					q.setParameter(i, param.get(i));
				}
				q.setMaxResults(MaxResult);
				q.setFirstResult((currentPage-1)*MaxResult);
				List<Map<String, String>> list = new ArrayList<Map<String,String>>();
				list = q.list();
				return list;
			}
		});
		
	}

	public int queryAllPageDate(final TReport report) {
		Object rows=this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				StringBuilder hql=new StringBuilder("select sum(count(distinct r.cdate)) from TReport r where 1=1");
				List<Object> param = new ArrayList<Object>();
				String begin = report.getBegin();
				String end = report.getEnd();			
				long emp = report.getTEmp().getId();
				if(begin!=null && !begin.equals("")){
					hql.append(" and r.cdate>to_date(?,'yyyy-mm-dd')");
					param.add(begin);
				}
				if(end!=null && !end.equals("")){
					hql.append(" and r.cdate<to_date(?,'yyyy-mm-dd')");
					param.add(end);
				}
				if(emp!=0 ){
					hql.append(" and r.TEmp.id=?");
					param.add(emp);
				}
				hql.append(" group by r.cdate ");
				Query q = s.createQuery(hql.toString());
				
				
				for(int i = 0;i<param.size();i++){
					q.setParameter(i, param.get(i));
				}
			
                Object all = 0;
                all = q.uniqueResult();
                if (all == null) all = 0;
            	
				return all;
			}
		}
		);
		
		int allPage = (Integer.parseInt(rows.toString())+MaxResult-1)/MaxResult;
		return allPage;
	}


	//日报查询：根据项目查询
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryByProject(final TReport report) {
		return	(ArrayList<Map<String,String>>)this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				

				StringBuilder hql=
					new StringBuilder(
					"select p.name as project,re.workload as workload,re.overtime as overtime "+
					"from (select r.projectid as projectid,sum(r.workload) as workload,sum(r.overtime) as overtime "+
							"from t_report r where 1=1");
				
				List<Object> param = new ArrayList<Object>();
				
				
				String begin = report.getBegin();
				String end = report.getEnd();
				long emp = report.getTEmp().getId();
				if(begin!=null && !begin.equals("")){
					hql.append(" and r.cdate>to_date(?,'yyyy-mm-dd')");
					param.add(begin);
				}
				if(end!=null && !end.equals("")){
					hql.append(" and r.cdate<to_date(?,'yyyy-mm-dd')");
					param.add(end);
				}	
				if(emp!=0 ){
					hql.append(" and r.empid=?");
					param.add(emp);
				}
				hql.append(" group by r.projectid ) re,"+
							"(select p.id as id ,p.name as name from t_project p )p "+
							
							"where p.id=re.projectid");
				Query q = s.createSQLQuery(hql.toString());
				for(int i = 0;i<param.size();i++){
					q.setParameter(i, param.get(i));
				}
				q.setMaxResults(MaxResult);
				q.setFirstResult((currentPage-1)*MaxResult);
				List<Object[]> list = q.list();
				List<Map<String,String>> listReport = new ArrayList<Map<String,String>>();
				Map<String, String> map =null;
				for(Object[] obj:list){
						map = new HashMap<String, String>();
						map.put("project",obj[0].toString() );
						map.put("workload",obj[1].toString() );
						map.put("overtime",obj[2].toString() );
						listReport.add(map);
						System.out.println(obj[0].toString()+"    "+obj[1].toString()+"   "+obj[2].toString());
				}
				return listReport;
			}
		});
		
	}

	public int queryAllPageProject(final TReport report) {
		Object rows=this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				StringBuilder hql=new StringBuilder("select sum(count(distinct r.TProject.id)) from TReport r,TProject p where r.TProject.id=p.id");
				List<Object> param = new ArrayList<Object>();
				String begin = report.getBegin();
				String end = report.getEnd();			
				long emp = report.getTEmp().getId();
				if(begin!=null && !begin.equals("")){
					hql.append(" and r.cdate>to_date(?,'yyyy-mm-dd')");
					param.add(begin);
				}
				if(end!=null && !end.equals("")){
					hql.append(" and r.cdate<to_date(?,'yyyy-mm-dd')");
					param.add(end);
				}
				if(emp!=0 ){
					hql.append(" and r.TEmp.id=?");
					param.add(emp);
				}
				hql.append(" group by r.TProject.id ");
				Query q = s.createQuery(hql.toString());
				
				
				for(int i = 0;i<param.size();i++){
					q.setParameter(i, param.get(i));
				}
				  Object all = 0;
	                all = q.uniqueResult();
	                if (all == null) all = 0;
	            	
				return all;
			}
		}
		);
		
		int allPage = (Integer.parseInt(rows.toString())+MaxResult-1)/MaxResult;
		return allPage;
	}
	public int queryReportNumber(final long empId,final String cdate){
		Object number=this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				StringBuilder hql=new StringBuilder("select count(*) from TReport r where r.TEmp.id=? and r.cdate=to_date(?,'yyyy-mm-dd')");

				Query q = s.createQuery(hql.toString());
				q.setParameter(0, empId);
				q.setParameter(1, cdate);
				return q.uniqueResult();
			}
		}
		);
		
		return Integer.parseInt(number.toString());
		
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setMaxResult(int maxResult) {
		this.MaxResult = maxResult;
	}

	

	public int getCurrentPage() {
		
		return currentPage;
	}

	public int getMaxResult() {
		
		return MaxResult;
	}
}
