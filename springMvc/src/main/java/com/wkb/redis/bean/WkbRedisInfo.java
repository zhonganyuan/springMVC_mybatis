package com.wkb.redis.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 由数据库表 wkb_redis_info 生成
 * redis服务器信息表
 */
public class WkbRedisInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 由表字段 wkb_redis_info.id 生成
     * 主键
     */
    private Integer id;

    /**
     * 由表字段 wkb_redis_info.name 生成
     * 名称
     */
    private String name;

    /**
     * 由表字段 wkb_redis_info.ip 生成
     * ip地址
     */
    private String ip;

    /**
     * 由表字段 wkb_redis_info.port 生成
     * 端口号
     */
    private String port;

    /**
     * 由表字段 wkb_redis_info.password 生成
     * 密码
     */
    private String password;

    /**
     * 由表字段 wkb_redis_info.create_time 生成
     * 创建时间
     */
    private Date createTime;

    /**
     * 本方法返回数据表字段  wkb_redis_info.id 的值
     * 主键
     * @return the value of wkb_redis_info.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 本方法设置数据表字段 wkb_redis_info.id 的值
     * 主键
     * @param id the value for wkb_redis_info.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 本方法返回数据表字段  wkb_redis_info.name 的值
     * 名称
     * @return the value of wkb_redis_info.name
     */
    public String getName() {
        return name;
    }

    /**
     * 本方法设置数据表字段 wkb_redis_info.name 的值
     * 名称
     * @param name the value for wkb_redis_info.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 本方法返回数据表字段  wkb_redis_info.ip 的值
     * ip地址
     * @return the value of wkb_redis_info.ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 本方法设置数据表字段 wkb_redis_info.ip 的值
     * ip地址
     * @param ip the value for wkb_redis_info.ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 本方法返回数据表字段  wkb_redis_info.port 的值
     * 端口号
     * @return the value of wkb_redis_info.port
     */
    public String getPort() {
        return port;
    }

    /**
     * 本方法设置数据表字段 wkb_redis_info.port 的值
     * 端口号
     * @param port the value for wkb_redis_info.port
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    /**
     * 本方法返回数据表字段  wkb_redis_info.password 的值
     * 密码
     * @return the value of wkb_redis_info.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 本方法设置数据表字段 wkb_redis_info.password 的值
     * 密码
     * @param password the value for wkb_redis_info.password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 本方法返回数据表字段  wkb_redis_info.create_time 的值
     * 创建时间
     * @return the value of wkb_redis_info.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 本方法设置数据表字段 wkb_redis_info.create_time 的值
     * 创建时间
     * @param createTime the value for wkb_redis_info.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}