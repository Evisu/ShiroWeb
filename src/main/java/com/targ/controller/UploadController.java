package com.targ.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * �ļ��ϴ�������
 *
 */
@Controller
@RequestMapping( value = "/upload" )
public class UploadController
{
	/**
	 * �ļ��ϴ�����
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
		response.getWriter().write( "-----------------�ϴ���������----------------" );
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}

}
