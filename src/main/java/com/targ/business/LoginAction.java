package com.targ.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@WebServlet( name = "loginServlet" , urlPatterns = "/loginServlet" )
public class LoginAction extends HttpServlet
{

	public void doGet( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException
	{
		super.doGet( request, response );
		request.getRequestDispatcher( "/jsp/login.jsp" ).forward( request, response );
	}

	public void doPost( HttpServletRequest request , HttpServletResponse response ) throws ServletException,
			IOException
	{
		super.doPost( request, response );
	}

	public void service( HttpServletRequest request , HttpServletResponse response ) throws ServletException,
			IOException
	{
		String error = null;
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		String rememberMe = request.getParameter( "rememberMe" );
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken( username , password );
		token.setRememberMe( Boolean.valueOf( rememberMe ) );

		try
		{
			subject.login( token );
		} catch ( UnknownAccountException e )
		{
			error = "�û���/�������";
		} catch ( IncorrectCredentialsException e )
		{
			error = "�û���/�������";
		} catch ( AuthenticationException e )
		{
			// �������󣬱�������������뵥�������뵥��catch����
			error = "��������" + e.getMessage();
		}

		if ( error != null )
		{// �����ˣ����ص�¼ҳ��
			request.setAttribute( "error", error );
			request.getRequestDispatcher( "/jsp/login.jsp" ).forward( request, response );
		} else
		{// ��¼�ɹ�
			request.setAttribute( "subject", subject );
			System.out.println("-------------------------------"+subject.getPrincipal());
			request.getRequestDispatcher( "/jsp/success.jsp" ).forward( request, response );
		}

	}

}
