package com.wkb.system.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wkb.common.util.Constant;
import com.wkb.core.util.Tools;

/**
 * 系统基础类
 * @author huanglt
 *
 */
@SessionAttributes(Constant.SessionType.USER_LOGIN_INFO)
public class SystemBaseController {

	protected static final String SUCCESS="success";  //成功
	
	protected static final String FAIL="fail";  //失败
	
	protected static final String INVALID="invalid";  //非法
	
	protected static final String ERROR="error";  //错误
	
	protected static final String TIPINFO="tipInfo";
	
	protected static final String EDIT_SUCCESS = "操作成功";
	protected static final String EDIT_FAIL = "操作失败";
	
	@ModelAttribute
	public Model commonInfos(Model model,HttpServletRequest request){
		String ctxPath=request.getContextPath();
		//公共提示信息
		String tipInfo=request.getParameter("tipInfo");
		if(Tools.notEmpty(tipInfo)){
			model.addAttribute("tipInfo", tipInfo);
		}
		//项目路径信息
		model.addAttribute("ctxPath", ctxPath);
		return model;
	}
}
