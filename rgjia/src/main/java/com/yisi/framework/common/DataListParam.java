package com.yisi.framework.common;

import java.util.List;

import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;


/**
 * easyui的datagrid向后台传递参数使用的model
 * 
 * @author
 * 
 */
public class DataListParam {

	private Integer page = 1;// 当前页
	private Integer rows = 10;// 每页显示记录数
	private String sort = null;// 排序字段名
	private String order = "asc";// 按什么排序(asc,desc)
	private int total;//总记录数

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	public Integer getPage() {
		return page;
	}


	public Integer getRows() {
		if(ContextHolderUtils.getRequest()!=null&&ResourceUtil.getParameter("rows")!=null){
			return rows;
		}
		return 10000;
	}


	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getOrder() {
		return order;
	}

	
}
