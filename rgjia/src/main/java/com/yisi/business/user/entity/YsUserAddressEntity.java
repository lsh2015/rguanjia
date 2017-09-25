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
 * @Description: 用户地址
 * @author onlineGenerator
 * @date 2017-06-26 21:17:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ys_user_address", schema = "")
@SuppressWarnings("serial")
public class YsUserAddressEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**用户ID*/
    @Excel(name="用户ID")
	private java.lang.Integer userId;
    
    private YsUserEntity ysUser;
	/**地址*/
    @Excel(name="地址")
	private java.lang.String addressInfo;
	/**地址图片*/
    @Excel(name="地址图片")
	private java.lang.String images;
	/**经度*/
    @Excel(name="经度")
	private java.lang.Double longitude;
	/**纬度*/
    @Excel(name="纬度")
	private java.lang.Double latitude;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String remark;
	/**状态*/
    @Excel(name="状态")
	private java.lang.Integer status;
	/**创建时间*/
    @Excel(name="创建时间",format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**创建人*/
    @Excel(name="创建人")
	private java.lang.String createName;
	/**修改时间*/
    @Excel(name="修改时间",format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	/**修改人*/
    @Excel(name="修改人")
	private java.lang.String updateName;
	/**所属公司*/
    @Excel(name="所属公司")
	private java.lang.String sysCompanyCode;
	/**所属部门*/
    @Excel(name="所属部门")
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  用户ID
	 */
	
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
	 *@return: java.lang.String  地址
	 */
	
	@Column(name ="ADDRESS_INFO",nullable=true,length=500)
	public java.lang.String getAddressInfo(){
		return this.addressInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setAddressInfo(java.lang.String addressInfo){
		this.addressInfo = addressInfo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址图片
	 */
	
	@Column(name ="IMAGES",nullable=true,length=500)
	public java.lang.String getImages(){
		return this.images;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址图片
	 */
	public void setImages(java.lang.String images){
		this.images = images;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  经度
	 */
	
	@Column(name ="LONGITUDE",nullable=true,scale=6,length=12)
	public java.lang.Double getLongitude(){
		return this.longitude;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  经度
	 */
	public void setLongitude(java.lang.Double longitude){
		this.longitude = longitude;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  纬度
	 */
	
	@Column(name ="LATITUDE",nullable=true,scale=6,length=12)
	public java.lang.Double getLatitude(){
		return this.latitude;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  纬度
	 */
	public void setLatitude(java.lang.Double latitude){
		this.latitude = latitude;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="REMARK",nullable=true,length=200)
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
