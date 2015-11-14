package com.web;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import com.common.TreeHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.persistence.entity.TDept;
import com.service.IDeptService;
import com.service.IProjectService;

public class DeptAction extends ActionSupport implements RequestAware,ModelDriven<TDept>{
	
	private int currentPage;	
	private String pageSize;
	private int allPage;
	
	private TDept dept = new TDept();	
	
	private List<Map<String,String>> deptOptions;	
	
	private IDeptService deptService;
	private IProjectService projectService;
	
	private Map<String, Object> request;	
	private List<Map<String, String>> depts;
	private String projectId;	
    private List<String> ids;
    private Set<TDept> pDepts;
    
    //该部门的员工
    private List<Map<String,String>> deptEmps;
	
    public void initOptions() throws Exception {
		this.deptOptions = this.deptService.queryAllKV();
		
	}
    public String getDeptTree() throws Exception {
    	
    	
    	System.out.println("getDetp Tree ..........");
    	TreeHelper th = new TreeHelper();
		List<Map<String, String>> rootNodes = this.deptService.queryAllKV();
		
		
		System.out.println("aa:"+rootNodes);
		//1表示链接
		String result = th.initTree(rootNodes,"1",1);
		System.out.println("结束....." + result);
		System.out.println(result);
		HttpServletResponse response = 
			ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(result);
		
    	return null;
    }
    public String getDeptTree2() throws Exception {
    	
    	
    	System.out.println("getDetp 2 Tree ..........");
    	TreeHelper th = new TreeHelper();
		List<Map<String, String>> rootNodes = this.deptService.queryAllKV();
		
		//获得已选部门
		System.out.println("部门号 : >>>>"+ projectId);
		th.setProDepts(this.projectService.getProjectDepts(projectId));
		
		System.out.println("aa:"+rootNodes);
		//1表示链接
		String result = th.initTree(rootNodes,"1",2);
		System.out.println("结束....." + result);
		System.out.println(result);
		HttpServletResponse response = 
			ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(result);
		
    	return null;
    }
    
    public String init() throws Exception {
    	
    	this.initOptions();
    	System.out.println("初始化。。。。" + this.deptOptions);
    	return "configDept";
    }
    //添加之前获得所有部门的下拉列表以选择上级部门
    public String addInit() throws Exception {
    	System.out.println( " 的到所有部门 K - V");
    	this.initOptions();
    	System.out.println(this.deptOptions);
    	return "addDept";
    }
	public String add() throws Exception {
		deptService.save(dept);
		request.put("msg", "添加成功");
		return "showDept";
	}
	public String delete() throws Exception {
		System.out.println("delete Dept Id = " + dept.getId());
		deptService.delete(dept);
		request.put("msg", "删除成功");
		return "showDept";
	}
	public String update() throws Exception {
		System.out.println("update Dept  ....");
		deptService.update(dept);
		request.put("msg", "修改成功");
		return "showDept";
	}
	public String queryById() throws Exception{
		this.initOptions();
		
		System.out.println("qurery By Id ");
		
		this.dept = this.deptService.queryById(dept.getId());
		
		return "updateDept";
	}
	public String query() throws Exception{
		System.out.println("dept query 开始");
		if (currentPage == 0) currentPage = 1;
		this.deptService.setCurrentPage(currentPage);
		this.allPage = this.deptService.getAllPage(dept);
		
		this.initOptions();
		this.depts = this.deptService.query(dept);
		System.out.println("dept query 结束" + "查询到数据条数 " + this.depts.size() + " 当前页" + currentPage);
		return "showDept";
	}
	
	public String queryConfiged() throws Exception {
		this.deptOptions = this.deptService.queryConfiged(projectId);
		return null;
	}
	//根据部门的ID获得该部门的员工
	public String queryDeptEmps() throws Exception {
		this.deptEmps = this.deptService.deptEmps(dept.getId()+"");
		return "queryDeptEmps";
	}
	
	
	
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}

	public TDept getModel() {
		// TODO Auto-generated method stub
		return this.dept;
	}
	
	public TDept getDept() {
		return dept;
	}
	public void setDept(TDept dept) {
		this.dept = dept;
	}
	
	public List<Map<String, String>> getDeptOptions() {
		return deptOptions;
	}
	public List<Map<String, String>> getDepts() {
		return depts;
	}
	
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getAllPage() {
		return allPage;
	}
	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}
	public List<Map<String, String>> getDeptEmps() {
		return deptEmps;
	}
	public void setDeptEmps(List<Map<String, String>> deptEmps) {
		this.deptEmps = deptEmps;
	}
	public void setDeptOptions(List<Map<String, String>> deptOptions) {
		this.deptOptions = deptOptions;
	}
    
}
