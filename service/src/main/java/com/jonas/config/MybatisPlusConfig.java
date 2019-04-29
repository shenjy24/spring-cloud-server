/**
 *
 */
package com.jonas.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


/**
 * 【 MyBatisPlus 配置类 】
 *
 * @author shenjy 2018/10/25
 */
@Configuration
@MapperScan("com.jonas.mapper")
public class MybatisPlusConfig {
    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        // 攻击 SQL 阻断解析器、加入解析链
        List<ISqlParser> sqlParsers = new ArrayList<>();
        sqlParsers.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParsers);

        return paginationInterceptor;
    }

    /**
     * 性能分析插件
     * @return
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }
}
