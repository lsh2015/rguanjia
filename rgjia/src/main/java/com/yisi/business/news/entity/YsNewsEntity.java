package com.yisi.business.news.entity;

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
 * @Description: 新闻管理
 * @author onlineGenerator
 * @date 2017-06-26 22:35:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ys_news", schema = "")
@SuppressWarnings("serial")
public class YsNewsEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**新闻属性*/
	@Excel(name="新闻属性")
	private java.lang.Integer newsType;
	/**标题*/
	@Excel(name="标题")
	private java.lang.String title;
	/**列表图*/
	@Excel(name="列表图")
	private java.lang.String listImage;
	/**标题图*/
	@Excel(name="标题图")
	private java.lang.String bannerImage;
	/**内容*/
	@Excel(name="内容")
	private java.lang.String content;
	/**作者*/
	@Excel(name="作者")
	private java.lang.String author;
	/**热点新闻*/
	private java.lang.Integer hotNews;
	/**置顶新闻*/
	private java.lang.Integer topNews;
	/**点击数*/
	private java.lang.Integer click;
	/**最新新闻*/
	private java.lang.Integer latestNews;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  新闻属性
	 */
	@Column(name ="NEWS_TYPE",nullable=true,length=10)
	public java.lang.Integer getNewsType(){
		return this.newsType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  新闻属性
	 */
	public void setNewsType(java.lang.Integer newsType){
		this.newsType = newsType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=500)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  列表图
	 */
	@Column(name ="LIST_IMAGE",nullable=true,length=200)
	public java.lang.String getListImage(){
		return this.listImage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  列表图
	 */
	public void setListImage(java.lang.String listImage){
		this.listImage = listImage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题图
	 */
	@Column(name ="BANNER_IMAGE",nullable=true,length=200)
	public java.lang.String getBannerImage(){
		return this.bannerImage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题图
	 */
	public void setBannerImage(java.lang.String bannerImage){
		this.bannerImage = bannerImage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=5000)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作者
	 */
	@Column(name ="AUTHOR",nullable=true,length=50)
	public java.lang.String getAuthor(){
		return this.author;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作者
	 */
	public void setAuthor(java.lang.String author){
		this.author = author;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  热点新闻
	 */
	@Column(name ="HOT_NEWS",nullable=true,length=10)
	public java.lang.Integer getHotNews(){
		return this.hotNews;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  热点新闻
	 */
	public void setHotNews(java.lang.Integer hotNews){
		this.hotNews = hotNews;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  置顶新闻
	 */
	@Column(name ="TOP_NEWS",nullable=true,length=10)
	public java.lang.Integer getTopNews(){
		return this.topNews;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  置顶新闻
	 */
	public void setTopNews(java.lang.Integer topNews){
		this.topNews = topNews;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  点击数
	 */
	@Column(name ="CLICK",nullable=true,length=10)
	public java.lang.Integer getClick(){
		return this.click;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  点击数
	 */
	public void setClick(java.lang.Integer click){
		this.click = click;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  最新新闻
	 */
	@Column(name ="LATEST_NEWS",nullable=true,length=10)
	public java.lang.Integer getLatestNews(){
		return this.latestNews;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  最新新闻
	 */
	public void setLatestNews(java.lang.Integer latestNews){
		this.latestNews = latestNews;
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
