package com.bmss.test.dubbo.bcsx.testExtend.moliComment.impl;

import com.bmss.test.dubbo.bcsx.testExtend.moliComment.ADao;
import com.bmss.test.dubbo.bcsx.testExtend.moliComment.BasicDao;
import com.bmss.test.dubbo.bcsx.testExtend.moliComment.model.A;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class ADaoImpl implements ADao {
    private BasicDao<A> basicDao = new BasicDaoImpl<A>();
    @Override
    public BasicDao<A> getBasic() {
        return basicDao;
    }
}
