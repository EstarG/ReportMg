package com.web;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.persistence.entity.TEmp;
import com.service.IEmpService;

public class LoginAction extends ActionSupport implements SessionAware,RequestAware,ModelDriven<TEmp>{
	private TEmp emp = new TEmp();
	
	private Map<String,Object> session;
	private Map<String,Object> request;
	
	private IEmpService empService;
	private String randInfo;
	
	public String login() throws Exception{
		//������ת���
		System.out.println(">>>>>>>>>>>>  I am in .");
		
		String result = null;
		//�����֤��
		String rand1 = ((String) session.get("rand")).trim();
		session.put("user1", emp);
		//����û�
		TEmp temp = this.empService.login(emp);
		
		if (temp != null && rand1.equals(randInfo)){
			//���û�����session
			session.put("user", temp);
			//���Ȩ��
			String role = temp.getErole();
			if(role.equals("1")){
				result = "Leader";	
			}else if(role.equals("2")){
				result = "Common";
			}else if(role.equals("0")){
				result = "Admin";
			}
		} else {
			request.put("error", "�û���/�������֤�����");
			result = "Error";
		}
		return result;
	}
	//--------�һ�����-----
	public String getBackPass() throws Exception{
		System.out.println("������"+emp.getName());
		System.out.println("���䣺" + emp.getEmail());
		TEmp emp2 = this.empService.getBackPass(emp);
		if(emp2.getUsername() != null && (emp2.getUserpassword()!=null)){
			request.put("message", "���μ������û��������룡");
			request.put("message1", "�����û����ǣ�  "+emp2.getUsername());
			request.put("message2", "���������ǣ�  "+emp2.getUserpassword());
		}else {
			request.put("message3", "���û������ڣ���ȷ��������������ȷ��");
		}
		return "back";
	}
	public String jump(){
		return "back";
	}
	
	public String exit(){
		session.clear();
		return "exit";
	}
	
	
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public TEmp getEmp() {
		return emp;
	}

	public void setEmp(TEmp emp) {
		this.emp = emp;
	}
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
	public void setRandInfo(String randInfo) {
		this.randInfo = randInfo;
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	public TEmp getModel() {
		// TODO Auto-generated method stub
		return this.emp;
	}
	

}
