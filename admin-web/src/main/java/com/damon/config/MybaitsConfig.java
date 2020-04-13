package com.damon.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;

/**
*
*
* created by Damon
* 2018年5月23日 下午7:39:37
*
*/
@Component
@Configuration
@EnableTransactionManagement
@MapperScan("com.damon.*.dao")
public class MybaitsConfig {

    @Autowired
    private EnvConfig envConfig;
    
    @Autowired
	private Environment env;

    @Bean(name = "dataSource")
    public DataSource getDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", envConfig.getJdbc_driverClassName());
        props.put("url", envConfig.getJdbc_url());
        props.put("username", envConfig.getJdbc_username());
        props.put("password", envConfig.getJdbc_password());
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {

		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		// 指定数据源(这个必须有，否则报错)
		fb.setDataSource(dataSource);
		// 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
		fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
		fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));// 指定xml文件位置

		// 分页插件
		PageHelper pageHelper = new PageHelper();
		Properties props = new Properties();
		// 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
        //禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据
		props.setProperty("reasonable", "true");
		//指定数据库
		props.setProperty("dialect", "mysql");
		//支持通过Mapper接口参数来传递分页参数
		props.setProperty("supportMethodsArguments", "true");
		//总是返回PageInfo类型,check检查返回类型是否为PageInfo,none返回Page
		props.setProperty("returnPageInfo", "check");
		props.setProperty("params", "count=countSql");
		pageHelper.setProperties(props);
		// 添加插件
		fb.setPlugins(new Interceptor[] { pageHelper });

		try {
			return fb.getObject();
		} catch (Exception e) {
            throw e;
		}
	}

    /**
     * 配置事务管理器
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

