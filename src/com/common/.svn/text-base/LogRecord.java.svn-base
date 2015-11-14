package com.common;

import java.util.Date;
import java.util.Map;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.opensymphony.xwork2.ActionContext;

import com.persistence.entity.TEmp;
import com.persistence.entity.TLog;
import com.service.ILogService;
@Aspect
public class LogRecord{
	private TLog log = new TLog();
	private ILogService logService;
	@Pointcut("execution(* com.persistence.impl.EmpDaoImpl.login(..))")
	public void add(){}
	@After("add()")
	public void loginLog() throws Exception{
		System.out.println("I am record of log>>>>>>");
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user1");	
		System.out.println("yobghu>>>>>>>>>" + emp.getUsername());
		log.setUsername(emp.getUsername());
		log.setCdate(new Date());
		log.setOptype("login");
		String context = "登录到系统";
		log.setContext(context);
		log.setEmail("");
		this.logService.insert(log);
	}
	public void exitLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("exit");
		String context = "退出系统";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.EmpDaoImpl.save(..))")
	public void add1(){}
	@After("add1()")
	public void insertEmpLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("insert");
		String context = "insert an employee，调用方法：add";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.DeptDaoImpl.save(..))")
	public void add5(){}
	@After("add5()")
	public void insertDeptLog(){
			
			Map<String,Object> session = ActionContext.getContext().getSession();
			TEmp emp = (TEmp) session.get("user");		
			log.setUsername(emp.getName());
			log.setCdate(new Date());
			log.setOptype("insert");
			String context = "insert a Dept，调用方法：save";
			log.setContext(context);
			log.setEmail("");
			try {
				this.logService.insert(log);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	@Pointcut("execution(* com.persistence.impl.ProjectDaoImpl.save(..))")
	public void add9(){}
	@After("add9()")
	public void insertProjectLog(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("insert");
		String context = "insert a Project，调用方法：save";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.PrpDaoImpl.save(..))")
	public void add13(){}
	@After("add13()")
	public void insertPrpLog(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("insert");
		String context = "insert a Prp，调用方法：save";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.ReportDaoImpl.save(..))")
	public void add17(){}
	@After("add17()")
	public void insertReportLog(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("insert");
		String context = "insert a Report，调用方法：save";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.EmpDaoImpl.delete(..))")
	public void add2(){}
	@After("add2()")
	public void deleteEmpLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("delete");
		String context = "delete an employee，调用方法：delete";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.DeptDaoImpl.delete(..))")
	public void add6(){}
	@After("add6()")
	public void deleteDeptLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("delete");
		String context = "delete a Dept，调用方法：delete";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.ProjectDaoImpl.delete(..))")
	public void add10(){}
	@After("add10()")
	public void deleteProjectLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("delete");
		String context = "delete a Project，调用方法：delete";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.ReportDaoImpl.delete(..))")
	public void add18(){}
	@After("add18()")
	public void deleteReportLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("delete");
		String context = "delete a Report，调用方法：delete";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.PrpDaoImpl.delete(..))")
	public void add14(){}
	@After("add14()")
	public void deletePrpLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("delete");
		String context = "delete a Prp，调用方法：delete";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Pointcut("execution(* com.persistence.impl.EmpDaoImpl.update(..))")
	public void add3(){}
	@After("add3()")
	public void updatetEmpLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("update");
		String context = "update informations of an employee，调用方法：update";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.DeptDaoImpl.update(..))")
	public void add7(){}
	@After("add7()")
	public void updatetDeptLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("update");
		String context = "update informations of a dept，调用方法：update";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.ReportDaoImpl.update(..))")
	public void add19(){}
	@After("add19()")
	public void updatetReportLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("update");
		String context = "update informations of a Report，调用方法：update";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.PrpDaoImpl.update(..))")
	public void add15(){}
	@After("add15()")
	public void updatetPrpLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("update");
		String context = "update informations of a Prp，调用方法：update";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.ProjectDaoImpl.update(..))")
	public void add11(){}
	@After("add11()")
	public void updatetProjectLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("update");
		String context = "update informations of a Project，调用方法：update";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.EmpDaoImpl.find(..))")
	public void add4(){}
	@After("add4()")
	public void queryEmpLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("query");
		String context = "query all employees，调用方法：find";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.DeptDaoImpl.query(..))")
	public void add8(){}
	@After("add8()")
	public void queryDeptLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("query");
		String context = "query all Depts，调用方法：find";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.ReportDaoImpl.query(..))")
	public void add20(){}
	@After("add20()")
	public void queryReportLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("query");
		String context = "query all Reports，调用方法：find";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.ProjectDaoImpl.query(..))")
	public void add12(){}
	@After("add12()")
	public void queryProjectLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("query");
		String context = "query all Projects，调用方法：find";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Pointcut("execution(* com.persistence.impl.PrpDaoImpl.query(..))")
	public void add16(){}
	@After("add16()")
	public void queryPrpsLog(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp emp = (TEmp) session.get("user");		
		log.setUsername(emp.getName());
		log.setCdate(new Date());
		log.setOptype("query");
		String context = "query all Prps，调用方法：find";
		log.setContext(context);
		log.setEmail("");
		try {
			this.logService.insert(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public TLog getLog() {
		return log;
	}
	public void setLog(TLog log) {
		this.log = log;
	}

	public ILogService getLogService() {
		return logService;
	}

	public void setLogService(ILogService logService) {
		this.logService = logService;
	}

}
