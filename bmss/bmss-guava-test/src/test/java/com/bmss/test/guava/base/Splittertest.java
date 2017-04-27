package com.bmss.test.guava.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/24.
 */
public class Splittertest {

    //omitEmptyStrings()	从结果中自动忽略空字符串
    //trimResults()	移除结果字符串的前导空白和尾部空白
    //trimResults(CharMatcher)	给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
    //Splitter.onPattern(String)	按正则表达式拆分
    //limit(int)	限制拆分出的字符串数量
    @Test
    public void test(){
//        List<String> strings = Splitter.on(",").trimResults().omitEmptyStrings().splitToList("1,  ,,2,3,4,");
        List<String> strings = Splitter.fixedLength(2).on(",").trimResults().omitEmptyStrings().splitToList("1667,  ,,2,3,4,");
        System.out.println(strings);
    }


    @Test
    public void testCharMatcher(){
        String string = "absan12123java";
        String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(string); //移除control字符
        String theDigits = CharMatcher.DIGIT.retainFrom(string); //只保留数字字符
        String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' '); //去除两端的空格，并把中间的连续空格替换成单个空格
        String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*"); //用*号替换所有数字
        String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string); // 只保留数字和小写字母

    }
}
