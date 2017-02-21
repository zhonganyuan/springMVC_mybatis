package com.wkb.emoticon.service;

import com.wkb.emoticon.bean.Feedback;

public interface FeedbackService {
	 /**
     * 本方法的操作由数据库表  feedback 生成
     * 根据主键删除表 feedback 中的信息
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  feedback 生成
     * 向表 feedback 中插入一条数据
     */
    int insert(Feedback record);

    /**
     * 本方法的操作由数据库表  feedback 生成
     * 向表 feedback 中有选择的插入一条数据
     */
    int insertSelective(Feedback record);

    /**
     * 本方法的操作由数据库表  feedback 生成
     * 根据主键获取表 feedback 中信息
     */
    Feedback selectByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  feedback 生成
     * 根据主键有选择性的更新表 feedback 数据
     */
    int updateByPrimaryKeySelective(Feedback record);

    /**
     * 本方法的操作由数据库表  feedback 生成
     * 更新表 feedback 中数据
     */
    int updateByPrimaryKey(Feedback record);
}
