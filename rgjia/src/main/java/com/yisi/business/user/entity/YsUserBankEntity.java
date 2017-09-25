package com.yisi.business.user.entity;
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 用户银行
 * @author onlineGenerator
 * @date 2017-06-26 21:17:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ys_user_bank", schema = "")
@SuppressWarnings("serial")
public class YsUserBankEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**用户ID*/
    @Excel(name="用户ID")
	private java.lang.Integer userId;
    
    private YsUserEntity ysUser;
	/**用户名称*/
    @Excel(name="用户名称")
	private java.lang.String userName;
	/**账户号码*/
    @Excel(name="账户号码")
	private java.lang.String accountNo;
	/**账户归属*/
    @Excel(name="账户归属")
	private java.lang.String bankAddress;
	/**开户银行*/
    @Excel(name="开户银行")
	private java.lang.String bank;
	/**支行名称*/
    @Excel(name="支行名称")
	private java.lang.String subbranch;
	
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
	
	@Transient
	public java.lang.Integer getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  用户ID
	 */
	public void setUserId(java.lang.Integer userId){
		this.userId = userId;
	}
	
	@OneToOne
	@JoinColumn(name ="USER_ID",nullable=true)
	public YsUserEntity getYsUser() {
		return ysUser;
	}

	public void setYsUser(YsUserEntity ysUser) {
		this.ysUser = ysUser;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户名称
	 */
	
	@Column(name ="USER_NAME",nullable=true,length=100)
	public java.lang.String getUserName(){
		return this.userName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名称
	 */
	public void setUserName(java.lang.String userName){
		this.userName = userName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户号码
	 */
	
	@Column(name ="ACCOUNT_NO",nullable=true,length=100)
	public java.lang.String getAccountNo(){
		return this.accountNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户号码
	 */
	public void setAccountNo(java.lang.String accountNo){
		this.accountNo = accountNo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户归属
	 */
	
	@Column(name ="BANK_ADDRESS",nullable=true,length=100)
	public java.lang.String getBankAddress(){
		return this.bankAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户归属
	 */
	public void setBankAddress(java.lang.String bankAddress){
		this.bankAddress = bankAddress;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户银行
	 */
	
	@Column(name ="BANK",nullable=true,length=100)
	public java.lang.String getBank(){
		return this.bank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户银行
	 */
	public void setBank(java.lang.String bank){
		this.bank = bank;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支行名称
	 */
	
	@Column(name ="SUBBRANCH",nullable=true,length=100)
	public java.lang.String getSubbranch(){
		return this.subbranch;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支行名称
	 */
	public void setSubbranch(java.lang.String subbranch){
		this.subbranch = subbranch;
	}
	
}
