package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.acumen.training.codes.SimpleApp;
import org.junit.jupiter.api.Test;

public class TestSimpleApp {
	@Test
	public void testApp() {
		System.out.println("testApp");
		SimpleApp app = new SimpleApp();
		
		assertEquals("app didn't return 1", app.returnOne() == 1);
	}
}
