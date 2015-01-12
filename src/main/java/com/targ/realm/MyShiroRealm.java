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

	// 用于获取用户信息及用户权限信息的业务接口
	private BusinessManager	businessManager;

	public BusinessManager getBusinessManager()
	{
		return businessManager;
	}

	public void setBusinessManager( BusinessManager businessManager )
	{
		this.businessManager = businessManager;
	}

	// 获取授权信息
	protected AuthorizationInfo doGetAuthorizationInfo( PrincipalCollection principals )
	{
		String username = ( String ) principals.fromRealm( getName() ).iterator().next();

		if ( username != null )
		{
			// 查询用户授权信息
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

	// 获取认证信息
	protected AuthenticationInfo doGetAuthenticationInfo( AuthenticationToken authcToken )
			throws AuthenticationException
	{
		UsernamePasswordToken token = ( UsernamePasswordToken ) authcToken;
		// 通过表单接收的用户名
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
