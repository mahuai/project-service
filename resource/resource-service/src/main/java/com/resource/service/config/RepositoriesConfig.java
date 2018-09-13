package com.resource.service.config;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.util.Collections;

/**
 * @author ms
 * @Description: class description
 * @Package com.resource.service.config
 * @date: Created in 2018/8/28  14:00
 */
@Configuration
public class RepositoriesConfig extends AbstractMongoConfiguration {

    /**
     * Return the name of the database to connect to.
     *
     * @return must not be {@literal null}.
     */
    @Override
    protected String getDatabaseName() {
        return "MongoDB";
    }

    /**
     * Return the {@link MongoClient} instance to connect to. Annotate with {@link Bean} in case you want to expose a
     * {@link MongoClient} instance to the {@link ApplicationContext}.
     *
     * @return
     */
    @Override
    public MongoClient mongoClient() {
        return new MongoClient(Collections.singletonList(new ServerAddress("", 27017)));
    }


    /**
     * Creates a {@link SimpleMongoDbFactory} to be used by the {@link MongoTemplate}. Will use the {@link MongoClient}
     * instance configured in {@link #mongoDbFactory()} ()}.
     *
     * @return
     * @see #mongoClient()
     * @see #mongoTemplate()
     */
    @Override
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
    }

    /**
     * Creates a {@link MongoTemplate}.
     *
     * @return
     */
    @Override
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }
}
