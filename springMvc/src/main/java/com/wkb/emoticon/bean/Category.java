package com.wkb.emoticon.bean;


import java.io.Serializable;
import java.util.Date;

/**
 * 由数据库表 category 生成
 * 表情类别表
 */
public class Category implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 由表字段 category.id 生成
     * 
     */
    private Integer id;

    /**
     * 由表字段 category.name 生成
     * 类别名称
     */
    private String name;

    /**
     * 由表字段 category.create_time 生成
     * 创建时间
     */
    private Date createTime;

    /**
     * 由表字段 category.creater 生成
     * 创建人
     */
    private String creater;

    /**
     * 由表字段 category.creater_head 生成
     * 上传完人头像
     */
    private String createrHead;

    /**
     * 由表字段 category.is_examine 生成
     * 1.正常2.需要审核
     */
    private String isExamine;

    /**
     * 由表字段 category.cover_url 生成
     * 封面
     */
    private String coverUrl;

    /**
     * 本方法返回数据表字段  category.id 的值
     * 
     * @return the value of category.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 本方法设置数据表字段 category.id 的值
     * 
     * @param id the value for category.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 本方法返回数据表字段  category.name 的值
     * 类别名称
     * @return the value of category.name
     */
    public String getName() {
        return name;
    }

    /**
     * 本方法设置数据表字段 category.name 的值
     * 类别名称
     * @param name the value for category.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 本方法返回数据表字段  category.create_time 的值
     * 创建时间
     * @return the value of category.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 本方法设置数据表字段 category.create_time 的值
     * 创建时间
     * @param createTime the value for category.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 本方法返回数据表字段  category.creater 的值
     * 创建人
     * @return the value of category.creater
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 本方法设置数据表字段 category.creater 的值
     * 创建人
     * @param creater the value for category.creater
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 本方法返回数据表字段  category.creater_head 的值
     * 上传完人头像
     * @return the value of category.creater_head
     */
    public String getCreaterHead() {
        return createrHead;
    }

    /**
     * 本方法设置数据表字段 category.creater_head 的值
     * 上传完人头像
     * @param createrHead the value for category.creater_head
     */
    public void setCreaterHead(String createrHead) {
        this.createrHead = createrHead == null ? null : createrHead.trim();
    }

    /**
     * 本方法返回数据表字段  category.is_examine 的值
     * 1.正常2.需要审核
     * @return the value of category.is_examine
     */
    public String getIsExamine() {
        return isExamine;
    }

    /**
     * 本方法设置数据表字段 category.is_examine 的值
     * 1.正常2.需要审核
     * @param isExamine the value for category.is_examine
     */
    public void setIsExamine(String isExamine) {
        this.isExamine = isExamine == null ? null : isExamine.trim();
    }

    /**
     * 本方法返回数据表字段  category.cover_url 的值
     * 封面
     * @return the value of category.cover_url
     */
    public String getCoverUrl() {
        return coverUrl;
    }

    /**
     * 本方法设置数据表字段 category.cover_url 的值
     * 封面
     * @param coverUrl the value for category.cover_url
     */
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl == null ? null : coverUrl.trim();
    }
}