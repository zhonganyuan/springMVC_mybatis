package com.wkb.emoticon.dao;


import com.wkb.common.util.Constant.User;
import com.wkb.core.dao.interfaces.BaseMapper;

import org.springframework.stereotype.Repository;

/**
 * 由数据库表 user 生成
 * 
 */
@Repository(value="userMapper")
public interface UserMapper extends BaseMapper {
    /**
     * 本方法的操作由数据库表  user 生成
     * 根据主键删除表 user 中的信息
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  user 生成
     * 向表 user 中插入一条数据
     */
    int insert(User record);

    /**
     * 本方法的操作由数据库表  user 生成
     * 向表 user 中有选择的插入一条数据
     */
    int insertSelective(User record);

    /**
     * 本方法的操作由数据库表  user 生成
     * 根据主键获取表 user 中信息
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  user 生成
     * 根据主键有选择性的更新表 user 数据
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 本方法的操作由数据库表  user 生成
     * 更新表 user 中数据
     */
    int updateByPrimaryKey(User record);
}