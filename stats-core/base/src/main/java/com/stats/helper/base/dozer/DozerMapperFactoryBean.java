package com.stats.helper.base.dozer;


import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DozerMapperFactoryBean extends ApplicationObjectSupport implements InitializingBean, FactoryBean<Mapper>
{

    private final List<String> mappingFileUrls = new ArrayList<>(1);

    private Mapper mapper;


    /**
     * Spring resources definition for providing mapping file location.
     * Could be used for loading all mapping files by wildcard definition for example
     * <pre>
     * {@code
     *  <bean class="com.github.dozermapper.core.spring.DozerBeanMapperFactoryBean">
     *      <property name="mappingFiles" value="classpath*:/*.dozer.xml"/>
     *  <\/bean>
     * }
     * </pre>
     *
     * @param mappingFiles Spring resource definition
     * @throws IOException if URL fails to resolve
     */
    public void setMappingFiles(Resource[] mappingFiles) throws IOException
    {
        if (mappingFiles != null && mappingFiles.length > 0) {
            for (Resource mappingFile : mappingFiles) {
                URL url = mappingFile.getURL();
                mappingFileUrls.add(url.toString());
            }
        }
    }

    @Override
    public Mapper getObject() throws Exception
    {
        return null;
    }

    @Override
    public Class<?> getObjectType()
    {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        this.mapper = DozerBeanMapperBuilder.create()
                .withMappingFiles(mappingFileUrls)
                .build();
    }
}
