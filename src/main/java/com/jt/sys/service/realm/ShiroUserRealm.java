package com.jt.sys.service.realm;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 此对象要完成用会认证信息，授权信息的获取和封装
 */
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysUser;

@Service
public class ShiroUserRealm extends AuthorizingRealm{

	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Autowired
	private SysMenuDao sysMenuDao;
	
	/**
	 * 设置加密算法和加密次数(默认加密一次)
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		//
		HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher("MD5");
			//设置加密次数
			//hashMatcher.setHashIterations(2);
		super.setCredentialsMatcher(hashMatcher);
	}
	
	/**
	 * 负责用户认证信息的  获取和封装 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		//1. 获取用户身份信息(客户端获取的信息:账号/密码)
		String username = (String) token.getPrincipal();
		
		//2. 基于用户名访问数据库获取用户信息(SysUser对象)
		SysUser user = sysUserDao.findUserByUserName(username);
		
		//3. 对用户信息进行验证
		//3.1 非空验证
		if(user == null){
			throw new AuthenticationException("此用户名不存在");
		}
		//3.1禁用与否验证
		if(user.getValid() == 0){
			throw new AuthenticationException("此用户名被禁用");
		}
		//4 基于业务封装用户数据(密码，盐值)
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				user,				//用户信息
				user.getPassword(),	//用户已经加密的密码
				credentialsSalt,	//盐值
				this.getName());	//当前类的名字
		
		return info;	//将封装数据返回给认证管理器(Authentication)
	}

	/**
	 * 负责用户授权信息的获取和封装
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		System.out.println("执行shiro的授权方法:ShiroUserRealm.doGetAuthorizationInfo()");
		
		//1. 获取用户id(基于此id逐步获取用户具备的权限)
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		Integer userId = user.getId();
		//2. 基于用户id获取角色信息(user_id,role_id)
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(userId);
		
		//3. 基于角色id获取菜单id(role_id,menu_id)
		List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds.toArray(new Integer[]{}));
		
		//4. 基于菜单id获取权限标识(sys:user:valid)
		List<String> permissions = sysMenuDao.findPermissionsByMenu(menuIds.toArray(new Integer[]{}));
		
		for (String string : permissions) {
			System.out.println(string);
		}
		
		//5. 封装权限信息
		Set<String> pSet = new HashSet<String>();
		
		System.out.println("权限:"+pSet);
		
		for(String permission:permissions){
			if(!StringUtils.isEmpty(permission)){
				pSet.add(permission);
			}
		}//去重和空(null),空串
		
		System.out.println("pSet="+pSet);
		SimpleAuthorizationInfo info= new SimpleAuthorizationInfo();
		info.setStringPermissions(pSet);

		return info;
	}
}



















