package com.bmss.db;

import com.bmss.db.pojo.Sex;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fengxuan1 on 2017/5/4.
 */
public class SexEnumTypeHandler extends BaseTypeHandler<Sex>{

    private Class<Sex> type = Sex.class;

    private final Sex[] sices = type.getEnumConstants();;

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public Sex getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Sex.getSexByValue(columnName);
    }

    @Override
    public Sex getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        if(rs.wasNull()){
            return null;
        }
        return Sex.getSexByKey(i);
    }

    @Override
    public Sex getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        if(cs.wasNull()){
            return null;
        }
        return Sex.getSexByKey(i);
    }
}
