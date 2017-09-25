package com.yisi.business.about.entity;

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
 * @Description: 项目介绍
 * @author onlineGenerator
 * @date 2017-06-27 17:19:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ys_about", schema = "")
@SuppressWarnings("serial")
public class YsAboutEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**名称*/
	@Excel(name="名称")
	private java.lang.String projectName;
	/**网址*/
	@Excel(name="网址")
	private java.lang.String projectUrl;
	/**关于项目*/
	@Excel(name="关于项目")
	private java.lang.String about;
	/**简介*/
	@Excel(name="简介")
	private java.lang.String synopsis;
	/**logo*/
	@Excel(name="logo")
	private java.lang.String logo;
	/**公司图片*/
	@Excel(name="公司图片")
	private java.lang.String images;
	/**客服电话*/
	@Excel(name="客服电话")
	private java.lang.String serviceTel;
	/**QQ*/
	@Excel(name="QQ")
	private java.lang.String qqNumber;
	/**微信号*/
	@Excel(name="微信号")
	private java.lang.String weixinNumber;
	/**微信二维码*/
	@Excel(name="微信二维码")
	private java.lang.String weixinImage;
	/**邮箱*/
	@Excel(name="邮箱")
	private java.lang.String mail;
	/**微博*/
	@Excel(name="微博")
	private java.lang.String weiboNumber;
	/**地址*/
	@Excel(name="地址")
	private java.lang.String projectAddress;
	/**法人*/
	private java.lang.String legalPerson;
	/**营业执照*/
	private java.lang.String businessLicense;
	/**执照号*/
	private java.lang.String licenseNo;
	/**身份证号*/
	private java.lang.String idNumber;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	@Column(name ="PROJECT_NAME",nullable=true,length=200)
	public java.lang.String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setProjectName(java.lang.String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  网址
	 */
	@Column(name ="PROJECT_URL",nullable=true,length=200)
	public java.lang.String getProjectUrl(){
		return this.projectUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  网址
	 */
	public void setProjectUrl(java.lang.String projectUrl){
		this.projectUrl = projectUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关于项目
	 */
	@Column(name ="ABOUT",nullable=true,length=5000)
	public java.lang.String getAbout(){
		return this.about;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关于项目
	 */
	public void setAbout(java.lang.String about){
		this.about = about;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简介
	 */
	@Column(name ="SYNOPSIS",nullable=true,length=5000)
	public java.lang.String getSynopsis(){
		return this.synopsis;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简介
	 */
	public void setSynopsis(java.lang.String synopsis){
		this.synopsis = synopsis;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  logo
	 */
	@Column(name ="LOGO",nullable=true,length=200)
	public java.lang.String getLogo(){
		return this.logo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  logo
	 */
	public void setLogo(java.lang.String logo){
		this.logo = logo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司图片
	 */
	@Column(name ="IMAGES",nullable=true,length=200)
	public java.lang.String getImages(){
		return this.images;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司图片
	 */
	public void setImages(java.lang.String images){
		this.images = images;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客服电话
	 */
	@Column(name ="SERVICE_TEL",nullable=true,length=200)
	public java.lang.String getServiceTel(){
		return this.serviceTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客服电话
	 */
	public void setServiceTel(java.lang.String serviceTel){
		this.serviceTel = serviceTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  QQ
	 */
	@Column(name ="QQ_NUMBER",nullable=true,length=200)
	public java.lang.String getQqNumber(){
		return this.qqNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  QQ
	 */
	public void setQqNumber(java.lang.String qqNumber){
		this.qqNumber = qqNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信号
	 */
	@Column(name ="WEIXIN_NUMBER",nullable=true,length=200)
	public java.lang.String getWeixinNumber(){
		return this.weixinNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信号
	 */
	public void setWeixinNumber(java.lang.String weixinNumber){
		this.weixinNumber = weixinNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信二维码
	 */
	@Column(name ="WEIXIN_IMAGE",nullable=true,length=200)
	public java.lang.String getWeixinImage(){
		return this.weixinImage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信二维码
	 */
	public void setWeixinImage(java.lang.String weixinImage){
		this.weixinImage = weixinImage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮箱
	 */
	@Column(name ="MAIL",nullable=true,length=200)
	public java.lang.String getMail(){
		return this.mail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮箱
	 */
	public void setMail(java.lang.String mail){
		this.mail = mail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微博
	 */
	@Column(name ="WEIBO_NUMBER",nullable=true,length=200)
	public java.lang.String getWeiboNumber(){
		return this.weiboNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微博
	 */
	public void setWeiboNumber(java.lang.String weiboNumber){
		this.weiboNumber = weiboNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */
	@Column(name ="PROJECT_ADDRESS",nullable=true,length=200)
	public java.lang.String getProjectAddress(){
		return this.projectAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setProjectAddress(java.lang.String projectAddress){
		this.projectAddress = projectAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  法人
	 */
	@Column(name ="LEGAL_PERSON",nullable=true,length=200)
	public java.lang.String getLegalPerson(){
		return this.legalPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  法人
	 */
	public void setLegalPerson(java.lang.String legalPerson){
		this.legalPerson = legalPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  营业执照
	 */
	@Column(name ="BUSINESS_LICENSE",nullable=true,length=200)
	public java.lang.String getBusinessLicense(){
		return this.businessLicense;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  营业执照
	 */
	public void setBusinessLicense(java.lang.String businessLicense){
		this.businessLicense = businessLicense;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  执照号
	 */
	@Column(name ="LICENSE_NO",nullable=true,length=200)
	public java.lang.String getLicenseNo(){
		return this.licenseNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  执照号
	 */
	public void setLicenseNo(java.lang.String licenseNo){
		this.licenseNo = licenseNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="ID_NUMBER",nullable=true,length=200)
	public java.lang.String getIdNumber(){
		return this.idNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdNumber(java.lang.String idNumber){
		this.idNumber = idNumber;
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
}
