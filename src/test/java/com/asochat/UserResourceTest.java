package com.asochat;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.asochat.api.resources.UserResource;

public class UserResourceTest extends JerseyTest{

	@Test
	public void test() throws Exception {

		String res = ClientBuilder.newClient()
									.target("http://localhost:9998")
									.path("/user")
									.request("text/plain;charset=utf-8")
									.get(String.class);

		System.out.println(res);
	}

	@Override
    protected Application configure() {
        return new ResourceConfig(UserResource.class);
    }
}

