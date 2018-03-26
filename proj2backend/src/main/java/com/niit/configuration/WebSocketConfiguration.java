package com.niit.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages="com.niit")
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
	public void registerStompEndPoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chatmodule").withSockJS();
	}
	public void configureClientInboundChannel (ChannelRegistration registration) {
		
	}
	public void configureClientOutboundChannel (ChannelRegistration registration) {
		
	}
	public void configureMessageBroker (MessageBrokerRegistry registry) {
	registry.enableSimpleBroker("/queue/","/topic/");
	registry.setApplicationDestinationPrefixes("/app");
	}
}
