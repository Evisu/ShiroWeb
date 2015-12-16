package com.targ.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件上传控制器
 *
 */
@Controller
@RequestMapping( value = "/upload" )
public class UploadController
{
	/**
	 * 文件上传方法
	 * 
	 * @param request
	 * @param response
	 * @param uploadData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value = "/upload" )
	public String upload( HttpServletRequest request , HttpServletResponse response , String uploadData ) throws Exception
	{
		response.setContentType( "application/json" );
		response.getWriter().write( "-----------------上传方法调用----------------" );
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}

}
