package com.wkb.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wkb.common.util.Constant;
import com.wkb.core.annotations.NoAuthorityLogin;
import com.wkb.core.logs.Operate;
import com.wkb.core.logs.WkbLogger;
import com.wkb.core.security.WkbCryption;
import com.wkb.core.util.RemoteDataAndPage;
import com.wkb.core.util.Tools;
import com.wkb.system.core.controller.SystemBaseController;
import com.wkb.user.bean.MonitorUser;
import com.wkb.user.service.MonitorUserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/monitorUser")
public class MonitorUserController extends SystemBaseController{
	@Resource(name="monitorUserService")
	private MonitorUserService monitorUserService;
	private final String viewpath="/monitor/user";
	private Logger logger = WkbLogger.getLogger(MonitorUserController.class);
	/**
	 * 查询用户详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/go_edit")
	public ModelAndView go_edit(){
		Map<String,Object> map = new HashMap<String,Object>();
		MonitorUser monitorUser = monitorUserService.findUserById(1);
		map.put("user", monitorUser);
		return new ModelAndView(viewpath+"/edit", map);
	}
	/**
	 * 测试方法
	 */
	@RequestMapping(value="/testMethod")
	public void test(){
		System.out.println("test method");
	}
	@RequestMapping(value="/toPage")
	public String toPage(){
		return "500";
	}
	/**
	 * 跳转登录页面
	 * @param session
	 * @param sessionStatus
	 * @return
	 */
	@NoAuthorityLogin
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(HttpSession session,SessionStatus sessionStatus){
		session.removeAttribute(Constant.SessionType.USER_LOGIN_INFO);
		session.removeAttribute(Constant.SessionType.USER_CLIENT_INFO);
		//session.removeAttribute(Constant.SessionType.USER_AUTHORITY_INFO);
		sessionStatus.setComplete();
		return new ModelAndView(viewpath+"/login");
	}
	
	/**
	 * 用户登陆
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@NoAuthorityLogin
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request,RedirectAttributes ra,HttpServletResponse response) throws IOException{
		String userId=request.getParameter("userId");
		String userPasswd=request.getParameter("userPasswd");
		logger.info("monitorUser | login方法 接受的参数:::userId:"+userId+":::userPasswd"+userPasswd);
		HttpSession session=request.getSession();
		//判断用户名、密码、验证码是否为空
		if(Tools.isEmpty(userId) || Tools.isEmpty(userPasswd) ){
			//ra.addAttribute(TIPINFO, "error_login");
			return "error_login";
		}
		MonitorUser monitorUser = monitorUserService.getUserByUserId(userId);
		if(monitorUser == null){
			return "error_user";
		}
		if(monitorUser.getUserStatus() != 1){
			return "invalid_user";
		}
		if(!WkbCryption.md5EncryptionWithSalt(userPasswd, monitorUser.getUserSalt()).equals(monitorUser.getUserPassword())){
			return "error_pwd";
		}
		//将登陆用户信息放入session
		String clientAddr=Tools.getRemoteIpAddr(request);
		Map<String,Object> userClientInfo=new HashMap<String,Object>();
		userClientInfo.put(Constant.ClientInfo.CLIENT_ADDR,clientAddr);
		session.setAttribute(Constant.SessionType.USER_LOGIN_INFO, monitorUser);
		session.setAttribute(Constant.SessionType.USER_CLIENT_INFO, userClientInfo);
		//logger.log(Operate.OPERATE,"用户"+monitorUser.getUserId()+"登陆成功！");
		logger.info("monitorUser | login方法 用户"+monitorUser.getUserId()+"登录成功！");
		return SUCCESS;
	}
	/**
	 * 进入用户注册页面
	 * @return
	 */
	@RequestMapping(value="/toRegist")
	public String toRegist(){
		return viewpath+"/regist";
	}
	/**
	 * 进入首页
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/index")
	public ModelAndView index(HttpSession session){
		Map<String,Object> map =new HashMap<String,Object>();
		MonitorUser monitorUser = (MonitorUser) session.getAttribute(Constant.SessionType.USER_LOGIN_INFO);
		map.put("monitorUser", monitorUser);
		return new ModelAndView(viewpath+"/index", map);
	}
	/**
	 * 注册用户
	 * @return
	 */
	@RequestMapping(value="/regist")
	@ResponseBody
	public String regist(MonitorUser monitorUser,String rePwd){
		Map<String,Object> map = new HashMap<String,Object>();
		if(!rePwd.equals(monitorUser.getUserPassword())){
			map.put("result", "fail");
			map.put("message", "两次密码不一致！");
			return JSONObject.fromObject(map).toString();
		}
		int count = monitorUserService.insertUser(monitorUser);
		if(count>0){
			map.put("result", "success");
		}
		return JSONObject.fromObject(map).toString();
	}
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(MonitorUser monitorUser){
		Map<String,Object> map = new HashMap<String,Object>();
		RemoteDataAndPage remoteDateAndPage = monitorUserService.listUser(monitorUser);
		List<MonitorUser> list = (List<MonitorUser>) remoteDateAndPage.getDataList();
		monitorUser.setPage(remoteDateAndPage.getPage());
		map.put("list", list);
		map.put("monitorUser", monitorUser);
		return new ModelAndView(viewpath+"/list", map);
	}
}
