package com.sondev.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(
        basePackages = "com.sondev.mybatis.tertiary.mapper",
        sqlSessionFactoryRef = "tertiarySqlSessionFactory"
)
public class TertiaryDatabaseConfig {

    @Bean(name = "tertiaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.tertiary")
    public DataSource tertiaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "tertiarySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("tertiaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:mybatis/tertiary/**/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "tertiarySqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("tertiarySqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
