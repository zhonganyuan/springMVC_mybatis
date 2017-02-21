package com.wkb.emoticon.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wkb.redis.bean.MonitorRedis;
import com.wkb.system.core.controller.SystemBaseController;

@Controller
@RequestMapping(value="/emoticon")
public class MonitorRedisController extends SystemBaseController{
	
	public static String viewpath = "emoticon";
	
	/**
	 * @param monitorRedis
	 * @return
	 */
	@RequestMapping(value="/main")
	public ModelAndView main(MonitorRedis monitorRedis){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("redis", monitorRedis);
		return new ModelAndView(viewpath+"/main", map);
	}
}
