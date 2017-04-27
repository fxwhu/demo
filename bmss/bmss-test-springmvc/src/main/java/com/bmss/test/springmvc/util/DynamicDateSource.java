package com.bmss.test.springmvc.util;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by fengxuan1 on 2016/12/30.
 */
public class DynamicDateSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
//        return DataSourceAspect.getDataSource();
        return DynamicDataSourceHolder.getDataSouce();

    }


}

class DynamicDataSourceHolder{
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String name) {
        holder.set(name);
    }

    public static void remove(){
        holder.remove();
    }

    public static String getDataSouce() {
        return holder.get();
    }
}



