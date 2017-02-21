package com.wkb.user.bean;

import java.util.Date;

import com.wkb.core.util.Page;

/**
 * 由数据库表 monitor_user 生成
 * 
 */
public class MonitorUser {
    /**
     * 由表字段 monitor_user.id 生成
     * 监控系统用户主键id
     */
    private Integer id;

    /**
     * 由表字段 monitor_user.user_id 生成
     * 用户名
     */
    private String userId;

    /**
     * 由表字段 monitor_user.user_phone 生成
     * 手机号
     */
    private String userPhone;

    /**
     * 由表字段 monitor_user.user_password 生成
     * 用户密码
     */
    private String userPassword;

    /**
     * 由表字段 monitor_user.user_salt 生成
     * 密码盐值
     */
    private String userSalt;

    /**
     * 由表字段 monitor_user.user_status 生成
     * 用户状态 0:不可用 1:可用
     */
    private Integer userStatus;

    /**
     * 由表字段 monitor_user.creator 生成
     * 创建时间
     */
    private String creator;

    /**
     * 由表字段 monitor_user.create_time 生成
     * 创建时间
     */
    private Date createTime;
    private Page page;//分页对象
    /**
     * 本方法返回数据表字段  monitor_user.id 的值
     * 监控系统用户主键id
     * @return the value of monitor_user.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 本方法设置数据表字段 monitor_user.id 的值
     * 监控系统用户主键id
     * @param id the value for monitor_user.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 本方法返回数据表字段  monitor_user.user_id 的值
     * 用户名
     * @return the value of monitor_user.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 本方法设置数据表字段 monitor_user.user_id 的值
     * 用户名
     * @param userId the value for monitor_user.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_user.user_phone 的值
     * 手机号
     * @return the value of monitor_user.user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 本方法设置数据表字段 monitor_user.user_phone 的值
     * 手机号
     * @param userPhone the value for monitor_user.user_phone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_user.user_password 的值
     * 用户密码
     * @return the value of monitor_user.user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 本方法设置数据表字段 monitor_user.user_password 的值
     * 用户密码
     * @param userPassword the value for monitor_user.user_password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_user.user_salt 的值
     * 密码盐值
     * @return the value of monitor_user.user_salt
     */
    public String getUserSalt() {
        return userSalt;
    }

    /**
     * 本方法设置数据表字段 monitor_user.user_salt 的值
     * 密码盐值
     * @param userSalt the value for monitor_user.user_salt
     */
    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt == null ? null : userSalt.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_user.user_status 的值
     * 用户状态 0:不可用 1:可用
     * @return the value of monitor_user.user_status
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 本方法设置数据表字段 monitor_user.user_status 的值
     * 用户状态 0:不可用 1:可用
     * @param userStatus the value for monitor_user.user_status
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 本方法返回数据表字段  monitor_user.creator 的值
     * 创建时间
     * @return the value of monitor_user.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 本方法设置数据表字段 monitor_user.creator 的值
     * 创建时间
     * @param creator the value for monitor_user.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_user.create_time 的值
     * 创建时间
     * @return the value of monitor_user.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 本方法设置数据表字段 monitor_user.create_time 的值
     * 创建时间
     * @param createTime the value for monitor_user.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
    
}