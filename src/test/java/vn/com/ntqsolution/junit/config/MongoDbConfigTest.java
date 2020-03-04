package vn.com.ntqsolution.junit.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
@Profile(value="unit-test")
public class MongoDbConfigTest extends AbstractMongoConfiguration {
    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return "userdb";
    }
}
