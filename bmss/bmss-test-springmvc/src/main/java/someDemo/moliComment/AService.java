package someDemo.moliComment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
@Component("aservice")
public class AService {
    @Autowired
    private ADao aDao;

    public void test(){
        aDao.getBasic().method1();
    }

    public static void main(String[] args) {
        AService aService = new AService();
        aService.test();
    }
}
