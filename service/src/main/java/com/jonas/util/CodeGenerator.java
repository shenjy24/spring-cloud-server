package com.jonas.util;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2019/04/29
 */
public class CodeGenerator {


    public static void generate(String serviceName, String moduleName, String... tableNames) {
        //代码生成器
        AutoGenerator generator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        String servicePath = projectPath + "/" + serviceName;
        globalConfig.setOutputDir(servicePath + "/src/main/java");
        globalConfig.setAuthor("shenjy");
        globalConfig.setOpen(false);
        //是否覆盖已有文件
        globalConfig.setFileOverride(false);
        globalConfig.setServiceName("%sService");
        generator.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/shenjy");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        generator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.jonas");
        generator.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ，如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return servicePath + "/src/main/resources/mapper/" + moduleName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        generator.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //是否为lombok模型
        strategyConfig.setEntityLombokModel(true);
        //是否为构建者模型
        strategyConfig.setEntityBuilderModel(true);
        //是否生成实体时，生成字段注解
        strategyConfig.entityTableFieldAnnotationEnable(true);
        //逻辑删除属性名称
        strategyConfig.setLogicDeleteFieldName("deleted");
        strategyConfig.setInclude(tableNames);
        generator.setStrategy(strategyConfig);
        generator.setTemplateEngine(new VelocityTemplateEngine());
        generator.execute();
    }

    public static void main(String[] args) {
        generate("service", "", "order");
    }

}
