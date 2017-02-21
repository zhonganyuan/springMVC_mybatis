package com.wkb.emoticon.bean;


import java.io.Serializable;
import java.util.Date;

/**
 * 由数据库表 emoticon 生成
 * 
 */
public class Emoticon implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 由表字段 emoticon.id 生成
     * 
     */
    private Integer id;

    /**
     * 由表字段 emoticon.category_id 生成
     * 类别id
     */
    private Integer categoryId;

    /**
     * 由表字段 emoticon.url 生成
     * 图片url
     */
    private String url;

    /**
     * 由表字段 emoticon.create_time 生成
     * 创建时间
     */
    private Date createTime;

    /**
     * 由表字段 emoticon.name 生成
     * 图片昵称
     */
    private String name;

    /**
     * 由表字段 emoticon.creater 生成
     * 创建人
     */
    private String creater;

    /**
     * 由表字段 emoticon.status 生成
     * 表情状态1.未审核2.审核通过
     */
    private String status;

    /**
     * 由表字段 emoticon.creater_head 生成
     * 创建人头像
     */
    private String createrHead;

    /**
     * 由表字段 emoticon.browsing_times 生成
     * 默认0 按次数排序
     */
    private Integer browsingTimes;

    /**
     * 由表字段 emoticon.type 生成
     * 图片类型1.image2.gif 暂时保留
     */
    private Integer type;

    /**
     * 本方法返回数据表字段  emoticon.id 的值
     * 
     * @return the value of emoticon.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 本方法设置数据表字段 emoticon.id 的值
     * 
     * @param id the value for emoticon.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 本方法返回数据表字段  emoticon.category_id 的值
     * 类别id
     * @return the value of emoticon.category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 本方法设置数据表字段 emoticon.category_id 的值
     * 类别id
     * @param categoryId the value for emoticon.category_id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 本方法返回数据表字段  emoticon.url 的值
     * 图片url
     * @return the value of emoticon.url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 本方法设置数据表字段 emoticon.url 的值
     * 图片url
     * @param url the value for emoticon.url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 本方法返回数据表字段  emoticon.create_time 的值
     * 创建时间
     * @return the value of emoticon.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 本方法设置数据表字段 emoticon.create_time 的值
     * 创建时间
     * @param createTime the value for emoticon.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 本方法返回数据表字段  emoticon.name 的值
     * 图片昵称
     * @return the value of emoticon.name
     */
    public String getName() {
        return name;
    }

    /**
     * 本方法设置数据表字段 emoticon.name 的值
     * 图片昵称
     * @param name the value for emoticon.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 本方法返回数据表字段  emoticon.creater 的值
     * 创建人
     * @return the value of emoticon.creater
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 本方法设置数据表字段 emoticon.creater 的值
     * 创建人
     * @param creater the value for emoticon.creater
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 本方法返回数据表字段  emoticon.status 的值
     * 表情状态1.未审核2.审核通过
     * @return the value of emoticon.status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 本方法设置数据表字段 emoticon.status 的值
     * 表情状态1.未审核2.审核通过
     * @param status the value for emoticon.status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 本方法返回数据表字段  emoticon.creater_head 的值
     * 创建人头像
     * @return the value of emoticon.creater_head
     */
    public String getCreaterHead() {
        return createrHead;
    }

    /**
     * 本方法设置数据表字段 emoticon.creater_head 的值
     * 创建人头像
     * @param createrHead the value for emoticon.creater_head
     */
    public void setCreaterHead(String createrHead) {
        this.createrHead = createrHead == null ? null : createrHead.trim();
    }

    /**
     * 本方法返回数据表字段  emoticon.browsing_times 的值
     * 默认0 按次数排序
     * @return the value of emoticon.browsing_times
     */
    public Integer getBrowsingTimes() {
        return browsingTimes;
    }

    /**
     * 本方法设置数据表字段 emoticon.browsing_times 的值
     * 默认0 按次数排序
     * @param browsingTimes the value for emoticon.browsing_times
     */
    public void setBrowsingTimes(Integer browsingTimes) {
        this.browsingTimes = browsingTimes;
    }

    /**
     * 本方法返回数据表字段  emoticon.type 的值
     * 图片类型1.image2.gif 暂时保留
     * @return the value of emoticon.type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 本方法设置数据表字段 emoticon.type 的值
     * 图片类型1.image2.gif 暂时保留
     * @param type the value for emoticon.type
     */
    public void setType(Integer type) {
        this.type = type;
    }
}