package com.bmss.test.dubbo.bcsx.testTime;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class ConvertTime {

    public static void main(String[] args) {
        long time1 = DateUtils.dateStingToLong("2016-10-01 00:00:00");
        long time2 = DateUtils.dateStingToLong("2016-10-31 23:59:59");
        long time3 = DateUtils.dateStingToLong("2016-11-01 00:00:00");
        long time4 = DateUtils.dateStingToLong("2016-11-15 23:59:59");

        System.out.println("time1: " + time1 + " ,time2: " + time2 + " ,time3: " +time3 + " ,time4: "+ time4 );


        System.out.println(4476375-664740);

        System.out.println(7297621-1320671);
    }
}
