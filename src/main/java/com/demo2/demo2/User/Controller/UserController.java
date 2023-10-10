package com.demo2.demo2.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo2.demo2.IService.IService;

@RestController
public class UserController {

    private IService<String> service;

    @Autowired
    public UserController(IService<String> service) {
        this.service = service;
    }

    @GetMapping("/users")
    public String[] users() {
        return service.get();
    }
}
