package com.bmss.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by fengxuan1 on 2017/3/31.
 */
public class AuthenticatorTest {

    @Test
    public void testJdbcReaml(){
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro/shiro-jdbc-realm.ini");

        SecurityManager instance = iniSecurityManagerFactory.getInstance();

        SecurityUtils.setSecurityManager(instance);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
//            e.printStackTrace();
            System.out.println("at least one realm fail!");
        }

        boolean authenticated = subject.isAuthenticated();


        if(authenticated){
            Session session = subject.getSession();


            boolean permitted = subject.isPermitted("view:create,delete");
            System.out.println("permitted: " + permitted);
        }

        System.out.println("===" + authenticated);

        subject.logout();

    }


    @Test
    public void encode(){
        String str = "hello";
        String base64Encoded = Hex.encodeToString(str.getBytes());
        String str2 = new String(Hex.decode(base64Encoded.getBytes()));
        System.out.println(str.equals(str2));
    }

}