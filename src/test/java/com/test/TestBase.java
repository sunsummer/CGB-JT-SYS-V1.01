package com.test;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
	protected ClassPathXmlApplicationContext ctx;
	@After //org.junit.After
	public void close(){
		ctx.close();
	}
	@Before //org.junit.Before;
	public void init(){
		ctx = new ClassPathXmlApplicationContext(
	    "spring-configs.xml");
	}
}


