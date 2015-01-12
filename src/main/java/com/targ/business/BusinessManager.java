package com.targ.business;

import java.util.List;
import java.util.Map;

/**
 * 从数据库获取用户信息及用户权限信息的业务类
 * 
 */
public class BusinessManager {
	
	private List<LoginAccount> loginAccountList;
	

	public List<LoginAccount> getLoginAccountList()
	{
		return loginAccountList;
	}

	public void setLoginAccountList( List<LoginAccount> loginAccountList )
	{
		this.loginAccountList = loginAccountList;
	}

	public List<String> queryPermissions(String username)
	{
		// 查询权限
		
		
		return null;
	}
	
	public LoginAccount get(String userName)
	{
		LoginAccount loginAccount = null;
		if( loginAccountList != null ){
			for(LoginAccount la : loginAccountList)
			{
				if(la.getUsername().equals( userName ))
				{
					loginAccount = la;
					break;
				}
				
			}
		}
		return loginAccount;
	}

}
