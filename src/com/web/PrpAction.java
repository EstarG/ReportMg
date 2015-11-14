package com.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.persistence.entity.TPrp;
import com.service.IProjectService;
import com.service.IPrpService;
import com.service.impl.PrpServiceImpl;

public class PrpAction extends ActionSupport implements ModelDriven<TPrp>, RequestAware{

	private TPrp prp = new TPrp();
	private int allPage;
	private String currentPage = "1";
	private IPrpService prpService;
	private List<Map<String, String>> prps;
	private Map<String, String> prpMap;
	private List<String> ids;
	private List<Map<String, String>> proPrps;
	//...gbx
	private String projectId;
	private IProjectService projectService;
	//���PRP�׶��Ƿ���ڵı�־
	private String isEx;
	private Map<String, Object> request;
	
	
	//.....gbx ���躯��������е�prp��Ϣ���Լ��Ѿ�ѡ��prp��Ϣ
	public String configInit() throws Exception {
		System.out.println("PRP  Ҫ���õĲ���" + projectId );
		//1 .. ������е�prp��Ϣ
		this.prps = this.prpService.queryAll();
		System.out.println("���е�prp   " + this.prps);
		//2...��������õ�project  �ϵ�prp
		this.proPrps = this.projectService.getProjectPrps(projectId);
		System.out.println("�����õ�PRP " + this.proPrps);
		return "cfPrpProject";
	}
	
	public String initAdd()throws Exception{
		return "PRPAdd";
	}
	public String queryPrp() throws Exception{
		if(currentPage != null && !currentPage.equals("")){
			prpService.setCurrentPage(currentPage);
		}else{
			prpService.setCurrentPage("1");
		}
		this.allPage = prpService.getAllPage(prp);
		this.prps = prpService.queryPrp(prp);
		return "PrpQuery";
	}
	public String queryPrpById() throws Exception{
		System.out.println(prp.getId());
		this.prpMap = this.prpService.queryPrpById(prp);
		return "PrpUpdate";
	}
	public String updatePrp() throws Exception{
		if(this.prpService.updatePrp(prp)){
			request.put("msg", "���³ɹ�");
		}
		return "queryPrp";
	}
	public String addPrp() throws Exception{
		if(this.prpService.addPrp(prp)){
			request.put("msg", "��ӳɹ�");
		}
		return "queryPrp";
	}
	public String deletePrp() throws Exception{
		if(this.prpService.deletePrp(prp)){
			request.put("msg", "ɾ���ɹ�");
		}
		return "queryPrp";
	}
	public String deleteAllPrps() throws Exception{
		if(ids != null && ids.size()>0){
			this.prpService.deleteAllPrps(ids);
			request.put("msg", "ɾ��"+ids.size()+"����¼�ɹ�");
		}
		return "queryPrp";
	}
	public String getProjectPrps() throws Exception{
		this.proPrps = this.prpService.getProjectPrps("29");
		for(Map<String, String> p : proPrps){
			for(String key : p.keySet()){
				System.out.println(p.get(key));
			}
		}
		return null;
	}
	//������д��׶�����ʱʱ�жϸ�ֵ�Ƿ��Ѿ�����
	
    public String isExist() throws Exception {
    	System.out.println("��ʼ����PRP�Ƿ����" + prp.getAbbreviate()+"/"+prp.getName());
    	List<Map<String, String>> prpExits = this.prpService.queryPrpAccuracy(prp);
    	System.out.println("PRP����" + prpExits.size());
    	if (prpExits.size() == 0) {
    		isEx = "1";//������
    	} else {
    		isEx = "0";//����
    	}
    	System.out.println(isEx);
    	return "existPrp";
    }
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public int getAllPage() {
		return allPage;
	}

	public TPrp getPrp() {
		return prp;
	}

	public void setPrpService(PrpServiceImpl prpService) {
		this.prpService = prpService;
	}
	
	public Map<String, String> getPrpMap() {
		return prpMap;
	}
	public List<Map<String, String>> getPrps() {
		return prps;
	}
	public TPrp getModel() {
		// TODO Auto-generated method stub
		return this.prp;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	public List<Map<String, String>> getProPrps() {
		return proPrps;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getIsEx() {
		return isEx;
	}

	public void setIsEx(String isEx) {
		this.isEx = isEx;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	
}
