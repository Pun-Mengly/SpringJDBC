package com.demo2.demo2.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo2.demo2.IService.IService;

@RestController
public class TestController {
    private IService service;

    @Autowired
    public TestController(@Qualifier("postService") IService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return service.test();
    }
}
