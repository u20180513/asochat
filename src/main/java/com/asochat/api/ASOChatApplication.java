package com.asochat.api;

import org.glassfish.jersey.server.ResourceConfig;

public class ASOChatApplication extends ResourceConfig {
	public ASOChatApplication() {
		packages(this.getClass().getPackage().getName());
	}
}
