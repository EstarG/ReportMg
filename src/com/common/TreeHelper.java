package com.common;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class TreeHelper extends ActionSupport {
	//已选部门的设置
	private List<Map<String, String>> proDepts;
	
	private List<Map<String, String>> rootNodes;
	
	public String getTreeNode(String parentFkey,int type) {
		StringBuilder sb = new StringBuilder();
		System.out.println("父ID "  + parentFkey );
		List<Map<String, String>> nodes = getChildren(parentFkey);
		System.out.println( "子部门" + nodes.size());
		for(int i=0; i< nodes.size(); i++){
			if(i>0){
				sb.append(",");
			}
			//System.out.println(" >>>" + i);
			Map<String, String> m = nodes.get(i);
			//System.out.println(" >>>>>>>>>" + i + " >>>" + m);
			String key = m.get("fkey"); 
			System.out.println(">key:"+key);
			sb.append("{");
			if (type == 1) {
				System.out.println("type = 1");
				sb.append("\"text\": \"<a href='query_DeptAction?id=" +key+ "'" + "target='deptcontent'" + ">" +m.get("fvalue") + "</a>\"");
			} else if (type == 2) {
				System.out.println("type = 2");
				//sb.append("\"text\": \"<input type='checkbox' value='" +m.get("fvalue") + "'/>\"");
				//sb.append("\"text\":  \"<input type='checkbox' checked = 'true' name = 'deptIds' value='" +key + "'/> " + m.get("fvalue") +   " \"  ");
				
				//将已选的部门标记成勾
				boolean flag = false;
				for (Map<String, String> m1 : proDepts) {
					
					if (m1.get("id").equals(key)){
						flag = true;
						//System.out.println(m1 + "  " + key + " " + flag);
						break;
					}
				}
				// true时已配置 false 未配置
				if (flag == true) {
					sb.append("\"text\":  \"<input type='checkbox' checked = 'true' name = 'deptIds' value='" +key + "'/> " + m.get("fvalue") +   " \"  ");
				} else {
					
					System.out.println("flag ....");
					sb.append("\"text\":  \"<input type='checkbox' name = 'deptIds' value='" +key + "'/> " + m.get("fvalue") +   " \"  ");
				}
			}
			sb.append(",\"id\":\"" + key + "\"");
			sb.append(",  \"collapsed\": true");
			if (hasChildren(key)) {
				sb.append(", \"children\":[");
				sb.append(getTreeNode(key,type));
				sb.append("]}");
				this.rootNodes.remove(m);
			}else{
				sb.append("}");
				this.rootNodes.remove(m);
			}
		}
		return sb.toString();
	}
	public String initTree(List<Map<String, String>> rootNodes,String parentFkey,int type) {
		this.rootNodes = rootNodes;
		System.out.println(">>>>>开始");
		StringBuilder jsonString = new StringBuilder();
		jsonString.append("[");
		jsonString.append(getTreeNode(parentFkey,type));
		jsonString.append("]");
		System.out.println(">>>>>结束");
		
		return jsonString.toString();
	}
	public List<Map<String, String>> getChildren(String parentFkey){
		List<Map<String, String>> child = new ArrayList<Map<String,String>>();
		for (Map<String, String> m : rootNodes) {
			if (m.get("parentfkey").equals(parentFkey)) {
				child.add(m);
			}
		}
		return child;
	}
	public void removeChildren(List<Map<String, String>> root,String fkey){
		for (Map<String, String> m : root) {
			if (m.get("fkey").equals(fkey)) {
				root.remove(m);
				break;
			}
		}
	}
	public boolean hasChildren(String parentFkey) {
		boolean flag = false;
		for (Map<String, String> m : rootNodes) {
			if (m.get("parentfkey").equals(parentFkey)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	public List<Map<String, String>> getProDepts() {
		return proDepts;
	}
	public void setProDepts(List<Map<String, String>> proDepts) {
		this.proDepts = proDepts;
	}
    
	
	
}