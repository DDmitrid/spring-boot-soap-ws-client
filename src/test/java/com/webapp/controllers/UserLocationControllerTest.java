package com.webapp.controllers;

import com.webapp.services.IPClientService;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserLocationController.class)


public class UserLocationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IPClientService ipClientService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnCountryNameWithValidIpAddress() throws Exception {
        final String ipAddress = "192.34.1.43";
        final String countryName = "United States";

        given(this.ipClientService.getUserCountryNameByIp(ipAddress))
                .willReturn(countryName);

        this.mvc.perform(get("/location?ipAddress=" + ipAddress).accept(MediaType.ALL))
                .andExpect(status().isOk()).
                andExpect(content().string(countryName));
    }

}