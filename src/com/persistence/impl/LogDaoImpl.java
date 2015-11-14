package com.persistence.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.persistence.ILogDao;
import com.persistence.entity.TLog;

public class LogDaoImpl extends HibernateDaoSupport implements ILogDao{
	private int currentPage = 1;
	private int pageSize = 10;
	public int getAllPage(final TLog log,final String startDate,final String endDate) throws Exception {
		Object object = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					
					public Object doInHibernate(Session session) throws HibernateException,
							SQLException {
						String username = log.getUsername();
						String optype = log.getOptype();
						List<Object> param = new ArrayList<Object>();
						StringBuilder hql = new StringBuilder("select count(*) from TLog where 1=1");  
						if(username != null && !username.equals("")){
							hql.append(" and username = ?");
							param.add(username);
						}
						if(optype != null && !optype.equals("")){
							hql.append(" and optype = ?");
							param.add(optype);
						}
						if(startDate != null && startDate.equals("")){
							if(endDate == null ){
								hql.append(" and between ? and sysdate");
								param.add(startDate);
							}
							if(endDate != null && !endDate.equals("")){
								hql.append(" and between ? and ?");
								param.add(startDate);
								param.add(endDate);
							}
						}
						Query q = session.createQuery(hql.toString());
						for(int i = 0; i < param.size(); i++){
							q.setParameter(i, param.get(i));
						}
						return q.uniqueResult();
					}
				}
		);
		int allPage = (Integer.parseInt(object.toString())+this.pageSize-1)/this.pageSize;
		return allPage;
	}
	public List<Map<String, String>> findLogs(final TLog log,final String startDate,final String endDate) throws Exception {
		return (List<Map<String, String>>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					
					public Object doInHibernate(Session session) throws HibernateException,
							SQLException {
						String username = log.getUsername();
						String optype = log.getOptype();
						List<Object> param = new ArrayList<Object>();
						StringBuilder hql = new StringBuilder("select new map(id as id,username as username,optype as optype," +
								"context as context,cdate as cdate) from TLog where 1=1");  
						if(username != null && !username.equals("")){
							hql.append(" and username = ?");
							param.add(username);
						}
						if(optype != null && !optype.equals("")){
							hql.append(" and optype = ?");
							param.add(optype);
						}
						if(startDate != null && startDate.equals("")){
							if(endDate == null ){
								hql.append(" and between ? and sysdate");
								param.add(startDate);
							}
							if(endDate != null && !endDate.equals("")){
								hql.append(" and between ? and ?");
								param.add(startDate);
								param.add(endDate);
							}
						}
						Query q = session.createQuery(hql.toString());
						for(int i = 0; i < param.size(); i++){
							q.setParameter(i, param.get(i));
						}
						q.setMaxResults(pageSize);
						q.setFirstResult((currentPage - 1)*pageSize);
						List<Map<String, String>> list = new ArrayList<Map<String,String>>();
						list = q.list();
						return list;
					}
				}
		);
	}

	public boolean insert(TLog log) throws Exception {
		System.out.println("½øÈë>>>>>>>>Tlog    ");
		this.getHibernateTemplate().save(log);
		return false;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
