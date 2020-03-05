package com.tw.devops.sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileController {

    private Mobile mobile = new Mobile();

    @RequestMapping("/mobile")
    public Mobile mobile(@RequestParam(value="name", defaultValue="iPhone") String name) {
        mobile.setName("iPhone 11");
        mobile.setPlatform("iOS");
        mobile.setBrand("Apple");
        mobile.setModelNo("10292772");
        mobile.setOSVersion("iOS 13.1");
        return mobile;
    }
}
