package com.sanservices.websitesapi.config.jdbc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

import static com.sanservices.websitesapi.config.jdbc.Sources.*;

@Configuration
public class JdbcConfiguration {

    @Bean
    @Source(SandalsWebOracle)
    @ConfigurationProperties("sanservices.datasource.sandals-web-oracle")
    public DataSource sandalsWebOracleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Source(SandalsWebOracle)
    public JdbcTemplate sandalsWebOracleJdbcTemplate(@Source(SandalsWebOracle) DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    @Source(SandalsWebOracle)
    public NamedParameterJdbcTemplate sandalsWebOracleNamedParameterJdbcTemplate(@Source(SandalsWebOracle) JdbcTemplate template) {
        return new NamedParameterJdbcTemplate(template);
    }

    @Bean
    @Source(SandalsWebOracle)
    @Qualifier("sandalsWebOracle")
    public TransactionManager sandalsWebOracleTx(@Source(SandalsWebOracle) DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }


    @Bean
    @Source(SandalsWebMySql)
    @ConfigurationProperties("sanservices.datasource.sandals-web-mysql")
    public DataSource sandalsWebMySqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Source(SandalsWebMySql)
    public JdbcTemplate sandalsWebMySqlJdbcTemplate(@Source(SandalsWebMySql) DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    @Source(SandalsWebMySql)
    public NamedParameterJdbcTemplate sandalsWebMySqlNamedParameterJdbcTemplate(@Source(SandalsWebMySql) JdbcTemplate template) {
        return new NamedParameterJdbcTemplate(template);
    }

    @Bean
    @Source(SandalsWebMySql)
    @Qualifier("sandalsWebMysql")
    public TransactionManager sandalsWebMySqlTx(@Source(SandalsWebMySql) DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }


    @Bean
    @Source(Wds)
    @ConfigurationProperties("sanservices.datasource.wds")
    public DataSource wdsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Source(Wds)
    public JdbcTemplate wdsJdbcTemplate(@Source(Wds) DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    @Source(Wds)
    public NamedParameterJdbcTemplate wdsNamedParameterJdbcTemplate(@Source(Wds) JdbcTemplate template) {
        return new NamedParameterJdbcTemplate(template);
    }

    @Bean
    @Source(Wds)
    @Qualifier("wds")
    public TransactionManager wdsTx(@Source(Wds) DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}
