package com.example.EMS_UST;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmsUstApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Hello World");
	}
	
	@Test
	private void publ() {

		GetAndSet GS=new GetAndSet();
		GS.setColor("Red");
		System.out.println(GS.getColor());
		assertEquals("Red", GS.getColor());
	}
	
	
}
