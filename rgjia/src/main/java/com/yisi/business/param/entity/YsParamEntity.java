package com.yisi.business.param.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 系统参数
 * @author onlineGenerator
 * @date 2017-06-24 13:03:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ys_param", schema = "")
@SuppressWarnings("serial")
public class YsParamEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**参数名称*/
	@Excel(name="参数名称")
	private java.lang.String paramName;
	/**参数类型*/
	private java.lang.String paramType;
	/**参数值*/
	@Excel(name="参数值")
	private java.lang.String paramValue;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remark;
	/**状态*/
	private java.lang.Integer status;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人*/
	private java.lang.String createName;
	/**修改时间*/
	private java.util.Date updateDate;
	/**修改人*/
	private java.lang.String updateName;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID",nullable=false,length=10)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数名称
	 */
	@Column(name ="PARAM_NAME",nullable=true,length=200)
	public java.lang.String getParamName(){
		return this.paramName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数名称
	 */
	public void setParamName(java.lang.String paramName){
		this.paramName = paramName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数类型
	 */
	@Column(name ="PARAM_TYPE",nullable=true,length=20)
	public java.lang.String getParamType(){
		return this.paramType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数类型
	 */
	public void setParamType(java.lang.String paramType){
		this.paramType = paramType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数值
	 */
	@Column(name ="PARAM_VALUE",nullable=true,length=300)
	public java.lang.String getParamValue(){
		return this.paramValue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数值
	 */
	public void setParamValue(java.lang.String paramValue){
		this.paramValue = paramValue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=2000)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
	@Column(name ="STATUS",nullable=true,length=10)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=36)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=36)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=36)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */
	@Column(name ="SYS_ORG_CODE",nullable=true,length=36)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
}
