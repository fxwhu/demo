package someDemo.moliComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
@Component
public class BService {
    @Autowired
    private BDao bdao;
    public void test(){
        bdao.getBasicDao().method2();
    }
}
