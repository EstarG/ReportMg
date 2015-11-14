package com.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;

import com.common.SyscodeUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.persistence.entity.TEmp;
import com.persistence.entity.TProject;
import com.service.IEmpService;
import com.service.IProjectService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@SuppressWarnings("serial")
public class ProjectAction extends ActionSupport implements ModelDriven<TProject>,RequestAware{

	//检测项目编号是否存在的标志
	private String isE;
	 
	//分页
	private int currentPage;
	private int allPage;
	
	
	//个实体类
	private TProject project = new TProject();
	private IProjectService projectService;
	private IEmpService empService;
	private SyscodeUtils syscodeUtils;
	
	private List<String> ids;
	private Map<String, Object> request;
	//复选框过来的需要配置的  必须new 因为在勾选为空时他要根据空的list来更新
	private	List<String> prpIds = new ArrayList<String>();
	private	List<String> deptIds = new ArrayList<String>();
	//因为负责人可能有重复，第三张表不应该出现重复，project本身记录每个负责人的角色，第三张表维护他们之间的关系即可
	private Set<String> empIds = new HashSet<String>();
	
	private List<Map<String, String>> proStatusOptions;
	private List<Map<String,String>> projects;
	
	//已经配置上的
	private List<Map<String, String>> proPrps;
	private List<Map<String, String>> proDepts;
	
	
	//选择的负责人的名字
	private String schName;
	
	//特定负责人
	private String pm;
	private String rd;
	private String mk;
	private String qt;
	private String ot;
	
	
    public void initOptions() {
    	this.proStatusOptions = syscodeUtils.getOption("pstatus");
    }
    //josn调用，获得已选部门然后传给回调函数，将已选部门标上对号
    public String jsonInitProDept() throws Exception {
    	System.out.println("调用测试。。。。。");
    	this.getProjectDepts();
    	return "success";
    }
    //输入编号时判断该编号是否已经存在
    public String isExist() throws Exception {
    	System.out.println("开始检测该项目是否存在" + project.getName());
    	List<Map<String, String>> pros = this.projectService.query(project);
    	System.out.println("项目数数量" + pros.size());
    	if (pros.size() == 0) {
    		isE = "1";//不存在
    	} else {
    		isE = "0";//存在
    	}
    	return "isExist";
    }
    
    
    //获得项目的ID 然后跳转到  cfEmpProject.jsp
    public String beforeConfigEmp() throws Exception {
    	//1 .初始话提示框，在前台显示
    	pm = "项目经理"; rd = "研发负责人";
    	mk = "市场负责人"; qt = "质量负责人";
    	ot = "其他";
    	//2. 获得project对象，以及他原来配置的负责人
    	this.project = this.projectService.queryById(this.project.getId());
    
    	//根据员工ID找员工的姓名
    	TEmp emp = null;
    	//项目经理
    	String p_name = null;
    	p_name = this.project.getPmanager();
    	System.out.println("项目负责人 ： " + p_name);
    	if (p_name != null && !p_name.trim().equals("")) {
    		System.out.println(" >>>  " + p_name);
	    	emp = this.empService.getEmpById(Long.parseLong(this.project.getPmanager().trim()));
	    	if (emp != null) {
	    		pm = emp.getName();
	    	}
	    	p_name = null;
    	}
    	
    	//市场负责人
    	p_name = this.project.getMkmanager();
    	if (p_name != null && !p_name.trim().equals("")) {
	    	emp = this.empService.getEmpById(Long.parseLong(this.project.getMkmanager().trim()));
	    	if (emp != null) {
	    		mk = emp.getName();
	    	}
	    	p_name = null;
    	}
    	//质量负责人
    	p_name = this.project.getQtmanager();
    	if (p_name != null && !p_name.trim().equals("")) {
	    	emp = this.empService.getEmpById(Long.parseLong(this.project.getQtmanager().trim()));
	    	if (emp != null) {
	    		qt = emp.getName();
	    	}
	    	p_name = null;
    	}
    	
    	//其他人员
    	List<String> otherIds = new ArrayList<String>();
    	//首先把ID都取出来
    	String pother = project.getOther();
    	if (pother != null && !pother.trim().equals("")) {
    		System.out.println("其他 ： " + pother.length() + " " + pother);
	    	String t_other = pother.substring(0,pother.length() - 1);
	    	otherIds.addAll(Arrays.asList(t_other.split(";")));
	    	
	    	ot = "";
	    	for (int i = 0; i < otherIds.size(); ++i) {
	    		emp  = this.empService.getEmpById(Long.parseLong(otherIds.get(i).trim()));
	    		ot += emp.getName() + ";";
	    	}
    	}
    	System.out.println("PM " + pm + " MK " + mk + " qT " + qt + "other " + ot);
    	
    	
    	System.out.println("要配置的项目的ID : " + project.getId());
    	//获得该项目的信息，到前台显示已配置人员
    	//this.project = this.projectService.queryConfigEmps(this.project.getId());
    	return "cfEmpProject";
    }
    //给项目配置员工之前首先获得该项目的所配置的部门
    public String configInitEmp() throws Exception {
    	
    	System.out.println("要配置的项目的ID : " + project.getId());
    	System.out.println("要选择负责人的名字  ： " + schName);
    	//获得已配置到项目的部门
    	this.proDepts = this.projectService.getProjectDepts(project.getId() + "");
    	return "slEmp";
    }
    public String configInitEmpOther() throws Exception {
    	System.out.println("要配置的项目的ID : " + project.getId());
    	//获得已配置到项目的部门
    	this.proDepts = this.projectService.getProjectDepts(project.getId() + "");
    	return "slOtherEmp";
    }
    
