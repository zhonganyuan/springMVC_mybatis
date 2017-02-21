package com.wkb.emoticon.bean;


import java.io.Serializable;
import java.util.Date;

/**
 * 由数据库表 feedback 生成
 * 
 */
public class Feedback implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 由表字段 feedback.id 生成
     * 
     */
    private Integer id;

    /**
     * 由表字段 feedback.content 生成
     * 文本
     */
    private String content;

    /**
     * 由表字段 feedback.wechat_num 生成
     * 微信公众号
     */
    private String wechatNum;

    /**
     * 由表字段 feedback.create_time 生成
     * 创建时间
     */
    private Date createTime;

    /**
     * 本方法返回数据表字段  feedback.id 的值
     * 
     * @return the value of feedback.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 本方法设置数据表字段 feedback.id 的值
     * 
     * @param id the value for feedback.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 本方法返回数据表字段  feedback.content 的值
     * 文本
     * @return the value of feedback.content
     */
    public String getContent() {
        return content;
    }

    /**
     * 本方法设置数据表字段 feedback.content 的值
     * 文本
     * @param content the value for feedback.content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 本方法返回数据表字段  feedback.wechat_num 的值
     * 微信公众号
     * @return the value of feedback.wechat_num
     */
    public String getWechatNum() {
        return wechatNum;
    }

    /**
     * 本方法设置数据表字段 feedback.wechat_num 的值
     * 微信公众号
     * @param wechatNum the value for feedback.wechat_num
     */
    public void setWechatNum(String wechatNum) {
        this.wechatNum = wechatNum == null ? null : wechatNum.trim();
    }

    /**
     * 本方法返回数据表字段  feedback.create_time 的值
     * 创建时间
     * @return the value of feedback.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 本方法设置数据表字段 feedback.create_time 的值
     * 创建时间
     * @param createTime the value for feedback.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}