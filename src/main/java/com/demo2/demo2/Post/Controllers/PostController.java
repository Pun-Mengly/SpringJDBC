package com.demo2.demo2.Post.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo2.demo2.IService.IService;
import com.demo2.demo2.Post.Models.MyResponse;
import com.demo2.demo2.Post.Models.PostModel;

@RestController
@RequestMapping("post")
public class PostController {

    private IService<MyResponse,PostModel> service;

    @Autowired
    public PostController(IService<MyResponse,PostModel> service) {
        this.service = service;
    }

    @PostMapping("/post")
    public MyResponse postPost(@RequestBody PostModel model) {
        return service.post(model);
    }

    @GetMapping("/get-all")
    public PostModel[] getPosts() {
        return service.get();
    }
    @GetMapping("/welcome")
    public String welcome() {
        return service.welcome();
    }

}