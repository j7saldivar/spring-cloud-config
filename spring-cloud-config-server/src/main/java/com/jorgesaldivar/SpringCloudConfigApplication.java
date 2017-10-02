package com.jorgesaldivar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Querying the configuration
 * 
 * <pre>
 * /{application}/{profile}[/{label}] 
 * 		Example: /appName/dev/master
 * 				 /appName/prod/v1
 * 				 /appName/default
 * 
 * /{application}-{profile}.yml (yml | properties)
 * 		Example: /appName-dev.yml
 * 				 /appName-default.yml
 * 
 * /{label}/{application}-{profile}.yml (yml | properties)
 * 		Example: /master/appName-dev.yml
 * 				 /v1/appName-prod.yml
 * 				 /master/appName-default.yml
 * </pre>
 * 
 * Localhost examples:
 * 
 * <pre>
 * 	http://localhost:8888/config-client-app/prod
 * 	http://localhost:8888/config-client-app/default
 *	http://localhost:8888/config-client-app.yml
 *	http://localhost:8888/config-client-app.properties
 * </pre>
 * 
 * @author saldivar
 *
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigApplication.class, args);
	}
}
