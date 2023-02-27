package com.stats.helper.base.config;


import com.stats.helper.base.dozer.DozerMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class DozerConfig
{

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public DozerMapperFactoryBean dozerMapper() throws IOException
    {
        DozerMapperFactoryBean factoryBean = new DozerMapperFactoryBean();
        factoryBean.setMappingFiles(applicationContext.getResources("classpath*:/**/conf/dozer/*.xml"));
        return factoryBean;
    }

}
