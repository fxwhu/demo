package someDemo.moliComment;

import someDemo.moliComment.model.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
@Component
public class CService {
    @Autowired
    private BasicDao<B> basicDao;
    public void test(){
        basicDao.method3();
    }
}
