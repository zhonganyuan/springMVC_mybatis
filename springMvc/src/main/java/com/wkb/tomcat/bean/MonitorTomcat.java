package com.wkb.tomcat.bean;

import java.util.Date;

import com.wkb.core.util.Page;

/**
 * 由数据库表 monitor_tomcat 生成
 * 
 */
public class MonitorTomcat {
    /**
     * 由表字段 monitor_tomcat.id 生成
     * tomcat 信息主键
     */
    private Integer id;

    /**
     * 由表字段 monitor_tomcat.inner_code 生成
     * tomcat 内部关联编码
     */
    private Long innerCode;

    /**
     * 由表字段 monitor_tomcat.ip 生成
     * tomcat 主机ip
     */
    private String ip;

    /**
     * 由表字段 monitor_tomcat.host 生成
     * tomat 所在主机
     */
    private String host;

    /**
     * 由表字段 monitor_tomcat.name 生成
     * tomcat 名称
     */
    private String name;

    /**
     * 由表字段 monitor_tomcat.port 生成
     * tomcat 占用端口
     */
    private String port;

    /**
     * 由表字段 monitor_tomcat.web_port 生成
     * web端口
     */
    private Integer webPort;

    /**
     * 由表字段 monitor_tomcat.jmx_port 生成
     * jmx 监听端口
     */
    private Integer jmxPort;

    /**
     * 由表字段 monitor_tomcat.io_type 生成
     * IO流模式类型 
     */
    private String ioType;

    /**
     * 由表字段 monitor_tomcat.create_time 生成
     * 创建时间
     */
    private Date createTime;

    /**
     * 由表字段 monitor_tomcat.creator 生成
     * 创建人
     */
    private String creator;

    /**
     * 由表字段 monitor_tomcat.update_time 生成
     * 更新时间
     */
    private Date updateTime;

    /**
     * 由表字段 monitor_tomcat.updator 生成
     * 更新时间
     */
    private String updator;

    /**
     * 由表字段 monitor_tomcat.threshold 生成
     * tomcat 阀值 json 格式
     */
    private String threshold;
    private Page page;//分页对象
    /**
     * 本方法返回数据表字段  monitor_tomcat.id 的值
     * tomcat 信息主键
     * @return the value of monitor_tomcat.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.id 的值
     * tomcat 信息主键
     * @param id the value for monitor_tomcat.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.inner_code 的值
     * tomcat 内部关联编码
     * @return the value of monitor_tomcat.inner_code
     */
    public Long getInnerCode() {
        return innerCode;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.inner_code 的值
     * tomcat 内部关联编码
     * @param innerCode the value for monitor_tomcat.inner_code
     */
    public void setInnerCode(Long innerCode) {
        this.innerCode = innerCode;
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.ip 的值
     * tomcat 主机ip
     * @return the value of monitor_tomcat.ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.ip 的值
     * tomcat 主机ip
     * @param ip the value for monitor_tomcat.ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.host 的值
     * tomat 所在主机
     * @return the value of monitor_tomcat.host
     */
    public String getHost() {
        return host;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.host 的值
     * tomat 所在主机
     * @param host the value for monitor_tomcat.host
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.name 的值
     * tomcat 名称
     * @return the value of monitor_tomcat.name
     */
    public String getName() {
        return name;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.name 的值
     * tomcat 名称
     * @param name the value for monitor_tomcat.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.port 的值
     * tomcat 占用端口
     * @return the value of monitor_tomcat.port
     */
    public String getPort() {
        return port;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.port 的值
     * tomcat 占用端口
     * @param port the value for monitor_tomcat.port
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.web_port 的值
     * web端口
     * @return the value of monitor_tomcat.web_port
     */
    public Integer getWebPort() {
        return webPort;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.web_port 的值
     * web端口
     * @param webPort the value for monitor_tomcat.web_port
     */
    public void setWebPort(Integer webPort) {
        this.webPort = webPort;
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.jmx_port 的值
     * jmx 监听端口
     * @return the value of monitor_tomcat.jmx_port
     */
    public Integer getJmxPort() {
        return jmxPort;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.jmx_port 的值
     * jmx 监听端口
     * @param jmxPort the value for monitor_tomcat.jmx_port
     */
    public void setJmxPort(Integer jmxPort) {
        this.jmxPort = jmxPort;
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.io_type 的值
     * IO流模式类型 
     * @return the value of monitor_tomcat.io_type
     */
    public String getIoType() {
        return ioType;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.io_type 的值
     * IO流模式类型 
     * @param ioType the value for monitor_tomcat.io_type
     */
    public void setIoType(String ioType) {
        this.ioType = ioType == null ? null : ioType.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.create_time 的值
     * 创建时间
     * @return the value of monitor_tomcat.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.create_time 的值
     * 创建时间
     * @param createTime the value for monitor_tomcat.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.creator 的值
     * 创建人
     * @return the value of monitor_tomcat.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.creator 的值
     * 创建人
     * @param creator the value for monitor_tomcat.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.update_time 的值
     * 更新时间
     * @return the value of monitor_tomcat.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.update_time 的值
     * 更新时间
     * @param updateTime the value for monitor_tomcat.update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.updator 的值
     * 更新时间
     * @return the value of monitor_tomcat.updator
     */
    public String getUpdator() {
        return updator;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.updator 的值
     * 更新时间
     * @param updator the value for monitor_tomcat.updator
     */
    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }

    /**
     * 本方法返回数据表字段  monitor_tomcat.threshold 的值
     * tomcat 阀值 json 格式
     * @return the value of monitor_tomcat.threshold
     */
    public String getThreshold() {
        return threshold;
    }

    /**
     * 本方法设置数据表字段 monitor_tomcat.threshold 的值
     * tomcat 阀值 json 格式
     * @param threshold the value for monitor_tomcat.threshold
     */
    public void setThreshold(String threshold) {
        this.threshold = threshold == null ? null : threshold.trim();
    }

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
    
}