package com.wkb.core.util;

import java.io.Serializable;

import com.wkb.common.util.Constant;

/**
 * 分页实体类
 * @author huanglt
 *
 */
public class Page implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int showCount = Constant.Initliaze.PAGE_SHOWCOUNT; //每页显示记录数
	private int totalPage;		//总页数
	private int totalResult;	//总记录数
	private int currentPage=1;	//当前页
	private int currentResult;	//当前记录起始索引
	private boolean entityOrField;	//true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	//private String pageStr;		//最终页面显示的底部翻页导航，详细见：getPageStr();
	private String id;          //如果想以ajax方式去分页的id
	private String form;        //以哪个form的action进行分页
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public int getTotalPage() {
		if(totalResult>0 && totalResult%showCount==0)
			totalPage = totalResult/showCount;
		else
			totalPage = totalResult/showCount+1;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	public int getCurrentPage() {
		if(currentPage<=0){
			currentPage = 1;
		}/*else if(getTotalPage()>0  && currentPage>getTotalPage()){
			currentPage = getTotalPage();
		}*/
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/*
	 * 已改成自定义标签样式
	public String getPageStr() {
		StringBuilder sb =new StringBuilder();
		sb.append("<div id=\"page\" class=\"page\">");
		sb.append("<div id=\"page\" class=\"page_and_btn\">");
		if(totalResult>0){
			sb.append("	<ul>\n");
			sb.append("<li >总数："+ totalResult +"</li>\n");
			if(currentPage==1){
				sb.append("	<li class=\"pageinfo\">首页</li>\n");
				sb.append("	<li class=\"pageinfo\">上页</li>\n");
			}else{	
				sb.append("	<li><a href=\"#@\" onclick=\"nextPage(1)\">首页</a></li>\n");
				sb.append("	<li><a href=\"#@\" onclick=\"nextPage("+(currentPage-1)+")\">上页</a></li>\n");
			}
			int showTag =5;	//分页标签显示数量
			int startTag = 1;
			int endTag ;			
			if(currentPage<=3){
				startTag=1;
				endTag=showTag;
			}else{
				startTag=currentPage-2;
				endTag=startTag+showTag-1;
			}			
			for(int i=startTag; i<=totalPage && i<=endTag; i++){
				if(currentPage==i)
					sb.append("<li class=\"current\">"+i+"</li>\n");
				else
					sb.append("	<li><a href=\"#@\" onclick=\"nextPage("+i+")\">"+i+"</a></li>\n");
			}
			if(currentPage==totalPage){
				sb.append("	<li class=\"pageinfo\">下页</li>\n");
				sb.append("	<li class=\"pageinfo\">尾页</li>\n");
			}else{
				sb.append("	<li><a href=\"#@\" onclick=\"nextPage("+(currentPage+1)+")\">下页</a></li>\n");
				sb.append("	<li><a href=\"#@\" onclick=\"nextPage("+totalPage+")\">尾页</a></li>\n");
			}
		   // sb.append("	<li class=\"pageinfo\">第"+currentPage+"页</li>\n");
			
			sb.append("	<li class=\"pageinfo\">共"+totalPage+"页</li>\n");
			sb.append(" <li ><a href=\"#@\" onclick=\"hunterPageContrlNextJump()\" style=\"width:40px;\">跳转到</a> </li>\n");
			sb.append(" <li ><input type='text' id='num' size='1'style=\"border:1px solid \" /> </li>\n");
			sb.append(" <input type='hidden' id='all' value='"+totalPage+"'/> \n");
			sb.append("</ul>\n");
			sb.append("</div>");
			sb.append("</div>");
			sb.append("<script type=\"text/javascript\">\n");
			sb.append("$.ajaxSetup({cache:false});\n");
			sb.append("function nextPage(page){\n");
			if(form!=null && !"".equals(form.trim())){
				sb.append("		var forms=$(\"#"+form+"\");\n");
				sb.append("	 if(forms != null && forms != ''){\n");
				sb.append("		var url=forms.attr('action');\n");
				sb.append("	 }\n");
			}else{
				sb.append(" 	var forms=document.forms[0];\n");
				sb.append("	 if(forms != null && forms != ''){\n");
				sb.append("		var url=forms.action;\n");
				sb.append("	 }\n");
			}
			sb.append("	if(true && forms){\n");
			sb.append("		if(url.indexOf('?')>-1){url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			if(id!=null && !"".equals(id.trim())){
				//sb.append(" 	url+=page;\n");
				sb.append(" 	var data=url.substring(url.indexOf('?')+1)+page+'&'+$('#"+form+"').serialize();\n");
				sb.append(" 	$(\"#"+id+"\").load(url.substring(0,url.indexOf('?')),data,function(){});\n");
			}else{
				sb.append("		forms.action = url+page;\n");
				sb.append("		forms.submit();\n");
			}
			sb.append("	}else{\n");
			sb.append("		url = document.location+'';\n");
			sb.append("		if(url.indexOf('?')>-1){\n");
			sb.append(" 		if(url.indexOf('#@')>0){\n");
			sb.append(" 	 		url=url.replace('#@','');\n");
			sb.append(" 		}\n");
			sb.append("			if(url.indexOf('currentPage')>-1){\n");*/
			//sb.append("				var reg = /currentPage=\\d*/g;\n");
	/*
			sb.append("				url = url.replace(reg,'currentPage=');\n");
			sb.append("			}else{\n");
			sb.append("				url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";\n");
			sb.append("			}\n");
			sb.append("		}else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			//System.out.println("id的值为："+id);
			if(id!=null && !"".equals(id.trim())){
				sb.append(" 	url+=page;\n");
				sb.append(" 	$(\"#"+id+"\").load(url);\n");
			}else{
				sb.append("		url+=page;\n");
				sb.append("		alert(url);\n");
				sb.append("		document.location = url;\n");
			}
			sb.append("	}\n");
			sb.append("}\n");

			//跳转到
			sb.append(" function hunterPageContrlNextJump(){\n");
			sb.append("var jumpPageNumber=document.getElementById('num').value;\n");
			sb.append("if(jumpPageNumber==''){\n");
		    sb.append("alert('未输入页码！');\n");
		    sb.append("nextPage(1);\n ");
			sb.append("return;\n");
			sb.append("}\n");			
			sb.append("var lastPageNumber=Number(document.getElementById('all').value);\n");
			sb.append("if((!Number(jumpPageNumber))){\n");
			sb.append("alert('输入错误,只能输入数值！');\n");
			sb.append("nextPage(1);\n ");
			sb.append("return;\n");
			sb.append("}\n");
			sb.append("if(Number(jumpPageNumber)<1){\n");
			sb.append("alert('输入错误,只能输入正数！');\n");
			 sb.append("nextPage(1);\n ");
			sb.append("return;\n");
			sb.append("}\n");
			sb.append("if(Number(jumpPageNumber)<=Number(lastPageNumber)){\n");
			sb.append("nextPage(Number(jumpPageNumber));\n");
			sb.append("}else{alert('超过最大页数！');\n");
			sb.append("nextPage(1);\n ");
			sb.append("}\n");
			sb.append("}\n");
			sb.append("</script>\n");
		}
		pageStr = sb.toString();
		return pageStr;
	}
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}
	*/
	public int getShowCount() {
		return showCount;
	}
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	public int getCurrentResult() {
		currentResult = (getCurrentPage()-1)*getShowCount();
		if(currentResult<0)
			currentResult = 0;
		return currentResult;
	}
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
	public boolean isEntityOrField() {
		return entityOrField;
	}
	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}

}