    public String configInit() throws Exception {
    	//获得该项目以配置的部门
    	this.getProjectDepts();
    	//获得该对象的信息，用于在前台显示
    	this.project = this.projectService.queryById(project.getId());
    	
    	System.out.println("init 部门ID  " + project.getId());
    	return "cfDeptProject";
    }
	public String add() throws Exception {
		System.out.println(" add Pro ...");
		
		Date currentDate = new Date();
		Date bDate = this.project.getBegindate();
		Date eDate = this.project.getEnddate();
		
		//如果项目的时间不合法并且设置的时云新那就必须自动给设置为挂起
		if ((bDate.compareTo(eDate) > 0 && project.getStatus().equals("1")) ) {
			request.put("msg", "输入时间不合法,未添加成功！");
			return "queryPro";
		}else if ( (eDate.compareTo(currentDate) < 0 && project.getStatus().equals("1"))) {
			request.put("msg", "输入时间不在合法时间内，自动改为挂起状态");
			System.out.println("不合法的时间...");
			project.setStatus("2");
			this.projectService.save(project);
			return "queryPro";
		} 
		this.projectService.save(project);
		String result = "queryPro";
		request.put("msg", "添加成功");
		return result;
	}
	public String delete() throws Exception {
		String result = "";
		this.projectService.delete(project);
		result = "queryPro";
		request.put("msg", "删除成功");
		return result;
	}
	//批量删除
	public String deleteAll() throws Exception {
		this.projectService.deleteAll(ids);
		request.put("msg", "删除成功");
		return "queryPro";
	}
	public String update() throws Exception {
		System.out.println("update project  ..." + project.getId());
		String result = "";
		this.projectService.update(project);
		result = "queryPro";
		request.put("msg", "更新成功");
		return result;
	}
	public String queryById() throws Exception {
		this.initOptions();
		System.out.println("query By Id pro ..");
		String result = "";
		this.project = this.projectService.queryById(project.getId());
		
		result = "updatePro";
		return result;
	}
	public String query() throws Exception {
		System.out.println("query ...  ..");
		//获得所有状态
		this.initOptions();
		
		
		//因为这里的other存的是我输入的人的名字所以因为先找到其ID
		long empId = 0;
		System.out.println("》》》要查的员工的ID为 ： " + empId + "名字：" + this.project.getOther() );
		empId = this.empService.queryEmpId(this.project.getOther());
		System.out.println("》》》要查的员工的ID为 ： " + empId + "名字：" + this.project.getOther() );
		//获得这个员工ID
		if (empId != 0) {
			System.out.println("1 endId != 0");
			this.project.setOther(empId+"");
		} else {
			System.out.println("emdId == 0");
			this.project.setOther(null);
		}
		
		//设置当前页获得总页数
		if (currentPage == 0) {
			currentPage = 1;
		}
		this.projectService.setCurrentPage(currentPage);
		this.allPage = this.projectService.getAllPage(project);
		
		System.out.println("Actoin ..  currentPage " + currentPage + " allPage " + allPage);
		
		String result = "";
		this.projects = this.projectService.query(project);
		System.out.println( "查询结束            "   + this.projects);
		result = "showPro";
	
		return result;
	}
	public String configPrp() throws Exception {
		System.out.println("开始PRP配置...." );
		String result = "";
		for (int i = 0; i < prpIds.size(); ++i) {
			System.out.println(">>>>" + prpIds.get(i));
		}
			
		this.projectService.configPrp(project, prpIds);
		result = "queryPro";
		request.put("msg", "配置PRP成功") ;
		return result;
	}
	//配置部门
	public String configDept()  throws Exception {
		System.out.println("开始部门配置...." );
		String result = "";
		
		System.out.println("configDept  .." + project.getId());	
		
		this.projectService.configDept(project, deptIds);
		
		request.put("msg", "配置部门成功") ;
		project.setId(0);
		result = "queryPro";
		return result;
	}
	public String configEmp()  throws Exception {
		String result = "";
		System.out.println("项目编号 + 。" + project.getId());
		//存放所有的员工的id
	     empIds = new HashSet<String>();
		//首先的到该对象
		this.project = this.projectService.queryById(project.getId());
		//清空一下原有的
		this.project.clearManager();
		
		
		System.out.println( "PM " + pm + " RD " + rd + " MK " + mk + " QT　" + qt + " OT " + ot);
		//配置项目经理
		if (pm != null && !pm.trim().equals("")) {
		
			this.project.setPmanager(pm);
			empIds.add(pm);
		}
		//配置项研发负责人
		if (rd != null && !rd.trim().equals("")) {
			this.project.setRdmanager(rd);
			empIds.add(rd);
		}
		//配置
		if (qt != null && !qt.trim().equals("")) {
			this.project.setQtmanager(qt);
			empIds.add(qt);
		}
		//配置
		if (mk != null && !mk.trim().equals("")) {
			this.project.setMkmanager(mk);
			empIds.add(mk);
		}
		if (ot != null && !ot.trim().equals("")) {
			this.project.setOther(ot);	
			empIds.addAll(Arrays.asList(ot.split(";")));
		}
		this.projectService.ConfigEmp(project, empIds);
		result = "queryPro";
		request.put("msg", "配置员工成功");
		return result;
	}

