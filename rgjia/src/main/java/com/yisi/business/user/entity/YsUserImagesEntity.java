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
 * @Description: 用户图片
 * @author onlineGenerator
 * @date 2017-06-26 21:17:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ys_user_images", schema = "")
@SuppressWarnings("serial")
public class YsUserImagesEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**用户ID*/
    @Excel(name="用户ID")
	private java.lang.Integer userId;
    
    private YsUserEntity ysUser;
	/**图片路径*/
    @Excel(name="图片路径")
	private java.lang.String imageUrl;
	
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
	 *@return: java.lang.String  图片路径
	 */
	
	@Column(name ="IMAGE_URL",nullable=true,length=500)
	public java.lang.String getImageUrl(){
		return this.imageUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片路径
	 */
	public void setImageUrl(java.lang.String imageUrl){
		this.imageUrl = imageUrl;
	}
	
}
