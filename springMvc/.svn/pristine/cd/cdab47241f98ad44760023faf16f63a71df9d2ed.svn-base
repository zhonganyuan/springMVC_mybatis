package com.wkb.tomcat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wkb.core.util.RemoteDataAndPage;
import com.wkb.system.core.controller.SystemBaseController;
import com.wkb.tomcat.bean.MonitorTomcat;
import com.wkb.tomcat.service.MonitorTomcatService;

@Controller
@RequestMapping("/monitorTomcat")
public class MonitorTomcatController extends SystemBaseController{
	@Resource(name="monitorTomcatService")
	private MonitorTomcatService monitorTomcatService;
	
	private final String viewpath="/monitor/tomcat";
	/**
	 * 分页查询tomcat
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(MonitorTomcat monitorTomcat){
		Map<String,Object> map = new HashMap<String,Object>();
		RemoteDataAndPage remoteDataAndpage = monitorTomcatService.listTomcat(monitorTomcat);
		List<MonitorTomcat> list = (List<MonitorTomcat>) remoteDataAndpage.getDataList();
		monitorTomcat.setPage(remoteDataAndpage.getPage());
		map.put("list", list);
		map.put("monitorTomcat", monitorTomcat);
		return new ModelAndView(viewpath+"/list", map);
	}
	@RequestMapping(value="/toPage")
	public String toPage(){
		return viewpath+"/edit";
	}
	/**
	 * 生成tomcat信息
	 * @return
	 */
	@RequestMapping(value="/insertTomcat")
	@ResponseBody
	public String inertTomcat(MonitorTomcat monitorTomcat){
		int count = monitorTomcatService.inertTomcat(monitorTomcat);
		if(count>0){
			return SUCCESS;
		}else{
			return FAIL;
		}
	}
}
