package org.oooooomy;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {

    public static final String PROJECT_PATH = "/Users/aa/Programes/CampusShuttle/src/main";

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/campus_shuttle", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("Gao YuanMing")
                            .outputDir(PROJECT_PATH + File.separator + "java"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("org.oooooomy")
                                .entity("model.entity")
                                .mapper("mapper")
                                .service("service")
                                .serviceImpl("service.impl")
                                .xml("mapper.xml")
                                .pathInfo(Collections.singletonMap(OutputFile.xml, PROJECT_PATH + File.separator +
                                        "resources" + File.separator + "mappers")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("t_user", "t_order", "t_site",
                                        "t_payment_record", "t_refund_record",
                                        "t_schedule", "t_schedule_inventory") // 设置需要生成的表名
                                .addTablePrefix("t_")
                                .entityBuilder()
                                .enableLombok() // 启用 Lombok
                                .enableTableFieldAnnotation() // 启用字段注解
                                .controllerBuilder()
                                .enableRestStyle() // 启用 REST 风格
                                .serviceBuilder()
                                .formatServiceFileName("%sService")
                                .formatServiceImplFileName("%sServiceImpl") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
