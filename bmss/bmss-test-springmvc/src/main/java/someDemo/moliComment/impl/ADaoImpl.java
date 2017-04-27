package someDemo.moliComment.impl;


import someDemo.moliComment.ADao;
import someDemo.moliComment.BasicDao;
import someDemo.moliComment.model.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
@Component
public class ADaoImpl implements ADao {
    @Autowired
    private BasicDao<A> basicDao;
    @Override
    public BasicDao<A> getBasic() {
        return basicDao;
    }
}
