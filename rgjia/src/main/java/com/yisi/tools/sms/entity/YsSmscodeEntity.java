package com.yisi.tools.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 
 * @author baishui
 * QQ/微信：1052202173
 * 2017年6月22日 下午10:34:49
 *
 * com.yisi.tools.sms.entity.CcSmscodeEntity.java
 */
@Entity
@Table(name = "t_ys_smscode", schema = "")
@SuppressWarnings("serial")
public class YsSmscodeEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**手机号码*/
	@Excel(name="手机号码")
	private java.lang.String mobile;
	/**验证码类型*/
	@Excel(name="验证码类型")
	private java.lang.String codeType;
	/**验证码*/
	@Excel(name="验证码")
	private java.lang.String vaildCode;
	/**状态*/
	@Excel(name="状态")
	private java.lang.Integer status;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private java.util.Date createTime;
	
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
	 *@return: java.lang.String  手机号码
	 */
	@Column(name ="MOBILE",nullable=true,length=32)
	public java.lang.String getMobile(){
		return this.mobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号码
	 */
	public void setMobile(java.lang.String mobile){
		this.mobile = mobile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  验证码类型
	 */
	@Column(name ="CODE_TYPE",nullable=true,length=10)
	public java.lang.String getCodeType(){
		return this.codeType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  验证码类型
	 */
	public void setCodeType(java.lang.String codeType){
		this.codeType = codeType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  验证码
	 */
	@Column(name ="VAILD_CODE",nullable=true,length=10)
	public java.lang.String getVaildCode(){
		return this.vaildCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  验证码
	 */
	public void setVaildCode(java.lang.String vaildCode){
		this.vaildCode = vaildCode;
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
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
}
