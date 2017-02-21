package com.wkb.redis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wkb.core.util.RemoteDataAndPage;
import com.wkb.redis.bean.MonitorRedis;
import com.wkb.redis.service.MonitorRedisService;
import com.wkb.system.core.controller.SystemBaseController;

@Controller
@RequestMapping(value="/monitorRedis")
public class MonitorRedisController extends SystemBaseController{
	@Resource(name="monitorRedisService")
	private MonitorRedisService monitorRedisService;
	private final String viewpath="/monitor/redis";
	/**
	 * redis 列表
	 * @param monitorRedis
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(MonitorRedis monitorRedis){
		Map<String,Object> map = new HashMap<String,Object>();
		RemoteDataAndPage remoteDateAndPage = monitorRedisService.listRedis(monitorRedis);
		List<MonitorRedis> list = (List<MonitorRedis>) remoteDateAndPage.getDataList();
		monitorRedis.setPage(remoteDateAndPage.getPage());
		map.put("list", list);
		map.put("redis", monitorRedis);
		return new ModelAndView(viewpath+"/list", map);
	}
}
