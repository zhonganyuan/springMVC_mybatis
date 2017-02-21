package com.wkb.emoticon.bean;


import java.io.Serializable;
import java.util.Date;

/**
 * 由数据库表 user 生成
 * 
 */
public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 由表字段 user.id 生成
     * 
     */
    private Integer id;

    /**
     * 由表字段 user.username 生成
     * 
     */
    private String username;

    /**
     * 由表字段 user.password 生成
     * 
     */
    private String password;

    /**
     * 由表字段 user.create_time 生成
     * 
     */
    private Date createTime;

    /**
     * 本方法返回数据表字段  user.id 的值
     * 
     * @return the value of user.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 本方法设置数据表字段 user.id 的值
     * 
     * @param id the value for user.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 本方法返回数据表字段  user.username 的值
     * 
     * @return the value of user.username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 本方法设置数据表字段 user.username 的值
     * 
     * @param username the value for user.username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 本方法返回数据表字段  user.password 的值
     * 
     * @return the value of user.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 本方法设置数据表字段 user.password 的值
     * 
     * @param password the value for user.password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 本方法返回数据表字段  user.create_time 的值
     * 
     * @return the value of user.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 本方法设置数据表字段 user.create_time 的值
     * 
     * @param createTime the value for user.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}