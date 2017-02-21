package com.wkb.emoticon.service;

import com.wkb.core.util.RemoteDataAndPage;
import com.wkb.emoticon.bean.Category;
import com.wkb.redis.bean.MonitorRedis;

public interface CategoryService {
	 /**
     * 本方法的操作由数据库表  category 生成
     * 根据主键删除表 category 中的信息
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  category 生成
     * 向表 category 中插入一条数据
     */
    int insert(Category record);

    /**
     * 本方法的操作由数据库表  category 生成
     * 向表 category 中有选择的插入一条数据
     */
    int insertSelective(Category record);

    /**
     * 本方法的操作由数据库表  category 生成
     * 根据主键获取表 category 中信息
     */
    Category selectByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  category 生成
     * 根据主键有选择性的更新表 category 数据
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * 本方法的操作由数据库表  category 生成
     * 更新表 category 中数据
     */
    int updateByPrimaryKey(Category record);
}
