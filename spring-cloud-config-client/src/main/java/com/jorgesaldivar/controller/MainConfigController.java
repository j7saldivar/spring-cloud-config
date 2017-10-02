package com.jorgesaldivar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorgesaldivar.config.ClientConfig;

@RestController
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
