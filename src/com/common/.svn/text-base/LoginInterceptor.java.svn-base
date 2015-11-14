package com.common;


import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.persistence.entity.TEmp;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("µ÷ÓÃÀ¹½ØÆ÷");
		Map<String,Object> session = ActionContext.getContext().getSession();
		TEmp user = (TEmp)session.get("user");
		
		String result = null;
		
		if (user != null){
			result = invocation.invoke();
		} else {
			result = "login";
		}
		System.out.println("result = " + result);
		
		return result;
	}

}
