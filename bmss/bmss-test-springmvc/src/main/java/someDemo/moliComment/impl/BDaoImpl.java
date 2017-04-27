package someDemo.moliComment.impl;

import someDemo.moliComment.BDao;
import someDemo.moliComment.BasicDao;
import someDemo.moliComment.model.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
@Component
public class BDaoImpl implements BDao{
    @Autowired
    private BasicDao<B> basicDao;
    @Override
    public BasicDao<B> getBasicDao() {
        return basicDao;
    }
}
