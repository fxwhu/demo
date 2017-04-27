package com.bmss.xa.mapper1;

import com.bmss.xa.Account;
//import org.springframework.data.repository.query.Param;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fengxuan1 on 2017/4/14.
 */
public interface Db1TraceMapper {

    int decreaseMoney(@Param("userId") String userId, @Param("money") long money);

    int increaseMoney(@Param("userId")String userId, @Param("money") long money);

    Account getAcountById(String userId);

    int insert(Account account);
}
