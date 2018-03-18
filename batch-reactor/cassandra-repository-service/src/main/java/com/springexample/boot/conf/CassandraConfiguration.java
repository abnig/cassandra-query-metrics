package com.springexample.boot.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.QueryLogger;

@Configuration
@PropertySource(value = "application.properties")
@EnableCassandraRepositories(basePackages = { "com.springexample.boot" })
public class CassandraConfiguration {

	@Value("${cassandra.contactpoints}")
	private String[] contactPoints;

	@Value("${cassandra.keyspace}")
	private String keySpace;

	@Value("${cassandra.user}")
	private String user;

	@Value("${cassandra.password}")
	private String password;

	@Value("${cassandra.port}")
	private String port;

	@Value("${cassandra.ssl.enabled}")
	private String sslEnabled;

	@Bean
	public Cluster cluster() {
		Cluster.Builder builder = Cluster.builder().addContactPoints(contactPoints).withPort(Integer.parseInt(port))
				.withCredentials(user, password);
		
		builder.getConfiguration().getSocketOptions().setConnectTimeoutMillis(Integer.MAX_VALUE);
		
		if(Boolean.parseBoolean(this.sslEnabled))
			builder.withSSL();
		
		return builder.build();
	}
	
	@Bean
	public QueryLogger queryLogger(Cluster cluster) {
		QueryLogger queryLogger = QueryLogger.builder().withConstantThreshold(100L).build();
		cluster.register(queryLogger);
		return queryLogger;
	}
	
	@Bean
	public CassandraMappingContext mappingContext() {
		return new CassandraMappingContext();
	}
	
	@Bean
	public CassandraConverter converter(CassandraMappingContext mappingContext) {
		return new MappingCassandraConverter(mappingContext);
	}
	
	@Bean
	public CassandraSessionFactoryBean session(Cluster cluster, CassandraConverter converter) {
		CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
		session.setCluster(cluster);
		session.setKeyspaceName(keySpace);
		session.setConverter(converter);
		session.setSchemaAction(SchemaAction.NONE);
		return session;
	}
	
	@Bean
	public CassandraOperations cassandraTemplate(CassandraSessionFactoryBean session, CassandraConverter converter) {
		return new CassandraTemplate(session.getObject(), converter);
	}

}
