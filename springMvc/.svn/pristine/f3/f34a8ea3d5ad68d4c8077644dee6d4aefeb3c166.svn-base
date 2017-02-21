package com.wkb.tomcat.dao;

import com.wkb.core.dao.interfaces.BaseMapper;
import com.wkb.tomcat.bean.MonitorTomcat;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 由数据库表 monitor_tomcat 生成
 * 
 */
@Repository(value="monitorTomcatMapper")
public interface MonitorTomcatMapper extends BaseMapper {
    /**
     * 本方法的操作由数据库表  monitor_tomcat 生成
     * 根据主键删除表 monitor_tomcat 中的信息
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  monitor_tomcat 生成
     * 向表 monitor_tomcat 中插入一条数据
     */
    int insert(MonitorTomcat record);

    /**
     * 本方法的操作由数据库表  monitor_tomcat 生成
     * 向表 monitor_tomcat 中有选择的插入一条数据
     */
    int insertSelective(MonitorTomcat record);

    /**
     * 本方法的操作由数据库表  monitor_tomcat 生成
     * 根据主键获取表 monitor_tomcat 中信息
     */
    MonitorTomcat selectByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  monitor_tomcat 生成
     * 根据主键有选择性的更新表 monitor_tomcat 数据
     */
    int updateByPrimaryKeySelective(MonitorTomcat record);

    /**
     * 本方法的操作由数据库表  monitor_tomcat 生成
     * 更新表 monitor_tomcat 中数据
     */
    int updateByPrimaryKey(MonitorTomcat record);
    /**
     * 分页查询tomcat
     * @param monitorTomcat
     * @return
     */
	List<MonitorTomcat> listPAGETomcat(MonitorTomcat monitorTomcat);
}