package org.github.taktos.module.cdi;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Arquillian.class)
public class GreeterTest {
	private static final Logger LOG = LoggerFactory.getLogger(GreeterTest.class);

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClass(Greeter.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		LOG.info(jar.toString(true));
		return jar;
	}

	@Inject
	Greeter greeter;

	@Test
	public void should_create_greeting() {
	    assertEquals("Hello, Earthling!",
	            greeter.createGreeting("Earthling"));
	        greeter.greet(System.out, "Earthling");
	}

}
