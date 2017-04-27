package com.bmss.test.dubbo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = "mmm";
        list.add(s);

        Map<String, String> map = new HashMap<>();
        String m = "";
        m = "mmm";
        map.put(m, "111");

        Set<String> keySet = map.keySet();

        for(String key: keySet){
            System.out.println("====" + list.contains(key));
        }
    }
}
