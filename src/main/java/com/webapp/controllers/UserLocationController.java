package com.webapp.controllers;

import com.webapp.services.GetUserLocationResponse;
import com.webapp.services.IPClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLocationController {
    @Autowired
    private IPClientService ipClientService;

    @GetMapping("/location")
    public String getLocationByIp(@RequestParam("ipAddress") String ipAddress) {
        System.out.println(ipAddress);
        return ipClientService.getUserCountryNameByIp(ipAddress);
    }
}
