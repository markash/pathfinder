package za.co.yellowfire.threesixty;

import java.util.ArrayList;

import org.mongeez.MongeezRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoAuditing
@Import(value = MongoAutoConfiguration.class)
public class MongoConfig extends AbstractMongoConfiguration {


    @Autowired
    private MongoProperties mongoProperties;
    
    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
    
	@Override
	public String getDatabaseName() {
		return mongoProperties.getDatabase();
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		ServerAddress address = new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort());
		
		MongoClient client;
		if (!mongoProperties.getHost().equals("127.0.0.1") && !mongoProperties.getHost().equals("localhost")) {
			MongoCredential credential = 
					MongoCredential.createCredential(
							mongoProperties.getUsername(), 
							mongoProperties.getDatabase(), 
							mongoProperties.getPassword());
			ArrayList<MongoCredential> credentials = new ArrayList<MongoCredential>(1);
			credentials.add(credential);
			
			client = new MongoClient(address, credentials);
		} else {
			client = new MongoClient(address);
		}
		
		return client;
	}

	/*
	 * <bean id="mongeez" class="org.mongeez.MongeezRunner">
    <property name="mongo" ref="mongo"/>
    <property name="executeEnabled" value="${migrate}"/>
    <property name="dbName" value="${db.name}"/>
    <property name="file" value="classpath:com/secondmarket/mongo/mongeez.xml"/>
</bean>
	 */
	
	@Bean
	public MongeezRunner mongeez() throws Exception {
		MongeezRunner mongeez = new MongeezRunner();
		mongeez.setMongo(mongo());
		mongeez.setExecuteEnabled(true);
		mongeez.setDbName(mongoProperties.getDatabase());
		mongeez.setFile(new ClassPathResource("mongeez/mongeez.xml"));
		return mongeez;
	}
	
	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}
}