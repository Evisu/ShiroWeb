package com.targ.business;

import java.util.List;
import java.util.Map;

/**
 * �����ݿ��ȡ�û���Ϣ���û�Ȩ����Ϣ��ҵ����
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
		// ��ѯȨ��
		
		
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
