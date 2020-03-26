package com.sanservices.websitesapi.config.jdbc;

import com.sanservices.websitesapi.config.jdbc.source.SandalsWebMySql;
import com.sanservices.websitesapi.config.jdbc.source.SandalsWebOracle;
import com.sanservices.websitesapi.config.jdbc.source.Wds;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

    @Bean
    @ConfigurationProperties("sanservices.datasource.sandals-web-oracle")
    @SandalsWebOracle
    public DataSource sandalsWebOracleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @SandalsWebOracle
    public JdbcTemplate sandalsWebOracleJdbcTemplate(@SandalsWebOracle DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    @SandalsWebOracle
    public NamedParameterJdbcTemplate sandalsWebOracleNamedParameterJdbcTemplate(@SandalsWebOracle JdbcTemplate template) {
        return new NamedParameterJdbcTemplate(template);
    }

    @Bean
    @SandalsWebOracle
    public TransactionManager sandalsWebOracleTx(@SandalsWebOracle DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }


    @Bean
    @ConfigurationProperties("sanservices.datasource.sandals-web-mysql")
    @SandalsWebMySql
    public DataSource sandalsWebMySqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @SandalsWebMySql
    public JdbcTemplate sandalsWebMySqlJdbcTemplate(@SandalsWebMySql DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    @SandalsWebMySql
    public NamedParameterJdbcTemplate sandalsWebMySqlNamedParameterJdbcTemplate(@SandalsWebMySql JdbcTemplate template) {
        return new NamedParameterJdbcTemplate(template);
    }

    @Bean
    @SandalsWebMySql
    public TransactionManager sandalsWebMySqlTx(@SandalsWebMySql DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }


    @Bean
    @ConfigurationProperties("sanservices.datasource.wds")
    @Wds
    public DataSource wdsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Wds
    public JdbcTemplate wdsJdbcTemplate(@Wds DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    @Wds
    public NamedParameterJdbcTemplate wdsNamedParameterJdbcTemplate(@Wds JdbcTemplate template) {
        return new NamedParameterJdbcTemplate(template);
    }

    @Bean
    @Wds
    public TransactionManager wdsTx(@Wds DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}
