package com.demo2.demo2.Post.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo2.demo2.IService.IService;
import com.demo2.demo2.Post.Models.PostModel;

@RestController
public class PostController {

    private IService<PostModel> service;

    @Autowired
    public PostController(IService<PostModel> service) {
        this.service = service;
    }

    @PostMapping("/post")
    public PostModel postPost(@RequestBody PostModel model) {
        return service.post(model);
    }

    @GetMapping("/posts")
    public PostModel[] getPosts() {
        return service.get();
    }

}