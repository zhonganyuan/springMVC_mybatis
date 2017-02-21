package com.wkb.emoticon.service;

import com.wkb.core.util.RemoteDataAndPage;
import com.wkb.emoticon.bean.Emoticon;
import com.wkb.redis.bean.MonitorRedis;

public interface EmoticonService {
	 /**
     * 本方法的操作由数据库表  emoticon 生成
     * 根据主键删除表 emoticon 中的信息
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  emoticon 生成
     * 向表 emoticon 中插入一条数据
     */
    int insert(Emoticon record);

    /**
     * 本方法的操作由数据库表  emoticon 生成
     * 向表 emoticon 中有选择的插入一条数据
     */
    int insertSelective(Emoticon record);

    /**
     * 本方法的操作由数据库表  emoticon 生成
     * 根据主键获取表 emoticon 中信息
     */
    Emoticon selectByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  emoticon 生成
     * 根据主键有选择性的更新表 emoticon 数据
     */
    int updateByPrimaryKeySelective(Emoticon record);

    /**
     * 本方法的操作由数据库表  emoticon 生成
     * 更新表 emoticon 中数据
     */
    int updateByPrimaryKey(Emoticon record);
}
