package com.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.persistence.IPrpDao;
import com.persistence.entity.TPrp;

public class PrpDaoImpl extends HibernateDaoSupport implements IPrpDao {

	private int maxSize = 3;
	private String currentPage;
	public boolean delete(TPrp prp) throws Exception {
		this.getHibernateTemplate().delete(prp);
		return true;
	}

	public boolean deleteAll(List<String> ids) throws Exception {
		TPrp prp = null;
		List<TPrp> prps = new ArrayList<TPrp>();
		for(String id : ids){
			prp = (TPrp)this.getHibernateTemplate().get(TPrp.class, Long.parseLong(id));
			prps.add(prp);
		}
		this.getHibernateTemplate().deleteAll(prps);
		return true;
	}

	public int getAllPage(final TPrp prp) throws Exception {
		Object obj = 
		this.getHibernateTemplate().execute(
				new HibernateCallback() {
					
					public Object doInHibernate(Session s) throws HibernateException,
							SQLException {
						List<Object> params = new ArrayList<Object>();
						StringBuffer hql = new StringBuffer("select count(*) from TPrp where 1=1");
						if(prp.getId()!=0){
							hql.append(" and id=?");
							params.add(prp.getId());
						}
						if(prp.getAbbreviate() != null && !prp.getAbbreviate().trim().equals("")){
							hql.append(" and abbreviate like ?");
							params.add("%"+prp.getAbbreviate().trim()+"%");
						}
						if(prp.getName() != null && !prp.getName().trim().equals("")){
							hql.append(" and name like ?");
							params.add("%"+prp.getName().trim()+"%");
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

	public List<Map<String, String>> getProjectPrps(String projectId)
			throws Exception {
		String hql = "select new map(prp.id as id, prp.name as name) from TProject pro join pro.TPrps prp" +
				" where pro.id = ?";
		return this.getHibernateTemplate().find(hql, Long.parseLong(projectId));
	}

	public List<Map<String, String>> query(final TPrp prp) throws Exception {
		
		return (List<Map<String, String>>)this.getHibernateTemplate().execute(
				new HibernateCallback() {
					
					public Object doInHibernate(Session s) throws HibernateException,
							SQLException {
						List<Object> params = new ArrayList<Object>();
						StringBuffer hql = new StringBuffer("select new map(id as id, abbreviate as ab, name as name, remarks as remarks) from TPrp where 1=1");
						if(prp.getId()!=0){
							hql.append(" and id=?");
							params.add(prp.getId());
						}
						if(prp.getAbbreviate() != null && !prp.getAbbreviate().trim().equals("")){
							hql.append(" and abbreviate like ?");
							params.add("%"+prp.getAbbreviate()+"%");
						}
						if(prp.getName() != null && !prp.getName().trim().equals("")){
							hql.append(" and name like ?");
							params.add("%"+prp.getName()+"%");
						}
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

	public Map<String, String> queryById(TPrp prp) throws Exception {
		TPrp p = (TPrp)this.getHibernateTemplate().get(TPrp.class, prp.getId());
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("id", p.getId()+"");
		pMap.put("ab", p.getAbbreviate());
		pMap.put("name", p.getName());
		pMap.put("remarks",p.getRemarks());
		return pMap;
	}
    
	//gbx.... 传所有PRP阶段
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryAll() throws Exception {
		return this.getHibernateTemplate().find("select new map(id as id, abbreviate as ab, name as name, remarks as remarks) from TPrp where 1=1");
	}
	
	
	public boolean save(TPrp prp) throws Exception {
		this.getHibernateTemplate().save(prp);
		return true;
	}

	public void setCurrentPage(String currentPage) throws Exception {
		this.currentPage = currentPage;
	}

	public boolean update(TPrp prp) throws Exception {
		this.getHibernateTemplate().merge(prp);
		return true;
	}
//精确查询
	public List<Map<String, String>> queryAccuracy(final TPrp prp) throws Exception {
		return (List<Map<String, String>>)this.getHibernateTemplate().execute(
				new HibernateCallback() {
					
					public Object doInHibernate(Session s) throws HibernateException,
							SQLException {
						List<Object> params = new ArrayList<Object>();
						StringBuffer hql = new StringBuffer("select new map(id as id, abbreviate as ab, name as name, remarks as remarks) from TPrp where 1=1");
						if(prp.getId()!=0){
							hql.append(" and id=?");
							params.add(prp.getId());
						}
						if(prp.getAbbreviate() != null && !prp.getAbbreviate().trim().equals("")){
							hql.append(" and abbreviate like ?");
							params.add(prp.getAbbreviate().trim());
						}
						if(prp.getName() != null && !prp.getName().trim().equals("")){
							hql.append(" and name like ?");
							params.add(prp.getName().trim());
						}
						Query q = s.createQuery(hql.toString());
						for(int i=0; i < params.size(); i++){
							q.setParameter(i, params.get(i));
						}
						return q.list();
					}
				}
		);

	}



}
