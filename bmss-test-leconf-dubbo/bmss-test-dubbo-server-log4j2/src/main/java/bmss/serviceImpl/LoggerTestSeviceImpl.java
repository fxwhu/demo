package bmss.serviceImpl;

import com.bmss.test.api.LoggerTestApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/12/27.
 */
@Component("loggerTest")
public class LoggerTestSeviceImpl implements LoggerTestApi{
    private static Logger logger = LoggerFactory.getLogger(LoggerTestSeviceImpl.class);

    @Override
    public void test() {
        logger.info("log4j sout info message");
        logger.debug("log4j sout debug message");
    }
}
