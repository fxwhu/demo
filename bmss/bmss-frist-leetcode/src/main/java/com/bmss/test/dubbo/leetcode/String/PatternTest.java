package com.bmss.test.dubbo.leetcode.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fengxuan1 on 2016/10/20.
 *
 * 正则匹配 *，？ ，+ ，^, $,{min,max},  ? 0或1个
 * [^abc]	任何字符，除了 a、b 或 c（否定）
 */
public class PatternTest {

    public static void main(String[] args) {
        testMatch();
    }

    public static void testMatch(){
        String s = "Abs ksas das.";
        String m = "mmmmmmmmm";
        String reg = "^[A-Z].*\\.$";
        String reg1 = "\\w*";
        String webreg = "(\\w+):\\/\\/([^/:]+)(:\\d*)?([^# ]*)";
        String webreg1 = "(\\w+)";
        boolean matches = s.matches(reg);
        boolean matches1 = m.matches(reg1);
        System.out.println(matches + "=====" + matches1);


        Pattern  pattern = Pattern.compile(webreg);
        Matcher matcher = pattern.matcher("http://www.baidu.com");
        if(matcher.find()){
            System.out.println(matcher.start() + "=====" + matcher.end());
        }


        Pattern  pattern1 = Pattern.compile(webreg1);
        Matcher matcher1 = pattern1.matcher("http://www.baidu.com");
        boolean b = matcher1.lookingAt();
        System.out.println(b);
    }
}
