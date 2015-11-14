package com.persistence.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.persistence.IAuditingDao;
import com.persistence.entity.TReport;

public class AuditingDaoImpl extends HibernateDaoSupport implements IAuditingDao {
	private int maxSize = 3;
	private String currentPage;
	public int getAllPage(final TReport report) throws Exception {
		Object obj = 
			this.getHibernateTemplate().execute(
					new HibernateCallback() {
						
						public Object doInHibernate(Session s) throws HibernateException,
								SQLException {
							List<Object> params = new ArrayList<Object>();
							StringBuffer hql = new StringBuffer("select count(*) from TReport r join r.TEmp e where 1=1");
							if(report.getId() != 0){
								hql.append(" and r.id=?");
								params.add(report.getId());
							}
							if(report.getStatus() != null && !report.getStatus().trim().equals("") && !report.getStatus().equals("0")){
								hql.append(" and r.status=?");
								params.add(report.getStatus());
							}
							if(report.getBegin() != null && !report.getBegin().trim().equals("")){
								hql.append(" and r.cdate > to_date(?,'yyyy-MM-dd')");
								params.add(report.getBegin());
							}
							if(report.getEnd() != null && !report.getEnd().trim().equals("")){
								hql.append(" and r.cdate < to_date(?,'yyyy-MM-dd')");
								params.add(report.getEnd());
							}
							if(report.getTEmp().getId() != 0){
								hql.append(" and e.id = ?");
								params.add(report.getTEmp().getId());
							}
							Query q = s.createQuery(hql.toString());
							for(int i=0; i < params.size(); i++){
								q.setParameter(i, params.get(i));
							}
							return q.uniqueResult();
						}
					}
			);
			int allPage = (Integer.parseInt(obj.toString())+maxSize-1)/maxSize;
			System.out.println("总记录数为："+obj.toString()+";总页数为:"+allPage);
			return allPage;
	}

	public List<Map<String, String>> query(final TReport report) throws Exception {
		return (List<Map<String, String>>)this.getHibernateTemplate().execute(
				new HibernateCallback() {
					
					public Object doInHibernate(Session s) throws HibernateException,
							SQLException {
						List<Object> params = new ArrayList<Object>();
						StringBuffer hql = new StringBuffer("select new map(r.id as id, r.task as task, to_char(r.cdate,'yyyy-MM-dd') as cdate, r.workload as workload, r.overtime as overtime, s.fvalue as status, e.name as eName, prp.name as prpName, pro.name as proName)" +
								" from TReport r join r.TEmp e join r.TPrp prp join r.TProject pro, TSyscode s where s.fname='rstatus' and s.fkey = r.status");
						if(report.getId() != 0){
							hql.append(" and r.id=?");
							params.add(report.getId());
						}
						if(report.getStatus() != null && !report.getStatus().trim().equals("") && !report.getStatus().equals("0")){
							hql.append(" and r.status=?");
							params.add(report.getStatus());
						}
						if(report.getBegin() != null && !report.getBegin().trim().equals("")){
							hql.append(" and r.cdate > to_date(?,'yyyy-MM-dd')");
							params.add(report.getBegin());
						}
						if(report.getEnd() != null && !report.getEnd().trim().equals("")){
							hql.append(" and r.cdate < to_date(?,'yyyy-MM-dd')");
							params.add(report.getEnd());
						}
						if(report.getTEmp().getId() != 0){
							hql.append(" and e.id = ?");
							params.add(report.getTEmp().getId());
						}
						hql.append(" order by r.id");
						Query q = s.createQuery(hql.toString());
						q.setMaxResults(maxSize);
						q.setFirstResult((Integer.parseInt(currentPage)-1) * maxSize);
						for(int i=0; i < params.size(); i++){
							q.setParameter(i, params.get(i));
						}
						return q.list();
					}
				}
		);
	}

	public void setCurrentPage(String currentPage) throws Exception {
		this.currentPage = currentPage;
		System.out.println("当前为第:"+currentPage+"页");
	}

