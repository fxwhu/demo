package com.bmss.test.shiro;

import com.google.common.collect.Sets;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by fengxuan1 on 2017/3/31.
 */
public class MyRealm extends AuthorizingRealm{
    /**
     *规则：“资源标识符：操作：对象实例ID”  即对哪个资源的哪个实例可以进行什么操作。
     * 其默认支持通配符权限字符串，“:”表示资源/操作/实例的分割；“,”表示操作的分割；“*”表示任意资源/操作/实例。
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(Sets.newHashSet("admin", "normal"));

//        new WildcardPermission("");

        authorizationInfo.setStringPermissions(Sets.newHashSet("view:create,delete"));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();


        Object credentials = token.getCredentials();

        System.out.println(token.getPrincipal() + "===" + token.getCredentials());

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                username, //用户名
                "123", //密码
                getName()  //realm name
        );
        return simpleAuthenticationInfo;
    }
}
