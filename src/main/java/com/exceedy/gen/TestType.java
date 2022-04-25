package com.exceedy.gen;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

import javax.validation.constraints.NotNull;


/**
 * @author exccedy
 * @date 2021/7/5
 **/
public class TestType extends MySqlTypeConvert {

    @Override
    public IColumnType processTypeConvert(@javax.validation.constraints.NotNull GlobalConfig globalConfig, @NotNull String fieldType) {
        if ("json".equals(fieldType)) {
            return TestColumType.LIST;
        } else {
            return super.processTypeConvert(globalConfig, fieldType);
        }
    }
}
