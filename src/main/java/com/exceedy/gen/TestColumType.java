package com.exceedy.gen;

import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

import java.util.Map;

/**
 * @author exccedy
 * @date 2021/7/5
 **/
public enum TestColumType implements IColumnType {
    JSON("json",""),
    MAP("Map<String, String>","java.util.Map"),
    LIST("List<String>","java.util.List"),
    ;

    /**
     * 类型
     */
    private final String type;


    /**
     * 包路径
     */
    private final String pkg;

    TestColumType(final String type, final String pkg) {
        this.type = type;
        this.pkg = pkg;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getPkg() {
        return pkg;
    }

}
