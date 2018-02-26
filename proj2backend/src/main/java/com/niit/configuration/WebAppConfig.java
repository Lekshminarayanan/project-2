package com.niit.configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebAppConfig extends WebMvcConfigurerAdapter{
	public WebAppConfig() {
		System.out.println("WebAppConfig is instantiated");
	}

}
