package com.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.common.SyscodeUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.persistence.entity.TDept;
import com.persistence.entity.TEmp;
import com.service.IDeptService;
import com.service.IEmpService;
@SuppressWarnings("serial")
public class EmpAction extends ActionSupport implements ModelDriven<TEmp>,SessionAware,RequestAware{
	private String fkey;
	private IEmpService empService;
	private IDeptService deptService;
	private String deptId;
	private TDept dept = new TDept();
	private TEmp emp = new TEmp();
	private List<Map<String, String>> emps;
	private List<Map<String,String>> empMaps;
	private List<Map<String, String>> depts;
	private List<Map<String, String>> sexOptions;
	private List<Map<String, String>> roleOptions;
	private List<Map<String, String>> nationOptions;
	private List<Map<String, String>> sfOptions;
	private List<Map<String, String>> cityOptions;
	private List<Map<String, String>> deptOptions;
	private SyscodeUtils sysdao;
	private int currentPage = 1;
	private int allPage;
	private String sf;
	private String city;
	private String province;
	private String mycity;
	private String oldPassword;
	private String newPassword;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private String randInfo;
//	private String loginName;
//	private String loginPassword;

	public void initAll(){
		nationOptions = this.sysdao.getOption("nation");
		roleOptions = this.sysdao.getOption("eRole");
		sexOptions = this.sysdao.getOption("sex");
		sfOptions = this.sysdao.getOption("addr","0");
		try {
			deptOptions = this.deptService.queryAllKV();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String init(){
		this.initAll();
		return "addEmp";
	}
	public String query() throws Exception{
		this.initAll();
		if(this.currentPage >= 1){
			empService.setCurrentPage(currentPage);
		}else{
			this.currentPage = 1;
		}		
		emps = this.empService.find(emp, deptId);
		this.allPage = empService.getAllPage(emp, deptId);
		return "showResult";
	}
	
	public String queryEmpById() throws Exception{
		this.initAll();
		System.out.println("DEPT id  "  + deptId);
		long id = emp.getId();
		emp = this.empService.getEmpById(id);
		//取出地址-----
		String addr = emp.getAddress();
		if(addr != "0,0"){
			if(addr.length()>3){
				sf = addr.substring(0, 4);
				province = sysdao.getSfname(sf);
				if(addr.length() > 4){
					   city = addr.substring(6, addr.length());
					   mycity = sysdao.getSfname(city);
					}else{
						city = "";
					}
			}else{
				sf = "";
			}	
			emp.setAddress(province+mycity);	
		}	
		if(emp.getBirth() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date date = emp.getBirth();
			System.out.println(date);
			String dateStr = sdf.format(date);
			System.out.println(dateStr);
			java.util.Date mydate = sdf.parse(dateStr);
			emp.setBirth(mydate);
		}
		emp.setDid(deptId);
		System.out.println(emp.getDid());
		System.out.println(emp.getName());
		return "updateEmp";
	}

	public String getEmpDetails() throws Exception{
		this.initAll();
		long id = emp.getId();
		emp = this.empService.getEmpById(id);
		String addr = emp.getAddress();
		if(addr != "0,0"){
			if(addr.length()>3){
				sf = addr.substring(0, 4);
				province = sysdao.getSfname(sf);
				if(addr.length() > 4){
					   city = addr.substring(6, addr.length());
					   mycity = sysdao.getSfname(city);
					}else{
						city = "";
					}
			}else{
				sf = "";
			}	
			emp.setAddress(province+mycity);	
		}
		if(emp.getBirth() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date date = emp.getBirth();
			System.out.println(date);
			String dateStr = sdf.format(date);
			System.out.println(dateStr);
			java.util.Date mydate = sdf.parse(dateStr);
			emp.setBirth(mydate);
		}
		emp.setDid(deptId);
		return "showDetails";
	}
	
	public String delete() throws Exception{
		if(this.empService.delete(emp)){
			request.put("message2", "删除成功");
		}else{
			request.put("message2", "删除失败");
		}
		return "queryEmp";
	}
	
	public String update() throws Exception{
		Set<TDept> depts = new HashSet<TDept>();
		TDept dept1 = new TDept(); 
		System.out.println(deptId);
		dept1.setId(Long.parseLong(deptId));
		depts.add(dept1);
		emp.setTDepts(depts);
		if(this.empService.update(emp)){
			request.put("updateMess", "信息修改成功");
		}else{
			request.put("updateMess", "信息修改失败");
		}
		return "queryEmp";
	}
	public String newPass(){
		return "pass";
	}
//	public String login() throws Exception{
////		emp.setUsername(loginName.trim());
////		emp.setUserpassword(loginPassword.trim());
//		String rand1 = ((String) session.get("rand")).trim();
//		System.out.println(">>>>>>>>>>>>"+ randInfo.equals(rand1));
//		String result = null;
//		List<Map<String, String>> users = new ArrayList<Map<String,String>>();
//		users = this.empService.login(emp);
//		TEmp emp1 = new TEmp();
//		for(Map<String, String> user : users){
//			String name = user.get("username");
//			String password = user.get("userpassword");
//			String role = user.get("erole");
//			long id = Long.parseLong(user.get("id").trim());
//			if(emp.getUsername().equals(name) && emp.getUserpassword().equals(password) && rand1.equals(randInfo)){
//				emp1.setId(id);
//				emp1.setUsername(emp.getUsername());
//				emp1.setUserpassword(emp.getUserpassword());
//				session.put("user", emp1);
//				System.out.println(name + " " + password + " " + rand1);
//				if(role.equals("1")){
//					result = "Leader";
//					break;
//				}	
//				if(role.equals("2")){
//					result = "Common";
//					break;
//				}
//				if(role.equals("0")){
//					result = "Admin";
//					break;
//				}
//			}else{
//				request.put("error", "用户名/密码或验证码错误！");
//				result = "Error";
//			}
//		}
//		System.out.println("result>>>>>>>>.." + result);
//		return result;
//	}
//	public String exit(){
//		session.clear();
//		return "exit";
//	}
	public String add() throws Exception{
		Set<TDept> depts = new HashSet<TDept>();
		TDept dept1 = new TDept(); 
		dept1.setId(Long.parseLong(deptId));
		depts.add(dept1);
		String name = emp.getUsername();
		
		if(empService.isUsed(name)){
			request.put("addMess", "账号已存在！");
		}else{
			emp.setTDepts(depts);
			if(this.empService.save(emp)){
				request.put("addMess", "已成功添加一条记录");
			}else{
				request.put("addMess", "添加失败");
			}
		}
		this.initAll();
		return "addEmp";
	}
	
	public String getCitys() throws Exception {
		if(this.fkey.equals("1001")){
			cityOptions = this.sysdao.getOption("addr", "1001");
		}else{
			cityOptions = this.sysdao.getOption("addr", "1002");
		}
		//将list中的所有map对象转换为json字符串
		return "success";
	}
	 public String updatePassword() throws Exception{
		 emp = this.empService.getEmpById(emp.getId());
		 emp.setUserpassword(newPassword);
		 if(this.empService.updateNewPassword(emp)){
			 request.put("message", "密码修改成功");
		 }else{
			 request.put("message", "密码修改失败");
		 }
		 return "old";
	 }
//-------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------
	public TEmp getModel() {
		// TODO Auto-generated method stub
		return this.emp;
	}

	public TEmp getEmp() {
		return emp;
	}

	public void setEmp(TEmp emp) {
		this.emp = emp;
	}
	
	public List<Map<String, String>> getEmps() {
		return emps;
	}

	public List<Map<String, String>> getEmpMaps() {
		return empMaps;
	}

	public List<Map<String, String>> getDepts() {
		return depts;
	}

	public void setDepts(List<Map<String, String>> depts) {
		this.depts = depts;
	}

	public void setSysdao(SyscodeUtils sysdao) {
		this.sysdao = sysdao;
	}

	public List<Map<String, String>> getRoleOptions() {
		return roleOptions;
	}

	public List<Map<String, String>> getNationOptions() {
		return nationOptions;
	}

	public IEmpService getEmpService() {
		return empService;
	}
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
	public TDept getDept() {
		return dept;
	}
	public void setDept(TDept dept) {
		this.dept = dept;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptId() {
		return deptId;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getAllPage() {
		return allPage;
	}

	public List<Map<String, String>> getSexOptions() {
		return sexOptions;
	}

	public List<Map<String, String>> getSfOptions() {
		return sfOptions;
	}

	public List<Map<String, String>> getCityOptions() {
		return cityOptions;
	}

	public void setFkey(String fkey) {
		this.fkey = fkey;
	}

	public List<Map<String, String>> getDeptOptions() {
		return deptOptions;
	}

	public String getSf() {
		return sf;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getMycity() {
		return mycity;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public IDeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	public void setRandInfo(String randInfo) {
		this.randInfo = randInfo;
	}

//	public void setLoginName(String loginName) {
//		this.loginName = loginName;
//	}
//
//	public void setLoginPassword(String loginPassword) {
//		this.loginPassword = loginPassword;
//	}
	
}
