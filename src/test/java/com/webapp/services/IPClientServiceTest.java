package com.webapp.services;

import com.webapp.services.GetUserLocationResponse;
import com.webapp.services.IPClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IPClientServiceTest {

	@Autowired
	private IPClientService ipClientService;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void shouldReturnLocationOfTheUserWithValidIpAddress() {

		String ipAddress = "192.168.2.14";
		GetUserLocationResponse response = ipClientService.getUserLocationByIp(ipAddress);

		assertNotNull(response);
		assertNotNull(response.getGetUserLocationResult());

	}

	@Test
	public void shouldReturnLocationCountryNameOfTheUserWithValidIpAddress() {

		String expectedCountryName = "United States";
		String actualCountryName = "";
		String ipAddress = "192.168.2.14";
		actualCountryName = ipClientService.getUserCountryNameByIp(ipAddress);

		assertThat(actualCountryName, is(expectedCountryName));
	}

}
