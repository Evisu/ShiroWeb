package com.targ.realm;

import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.targ.business.BusinessManager;
import com.targ.business.LoginAccount;

public class MyShiroRealm extends AuthorizingRealm
{

	// ���ڻ�ȡ�û���Ϣ���û�Ȩ����Ϣ��ҵ��ӿ�
	private BusinessManager	businessManager;

	public BusinessManager getBusinessManager()
	{
		return businessManager;
	}

	public void setBusinessManager( BusinessManager businessManager )
	{
		this.businessManager = businessManager;
	}

	// ��ȡ��Ȩ��Ϣ
	protected AuthorizationInfo doGetAuthorizationInfo( PrincipalCollection principals )
	{
		String username = ( String ) principals.fromRealm( getName() ).iterator().next();

		if ( username != null )
		{
			// ��ѯ�û���Ȩ��Ϣ
			Collection<String> pers = businessManager.queryPermissions( username );
			if ( pers != null && !pers.isEmpty() )
			{
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				for ( String each : pers )
					info.addStringPermission( each );

				return info;
			}
		}

		return null;
	}

	// ��ȡ��֤��Ϣ
	protected AuthenticationInfo doGetAuthenticationInfo( AuthenticationToken authcToken )
			throws AuthenticationException
	{
		UsernamePasswordToken token = ( UsernamePasswordToken ) authcToken;
		// ͨ�������յ��û���
		String username = token.getUsername();

		if ( username != null && !"".equals( username ) )
		{
			LoginAccount account = businessManager.get( username );

			if ( account != null )
			{
				return new SimpleAuthenticationInfo( account.getUsername() , account.getPassword() , getName() );
			}
		}

		return null;
	}

}
