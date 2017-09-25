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
 * @Description: 用户工作
 * @author onlineGenerator
 * @date 2017-06-26 21:17:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ys_user_work", schema = "")
@SuppressWarnings("serial")
public class YsUserWorkEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**用户ID*/
    @Excel(name="用户ID")
	private java.lang.Integer userId;
    
    private YsUserEntity ysUser;
	/**单位名称*/
    @Excel(name="单位名称")
	private java.lang.String company;
	/**职业*/
    @Excel(name="职业")
	private java.lang.String profession;
	/**入职时间*/
    @Excel(name="入职时间",format = "yyyy-MM-dd")
	private java.util.Date startDate;
	/**离职时间*/
    @Excel(name="离职时间",format = "yyyy-MM-dd")
	private java.util.Date endDate;
	/**工作内容*/
    @Excel(name="工作内容")
	private java.lang.String workInfo;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String remark;
	
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
	 *@return: java.lang.String  单位名称
	 */
	
	@Column(name ="COMPANY",nullable=true,length=500)
	public java.lang.String getCompany(){
		return this.company;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位名称
	 */
	public void setCompany(java.lang.String company){
		this.company = company;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职业
	 */
	
	@Column(name ="PROFESSION",nullable=true,length=500)
	public java.lang.String getProfession(){
		return this.profession;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职业
	 */
	public void setProfession(java.lang.String profession){
		this.profession = profession;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入职时间
	 */
	
	@Column(name ="START_DATE",nullable=true)
	public java.util.Date getStartDate(){
		return this.startDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入职时间
	 */
	public void setStartDate(java.util.Date startDate){
		this.startDate = startDate;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  离职时间
	 */
	
	@Column(name ="END_DATE",nullable=true)
	public java.util.Date getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  离职时间
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作内容
	 */
	
	@Column(name ="WORK_INFO",nullable=true,length=5000)
	public java.lang.String getWorkInfo(){
		return this.workInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作内容
	 */
	public void setWorkInfo(java.lang.String workInfo){
		this.workInfo = workInfo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="REMARK",nullable=true,length=500)
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
	
}
