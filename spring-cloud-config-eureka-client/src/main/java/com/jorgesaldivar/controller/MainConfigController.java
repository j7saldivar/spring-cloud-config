package com.jorgesaldivar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorgesaldivar.config.ClientConfig;

/**
 * Calling http://localhost:8080/refresh will manually refresh the configuration properties.
 * {@link RefreshScope} works for {@link Value} and {@link Bean}
 * 
 * @author saldivar
 *
 */
@RestController
@RefreshScope
public class MainConfigController {

	private ClientConfig clientConfig;

	@Value("${some.other.property}")
	private String someOtherProperty;

	@Autowired
	public void setClientConfig(ClientConfig clientConfig) {
		this.clientConfig = clientConfig;
	}

	@RequestMapping()
	public String getConfigs() {
		return String.join(" , ", clientConfig.getProperty(), someOtherProperty);
	}

}
