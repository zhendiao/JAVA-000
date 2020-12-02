package com.chongba.schedule.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author liMingLiang
 * @date 2020/12/1
 */
@Slf4j
@Configuration
public class MultiDataSourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSourceProperties slaveDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public JdbcTemplate ssJdbcTemplate(DataSource shardingSphereDataSource) {
        return new JdbcTemplate(shardingSphereDataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate ssNamedParameterJdbcTemplate(JdbcTemplate ssJdbcTemplate) {
        return new NamedParameterJdbcTemplate(ssJdbcTemplate);
    }

    @Bean
    @Resource
    public PlatformTransactionManager ssTxManager(DataSource shardingSphereDataSource) {
        return new DataSourceTransactionManager(shardingSphereDataSource);
    }
    @Bean
    public DataSource masterDataSource() {
        DataSourceProperties dataSourceProperties = masterDataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public JdbcTemplate masterJdbcTemplate(DataSource masterDataSource) {
        return new JdbcTemplate(masterDataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate masterNamedParameterJdbcTemplate(JdbcTemplate masterJdbcTemplate) {
        return new NamedParameterJdbcTemplate(masterJdbcTemplate);
    }

    @Bean
    @Resource
    public PlatformTransactionManager masterTxManager(DataSource masterDataSource) {
        return new DataSourceTransactionManager(masterDataSource);
    }

    @Bean
    public DataSource slaveDataSource() {
        DataSourceProperties dataSourceProperties = slaveDataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public JdbcTemplate slaveJdbcTemplate(DataSource slaveDataSource) {
        return new JdbcTemplate(slaveDataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate slaveNamedParameterJdbcTemplate(JdbcTemplate slaveJdbcTemplate) {
        return new NamedParameterJdbcTemplate(slaveJdbcTemplate);
    }

    @Bean
    @Resource
    public PlatformTransactionManager slaveTxManager(DataSource slaveDataSource) {
        return new DataSourceTransactionManager(slaveDataSource);
    }
}