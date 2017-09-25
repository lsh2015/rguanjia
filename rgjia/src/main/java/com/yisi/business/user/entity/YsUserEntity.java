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
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 用户管理
 * @author onlineGenerator
 * @date 2017-06-26 21:17:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ys_user", schema = "")
@SuppressWarnings("serial")
public class YsUserEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**级别*/
	private java.lang.String grade;
	/**级别说明*/
	private java.lang.String gradeName;
	/**芝麻积分*/
	private java.math.BigDecimal sesamePoint;
	/**邀请码*/
	private java.lang.String inviteCode;
	/**订单数*/
	private java.lang.Integer agreement;
	/**访客数*/
	private java.lang.Integer visitor;
	/**自我介绍*/
	private java.lang.String introduction;
	/**个人优势*/
	private java.lang.String advantage;
	/**职业经历*/
	private java.lang.String experience;
	/**资料完善度*/
	private java.lang.Integer perfect;
	/**缴纳保证金*/
	private java.lang.Integer isDeposit;
	/**推荐人数*/
	private java.lang.Integer refferNum;
	/**上级推荐人*/
	private java.lang.Integer parentId;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String remark;
	/**状态*/
	private java.lang.Integer status;
	/**手机号码*/
    @Excel(name="手机号码")
	private java.lang.String mobile;
	/**用户名*/
    @Excel(name="用户名")
	private java.lang.String userName;
	/**邮箱*/
	private java.lang.String email;
	/**头像*/
    @Excel(name="头像")
	private java.lang.String image;
	/**注册时间*/
	private java.util.Date createTime;
	/**出生年月*/
    @Excel(name="出生年月",format = "yyyy-MM-dd")
	private java.util.Date birthday;
	/**注册IP*/
	private java.lang.String createIp;
	/**注册城市*/
	private java.lang.String createCity;
	/**QQ号*/
	private java.lang.String qqNumber;
	/**微博号*/
	private java.lang.String weiboNumber;
	/**微信号*/
	private java.lang.String weixinNumber;
	/**QQID*/
	private java.lang.String qqId;
	/**微博ID*/
	private java.lang.String weiboId;
	/**微信ID*/
	private java.lang.String weixinId;
	/**支付宝账号*/
	private java.lang.String zfb;
	/**微信账号*/
	private java.lang.String weixi;
	/**实名认证*/
	private java.lang.Integer realName;
	/**企业认证*/
	private java.lang.Integer companyAuth;
	/**一级密码*/
	private java.lang.String passwordOne;
	/**二级密码*/
	private java.lang.String passwordTwo;
	/**性别*/
    @Excel(name="性别")
	private java.lang.String sex;
	/**呢称*/
    @Excel(name="呢称")
	private java.lang.String nickName;
	/**经度*/
	private java.lang.Double longitude;
	/**纬度*/
	private java.lang.Double latitude;
	/**个推ID*/
	private java.lang.String clinetId;
	/**免打拢*/
	private java.lang.String trouble;
	/**隐身登录*/
	private java.lang.String hiding;
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
	/**用户属性*/
	private java.lang.Integer userType;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name ="ID",nullable=false,length=20)
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
	 *@return: java.lang.String  级别
	 */
	
	@Column(name ="GRADE",nullable=true,length=20)
	public java.lang.String getGrade(){
		return this.grade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  级别
	 */
	public void setGrade(java.lang.String grade){
		this.grade = grade;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  级别说明
	 */
	
	@Column(name ="GRADE_NAME",nullable=true,length=200)
	public java.lang.String getGradeName(){
		return this.gradeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  级别说明
	 */
	public void setGradeName(java.lang.String gradeName){
		this.gradeName = gradeName;
	}
	
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  芝麻积分
	 */
	
	@Column(name ="SESAME_POINT",nullable=true,scale=2,length=12)
	public java.math.BigDecimal getSesamePoint(){
		return this.sesamePoint;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  芝麻积分
	 */
	public void setSesamePoint(java.math.BigDecimal sesamePoint){
		this.sesamePoint = sesamePoint;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀请码
	 */
	
	@Column(name ="INVITE_CODE",nullable=true,length=10)
	public java.lang.String getInviteCode(){
		return this.inviteCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀请码
	 */
	public void setInviteCode(java.lang.String inviteCode){
		this.inviteCode = inviteCode;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单数
	 */
	
	@Column(name ="AGREEMENT",nullable=true,length=10)
	public java.lang.Integer getAgreement(){
		return this.agreement;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单数
	 */
	public void setAgreement(java.lang.Integer agreement){
		this.agreement = agreement;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  访客数
	 */
	
	@Column(name ="VISITOR",nullable=true,length=10)
	public java.lang.Integer getVisitor(){
		return this.visitor;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  访客数
	 */
	public void setVisitor(java.lang.Integer visitor){
		this.visitor = visitor;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  自我介绍
	 */
	
	@Column(name ="INTRODUCTION",nullable=true,length=5000)
	public java.lang.String getIntroduction(){
		return this.introduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  自我介绍
	 */
	public void setIntroduction(java.lang.String introduction){
		this.introduction = introduction;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人优势
	 */
	
	@Column(name ="ADVANTAGE",nullable=true,length=5000)
	public java.lang.String getAdvantage(){
		return this.advantage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人优势
	 */
	public void setAdvantage(java.lang.String advantage){
		this.advantage = advantage;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职业经历
	 */
	
	@Column(name ="EXPERIENCE",nullable=true,length=5000)
	public java.lang.String getExperience(){
		return this.experience;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职业经历
	 */
	public void setExperience(java.lang.String experience){
		this.experience = experience;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  资料完善度
	 */
	
	@Column(name ="PERFECT",nullable=true,length=10)
	public java.lang.Integer getPerfect(){
		return this.perfect;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  资料完善度
	 */
	public void setPerfect(java.lang.Integer perfect){
		this.perfect = perfect;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  缴纳保证金
	 */
	
	@Column(name ="IS_DEPOSIT",nullable=true,length=10)
	public java.lang.Integer getIsDeposit(){
		return this.isDeposit;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  缴纳保证金
	 */
	public void setIsDeposit(java.lang.Integer isDeposit){
		this.isDeposit = isDeposit;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  推荐人数
	 */
	
	@Column(name ="REFFER_NUM",nullable=true,length=10)
	public java.lang.Integer getRefferNum(){
		return this.refferNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  推荐人数
	 */
	public void setRefferNum(java.lang.Integer refferNum){
		this.refferNum = refferNum;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  上级推荐人
	 */
	
	@Column(name ="PARENT_ID",nullable=true,length=10)
	public java.lang.Integer getParentId(){
		return this.parentId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  上级推荐人
	 */
	public void setParentId(java.lang.Integer parentId){
		this.parentId = parentId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="REMARK",nullable=true,length=300)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号码
	 */
	
	@Column(name ="MOBILE",nullable=true,length=20)
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
	 *@return: java.lang.String  用户名
	 */
	
	@Column(name ="USER_NAME",nullable=true,length=200)
	public java.lang.String getUserName(){
		return this.userName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名
	 */
	public void setUserName(java.lang.String userName){
		this.userName = userName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮箱
	 */
	
	@Column(name ="EMAIL",nullable=true,length=50)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮箱
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */
	
	@Column(name ="IMAGE",nullable=true,length=200)
	public java.lang.String getImage(){
		return this.image;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setImage(java.lang.String image){
		this.image = image;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  注册时间
	 */
	
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  注册时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生年月
	 */
	
	@Column(name ="BIRTHDAY",nullable=true)
	public java.util.Date getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生年月
	 */
	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册IP
	 */
	
	@Column(name ="CREATE_IP",nullable=true,length=50)
	public java.lang.String getCreateIp(){
		return this.createIp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册IP
	 */
	public void setCreateIp(java.lang.String createIp){
		this.createIp = createIp;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册城市
	 */
	
	@Column(name ="CREATE_CITY",nullable=true,length=200)
	public java.lang.String getCreateCity(){
		return this.createCity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册城市
	 */
	public void setCreateCity(java.lang.String createCity){
		this.createCity = createCity;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  QQ号
	 */
	
	@Column(name ="QQ_NUMBER",nullable=true,length=50)
	public java.lang.String getQqNumber(){
		return this.qqNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  QQ号
	 */
	public void setQqNumber(java.lang.String qqNumber){
		this.qqNumber = qqNumber;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微博号
	 */
	
	@Column(name ="WEIBO_NUMBER",nullable=true,length=50)
	public java.lang.String getWeiboNumber(){
		return this.weiboNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微博号
	 */
	public void setWeiboNumber(java.lang.String weiboNumber){
		this.weiboNumber = weiboNumber;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信号
	 */
	
	@Column(name ="WEIXIN_NUMBER",nullable=true,length=50)
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
	 *@return: java.lang.String  QQID
	 */
	
	@Column(name ="QQ_ID",nullable=true,length=50)
	public java.lang.String getQqId(){
		return this.qqId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  QQID
	 */
	public void setQqId(java.lang.String qqId){
		this.qqId = qqId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微博ID
	 */
	
	@Column(name ="WEIBO_ID",nullable=true,length=50)
	public java.lang.String getWeiboId(){
		return this.weiboId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微博ID
	 */
	public void setWeiboId(java.lang.String weiboId){
		this.weiboId = weiboId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信ID
	 */
	
	@Column(name ="WEIXIN_ID",nullable=true,length=50)
	public java.lang.String getWeixinId(){
		return this.weixinId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信ID
	 */
	public void setWeixinId(java.lang.String weixinId){
		this.weixinId = weixinId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付宝账号
	 */
	
	@Column(name ="ZFB",nullable=true,length=50)
	public java.lang.String getZfb(){
		return this.zfb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付宝账号
	 */
	public void setZfb(java.lang.String zfb){
		this.zfb = zfb;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信账号
	 */
	
	@Column(name ="WEIXI",nullable=true,length=50)
	public java.lang.String getWeixi(){
		return this.weixi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信账号
	 */
	public void setWeixi(java.lang.String weixi){
		this.weixi = weixi;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  实名认证
	 */
	
	@Column(name ="REAL_NAME",nullable=true,length=10)
	public java.lang.Integer getRealName(){
		return this.realName;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  实名认证
	 */
	public void setRealName(java.lang.Integer realName){
		this.realName = realName;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  企业认证
	 */
	
	@Column(name ="COMPANY_AUTH",nullable=true,length=10)
	public java.lang.Integer getCompanyAuth(){
		return this.companyAuth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  企业认证
	 */
	public void setCompanyAuth(java.lang.Integer companyAuth){
		this.companyAuth = companyAuth;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  一级密码
	 */
	
	@Column(name ="PASSWORD_ONE",nullable=true,length=50)
	public java.lang.String getPasswordOne(){
		return this.passwordOne;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  一级密码
	 */
	public void setPasswordOne(java.lang.String passwordOne){
		this.passwordOne = passwordOne;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  二级密码
	 */
	
	@Column(name ="PASSWORD_TWO",nullable=true,length=50)
	public java.lang.String getPasswordTwo(){
		return this.passwordTwo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  二级密码
	 */
	public void setPasswordTwo(java.lang.String passwordTwo){
		this.passwordTwo = passwordTwo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	
	@Column(name ="SEX",nullable=true,length=10)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  呢称
	 */
	
	@Column(name ="NICK_NAME",nullable=true,length=100)
	public java.lang.String getNickName(){
		return this.nickName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  呢称
	 */
	public void setNickName(java.lang.String nickName){
		this.nickName = nickName;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  经度
	 */
	
	@Column(name ="LONGITUDE",nullable=true,scale=6,length=6)
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
	
	@Column(name ="LATITUDE",nullable=true,scale=6,length=6)
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
	 *@return: java.lang.String  个推ID
	 */
	
	@Column(name ="CLINET_ID",nullable=true,length=36)
	public java.lang.String getClinetId(){
		return this.clinetId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个推ID
	 */
	public void setClinetId(java.lang.String clinetId){
		this.clinetId = clinetId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  免打拢
	 */
	
	@Column(name ="TROUBLE",nullable=true,length=10)
	public java.lang.String getTrouble(){
		return this.trouble;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  免打拢
	 */
	public void setTrouble(java.lang.String trouble){
		this.trouble = trouble;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  隐身登录
	 */
	
	@Column(name ="HIDING",nullable=true,length=10)
	public java.lang.String getHiding(){
		return this.hiding;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  隐身登录
	 */
	public void setHiding(java.lang.String hiding){
		this.hiding = hiding;
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
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  用户属性
	 */
	
	@Column(name ="USER_TYPE",nullable=true,length=10)
	public java.lang.Integer getUserType(){
		return this.userType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  用户属性
	 */
	public void setUserType(java.lang.Integer userType){
		this.userType = userType;
	}
	
}
