package com.exceedy.gen;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author exccedy
 * @date 2021/7/6
 **/
public class JSONTypeHandler extends BaseTypeHandler<Map<String, String>> {

    /**
     * 入库时Map转为JSONString
     * @param preparedStatement sql
     * @param i 下标
     * @param stringStringMap 数据
     * @param jdbcType 类型
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Map<String, String> stringStringMap, JdbcType jdbcType) throws SQLException {
            preparedStatement.setString(i, JSONObject.toJSONString(stringStringMap));
    }

    @Override
    public Map<String, String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return JSONObject.parseObject(resultSet.getString(s), new TypeReference<Map<String,String>>(){});
    }

    @Override
    public Map<String, String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return JSONObject.parseObject(resultSet.getString(i), new TypeReference<Map<String,String>>(){});
    }

    @Override
    public Map<String, String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return JSONObject.parseObject(callableStatement.getString(i), new TypeReference<Map<String,String>>(){});
    }
}
