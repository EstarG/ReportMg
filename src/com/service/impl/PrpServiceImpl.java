package com.service.impl;

import java.util.List;
import java.util.Map;

import com.persistence.IPrpDao;
import com.persistence.entity.TPrp;
import com.persistence.impl.PrpDaoImpl;
import com.service.IPrpService;

public class PrpServiceImpl implements IPrpService {

	private IPrpDao prpDao;
	
	public void setPrpDao(IPrpDao prpDao) {
		this.prpDao = prpDao;
	}

	public boolean addPrp(TPrp prp) throws Exception {
		return this.prpDao.save(prp);
	}

	public boolean deleteAllPrps(List<String> ids) throws Exception {
		return this.prpDao.deleteAll(ids);
		
	}

	public boolean deletePrp(TPrp prp) throws Exception {
		return this.prpDao.delete(prp);
	}

	public int getAllPage(TPrp prp) throws Exception {
		return prpDao.getAllPage(prp);
	}

	public List<Map<String, String>> getProjectPrps(String projectId)
			throws Exception {
		return this.prpDao.getProjectPrps(projectId);
	}

	public List<Map<String, String>> queryPrp(TPrp prp) throws Exception {
		return prpDao.query(prp);
	}

	public Map<String, String> queryPrpById(TPrp prp) throws Exception {
		return this.prpDao.queryById(prp);
	}
    //.....gbx
	public List<Map<String, String>> queryAll() throws Exception {
		List<Map<String , String>> prps = this.prpDao.queryAll();
		return prps;
	}

	public void setCurrentPage(String currentPage) throws Exception {
		prpDao.setCurrentPage(currentPage);
	}

	public boolean updatePrp(TPrp prp) throws Exception {
		return this.prpDao.update(prp);
	}

	public List<Map<String, String>> queryPrpAccuracy(TPrp prp)
			throws Exception {
		return this.prpDao.queryAccuracy(prp);
	}

	
}
