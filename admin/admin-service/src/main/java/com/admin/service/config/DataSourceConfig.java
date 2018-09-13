package com.admin.service.config;

import com.admin.service.config.properties.DruidProperties;
import com.admin.service.interceptor.SqlInterceptor;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author future
 * @Description:
 * @Package com.admin.service.config project-service
 * @date: Created in 2018/7/1214:32
 */
@Configuration
public class DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    private DruidProperties properties;

    public DataSourceConfig() {
        logger.info("init dataSource--------->{}", DataSourceConfig.class);
    }


    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(properties.getUrl());
        datasource.setUsername(properties.getUserName());
        datasource.setPassword(properties.getPassWord());
        datasource.setDriverClassName(properties.getDriverClassName());
        datasource.setInitialSize(properties.getInitialSize());
        datasource.setMinIdle(properties.getMinIdle());
        datasource.setMaxActive(properties.getMaxActive());
        datasource.setMaxWait(properties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        datasource.setRemoveAbandoned(true);
        datasource.setRemoveAbandonedTimeout(1800);
        datasource.setLogAbandoned(true);
        try {
            datasource.setFilters("stat,wall,slf4j");
        } catch (SQLException var5) {
            logger.error("druid configuration initialization filter", var5);
        }
        return datasource;
    }

    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "false");
        properties.setProperty("rowBoundsWithCount", "false");
        properties.setProperty("pageSizeZero", "true");
        properties.setProperty("returnPageInfo", "false");
        properties.setProperty("reasonable", "false");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "none");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactory.setPlugins(new Interceptor[]{pageInterceptor(), new SqlInterceptor()});
        sessionFactory.setConfiguration(configuration);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*Mapper.xml"));
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    /**
     * 配置事物管理器
     *
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }


    @Bean
    public ServletRegistrationBean statViewServlet() {
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置ip白名单
        /*servletRegistrationBean.addInitParameter("allow", "127.0.0.1");*/
        //设置ip黑名单，如果allow与deny共同存在时,deny优先于allow
        /*servletRegistrationBean.addInitParameter("deny", "192.168.0.19");*/
        //设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter() {
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
