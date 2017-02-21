package com.wkb;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-spring-config.xml"})
public abstract class ContextBase {
	
}
	