	public boolean passAll(final List<String> ids) throws Exception {
		final String hql = "update TReport set status='3' where id = ?";
		this.getHibernateTemplate().execute(
			new HibernateCallback() {
				
				public Object doInHibernate(Session s) throws HibernateException,
						SQLException {
					Query q = null;
					for(String id:ids){
						q = s.createQuery(hql);
						q.setParameter(0, Long.parseLong(id));
						q.executeUpdate();
					}
					return null;
				}
			}
		);
		return true;
	}

	public boolean notPass(final List<String> ids) throws Exception {
		final String hql = "update TReport set status='2' where id = ?";
		this.getHibernateTemplate().execute(
			new HibernateCallback() {
				
				public Object doInHibernate(Session s) throws HibernateException,
						SQLException {
					Query q = null;
					for(String id:ids){
						q = s.createQuery(hql);
						q.setParameter(0, Long.parseLong(id));
						q.executeUpdate();
					}
					return null;
				}
			}
		);
		return true;
	}

	public Map<String, String> queryById(TReport report) throws Exception {
		TReport r =(TReport)this.getHibernateTemplate().get(TReport.class, report.getId());
		Map<String, String> mReport = new HashMap<String, String>();
		mReport.put("id", r.getId()+"");
		mReport.put("empId", r.getTEmp().getId()+"");
		mReport.put("eName", r.getTEmp().getName());
		mReport.put("proId", r.getTProject().getId()+"");
		mReport.put("proName", r.getTProject().getName());
		mReport.put("prpId", r.getTPrp().getId()+"");
		mReport.put("prpName", r.getTPrp().getName());
		mReport.put("status", r.getStatus());
		mReport.put("task", r.getTask());
		mReport.put("workload", r.getWorkload());
		mReport.put("overtime", r.getOvertime());
		mReport.put("cdate", new SimpleDateFormat("yyyy-MM-dd").format(r.getCdate()));
		
		return mReport;
	}

	public boolean update(TReport report) throws Exception {
		this.getHibernateTemplate().merge(report);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryInferior(
			final List<Map<String, String>> inferiorIds) throws Exception {
		return (List<Map<String, String>>)this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				StringBuilder hql = new StringBuilder(
						"select new map(r.id as id, r.task as task, to_char(r.cdate,'yyyy-MM-dd') as cdate, r.workload as workload, r.overtime as overtime, s.fvalue as status, e.name as eName, prp.name as prpName, pro.name as proName)" +
						" from TReport r join r.TEmp e join r.TPrp prp join r.TProject pro, TSyscode s where s.fname='rstatus' and s.fkey = r.status");
				List<Object> params = new ArrayList<Object>();
				if(inferiorIds.size()>0){
					hql.append(" and (");
					for (Map<String, String> m : inferiorIds) {
						for (String key : m.keySet()) {
							if(key.equals("id")){
								hql.append("e.id=? or ");
								params.add(Long.parseLong(m.get(key)));
							}
						}
					}
					hql.append("1<>1)");
				}
				hql.append(" order by r.id");
				Query q = s.createQuery(hql.toString());
				q.setMaxResults(maxSize);
				q.setFirstResult((Integer.parseInt(currentPage)-1) * maxSize);
				for(int i = 0; i<params.size(); i++){
					q.setParameter(i, params.get(i));
				}
				return q.list();
			}
		});
	}

	public int getInferiorPage(final List<Map<String, String>> inferiorIds) throws Exception {
		Object obj = 
			this.getHibernateTemplate().execute(
					new HibernateCallback() {
						
						public Object doInHibernate(Session s) throws HibernateException,
								SQLException {
							List<Object> params = new ArrayList<Object>();
							StringBuilder hql = new StringBuilder("select count(*) from TReport r join r.TEmp e where 1<>1");
							for (Map<String, String> m : inferiorIds) {
								for (String key : m.keySet()) {
									if(key.equals("id")){
										hql.append(" or e.id=?");
										params.add(Long.parseLong(m.get(key)));
									}
								}
							}
							Query q = s.createQuery(hql.toString());
							for(int i=0; i < params.size(); i++){
								q.setParameter(i, params.get(i));
							}
							return q.uniqueResult();
						}
					}
			);
			int allPage = (Integer.parseInt(obj.toString())+maxSize-1)/maxSize;
			System.out.println("总记录数为："+obj.toString()+";总页数为:"+allPage);
			return allPage;
	}
}
