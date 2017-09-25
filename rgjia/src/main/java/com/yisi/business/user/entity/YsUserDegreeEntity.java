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
 * @Description: 用户学历
 * @author onlineGenerator
 * @date 2017-06-26 21:17:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ys_user_degree", schema = "")
@SuppressWarnings("serial")
public class YsUserDegreeEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**用户ID*/
    @Excel(name="用户ID")
	private java.lang.Integer userId;
    
    private YsUserEntity ysUser;
	/**学校名称*/
    @Excel(name="学校名称")
	private java.lang.String school;
	/**学历*/
    @Excel(name="学历")
	private java.lang.String education;
	/**专业*/
    @Excel(name="专业")
	private java.lang.String specialty;
	/**入学时间*/
    @Excel(name="入学时间",format = "yyyy-MM-dd")
	private java.util.Date startDate;
	/**毕业时间*/
    @Excel(name="毕业时间",format = "yyyy-MM-dd")
	private java.util.Date endDate;
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
	 *@return: java.lang.String  学校名称
	 */
	
	@Column(name ="SCHOOL",nullable=true,length=500)
	public java.lang.String getSchool(){
		return this.school;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校名称
	 */
	public void setSchool(java.lang.String school){
		this.school = school;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */
	
	@Column(name ="EDUCATION",nullable=true,length=500)
	public java.lang.String getEducation(){
		return this.education;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setEducation(java.lang.String education){
		this.education = education;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */
	
	@Column(name ="SPECIALTY",nullable=true,length=500)
	public java.lang.String getSpecialty(){
		return this.specialty;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setSpecialty(java.lang.String specialty){
		this.specialty = specialty;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入学时间
	 */
	
	@Column(name ="START_DATE",nullable=true)
	public java.util.Date getStartDate(){
		return this.startDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入学时间
	 */
	public void setStartDate(java.util.Date startDate){
		this.startDate = startDate;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  毕业时间
	 */
	
	@Column(name ="END_DATE",nullable=true)
	public java.util.Date getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  毕业时间
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
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
