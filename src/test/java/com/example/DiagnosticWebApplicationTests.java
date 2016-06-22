package com.example;

import ee.netgroup.su2016.diagnostic.web.DiagnosticWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DiagnosticWebApplication.class)
@WebAppConfiguration
public class DiagnosticWebApplicationTests {

	@Test
	public void contextLoads() {
	}

}
