package com.example.beneficiary.util;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;

@Configuration
@Profile("int")
public class NeoConfig {
    
    @Autowired
    private Environment env;

    private static final Logger log = LoggerFactory.getLogger(NeoConfig.class);

    @Bean(destroyMethod = "")
    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException, SQLException {
        
        String dbjndipath = env.getProperty("spring.datasource.jndi-name");
        
        DataSource ds = (DataSource) new JndiTemplate().lookup("java:comp/env/" + dbjndipath);

        DBInformation dbInfo = new DBInformation(ds.getConnection().getMetaData());
        log.info(dbInfo.toString());

        return ds;
    }
}
