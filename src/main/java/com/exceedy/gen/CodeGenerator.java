package com.exceedy.gen;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import com.tdchain.nftse.entity.Entity;


/**
 * @author exccedy
 * @date 2021/7/5
 **/
public class CodeGenerator {

    public static void main(String[] args) {
        // 自动生成器

        new AutoGenerator(// 数据库配置
                new DataSourceConfig.Builder("jdbc:mysql://127.0.0.1:3307/nfr","root","123456")
                        .typeConvert(new TestType())
                        .keyWordsHandler(new MySqlKeyWordsHandler())
//                        .schema("nfr")
                        .build())
                .global(  // 全局配置
                        GeneratorBuilder.globalConfigBuilder()
                                .fileOverride() // 覆盖文件
//                                .enableSwagger() // 开启swagger
                                .openDir(false)
                                // 这里是绝对路径
                                .outputDir("/Users/exccedy/project/td_project/ntr/db/src/main/java/")
//                                .outputDir("/Users/exccedy/project/td_project/mybatis-plus-auto-gen/src/main/java/")
                                .author("exceedy").dateType(DateType.TIME_PACK)
                                .build())
                .packageInfo( // 包配置
                        new PackageConfig.Builder()
//                                .parent("com.tdchain")
                                .parent("com.tdchain.nfr")
                                .moduleName("db")
                                .build())
                .template( // 模版配置
                        new TemplateConfig.Builder()
                                .disable(
                                        TemplateType.CONTROLLER
//                                        TemplateType.SERVICE
//                                        ,TemplateType.MAPPER, TemplateType.XML
                                )

                                .build())
                .strategy(// 策略配置
                        new StrategyConfig.Builder()
                                //.enableSqlFilter()// 现在默认启用sql过滤
                                .enableCapitalMode()// 是否大写命名
//                                .addInclude("activity") // 要生成的表名
//                                .addInclude("activity_digital") // 要生成的表名
                                .addInclude("apple_pay_info") // 要生成的表名
//                                .addInclude("category_digital_relation") // 要生成的表名

//                                .likeTable(new LikeTable("apply")) // new LikeTable 模糊匹配 需要生成的表
                                .entityBuilder()// 实体配置构建者

                                .enableRemoveIsPrefix()
                                .logicDeleteColumnName("delete")
//                                .superClass("com.tdchain.db.entity.Entity")
                                .superClass(Entity.class)
//                                .addSuperEntityColumns("delete","create_time","update_time")
                                .enableLombok()// 开启lombok模型
//                                .versionColumnName("version") //乐观锁数据库表字段
                                .naming(NamingStrategy.underline_to_camel)// 数据库表映射到实体的命名策略
                                .addTableFills(new Column("create_time", FieldFill.INSERT))	//基于数据库字段填充
                                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))	//基于模型属性填充
                                .controllerBuilder() //控制器属性配置构建
                                .build())
                .execute();
    }
}
