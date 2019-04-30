package com.jonas.util;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2019/04/29
 */
public class CodeGenerator {


    /**
     * 自动代码生成
     *
     * @param serviceName  服务名，这里为service
     * @param moduleName   模块名，例如订单模块即为order
     * @param tableNames   表名，可以多个
     */
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
        packageConfig.setEntity("entity." + moduleName);
        packageConfig.setMapper("mapper." + moduleName);
        packageConfig.setXml("mapper." + moduleName);
        packageConfig.setService("service." + moduleName);
        packageConfig.setServiceImpl("service." + moduleName + ".impl");
        generator.setPackageInfo(packageConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //是否为lombok模型
        strategyConfig.setEntityLombokModel(true);
        //是否为构建者模型
        strategyConfig.setEntityBuilderModel(true);
        //是否生成实体时，生成字段注解
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        //逻辑删除属性名称
        strategyConfig.setLogicDeleteFieldName("deleted");
        strategyConfig.setInclude(tableNames);
        generator.setStrategy(strategyConfig);
        generator.setTemplateEngine(new VelocityTemplateEngine());
        generator.execute();
    }

    public static void main(String[] args) {
        generate("service", "order", "order");
    }

}
