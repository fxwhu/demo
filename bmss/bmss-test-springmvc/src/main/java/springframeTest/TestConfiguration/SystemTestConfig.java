package springframeTest.TestConfiguration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * Created by fengxuan1 on 2016/12/6.
 */
@Configuration
@Import({MapperScannerTestConfigurer.class,SqlSessionConfig.class})
public class SystemTestConfig {

    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return new DruidDataSource();
    }
}