	//snow
	public String getProjectPrps() throws Exception{
		this.proPrps = this.projectService.getProjectPrps(project.getId()+"");
		for(Map<String, String> p : proPrps){
			for(String key : p.keySet()){
				System.out.println(p.get(key));
			}
		}
		return null;
	}
	public void getProjectDepts() throws Exception{
		this.proDepts = this.projectService.getProjectDepts(String.valueOf(project.getId()));
	}
	
	//get set
	public TProject getModel() {
		// TODO Auto-generated method stub
		return this.project;
	}

	public TProject getProject() {
		return project;
	}


	public void setProject(TProject project) {
		this.project = project;
	}
	public Map<String, Object> getRequest() {
		return request;
	}

	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}


	public void setPrpIds(List<String> prpIds) {
		this.prpIds = prpIds;
	}


	public void setDeptIds(List<String> deptIds) {
		this.deptIds = deptIds;
	}



	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}
	public void setSyscodeUtils(SyscodeUtils syscodeUtils) {
		this.syscodeUtils = syscodeUtils;
	}
	public List<Map<String, String>> getProStatusOptions() {
		return proStatusOptions;
	}
	public List<Map<String, String>> getProjects() {
		return projects;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public List<Map<String, String>> getProPrps() {
		return proPrps;
	}
	public List<Map<String, String>> getProDepts() {
		return proDepts;
	}
	public void setProDepts(List<Map<String, String>> proDepts) {
		this.proDepts = proDepts;
	}
	public void setSchName(String schName) {
		this.schName = schName;
	}
	public String getSchName() {
		return schName;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public void setRd(String rd) {
		this.rd = rd;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	public void setQt(String qt) {
		this.qt = qt;
	}
	public void setOt(String ot) {
		this.ot = ot;
	}
	public String getPm() {
		return pm;
	}
	public String getRd() {
		return rd;
	}
	public String getMk() {
		return mk;
	}
	public String getQt() {
		return qt;
	}
	public String getOt() {
		return ot;
	}
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
	public String getIsE() {
		return isE;
	}
	public void setIsE(String isE) {
		this.isE = isE;
	}
}
