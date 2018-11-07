package com.asochat;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.asochat.api.resources.RoomResource;

public class RoomResouceTest extends JerseyTest {

	@Test
	public void test() throws Exception {
		String json = ClientBuilder.newClient()
												.target("http://localhost:9998")
												.path("/room")
												.request("application/json;charset=utf-8")
												.get(String.class);
		System.out.println(json);
	}

	@Override
    protected Application configure() {
        return new ResourceConfig(RoomResource.class);
    }
}
