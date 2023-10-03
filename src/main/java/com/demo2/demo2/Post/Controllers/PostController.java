package com.demo2.demo2.Post.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo2.demo2.Post.Models.MyResponse;
import com.demo2.demo2.Post.Models.PostModel;
import com.demo2.demo2.Post.Services.PostService;

@RestController
public class PostController {
    @Autowired
    private PostService repo;

    @PostMapping("/post")
    public MyResponse[] postPost(@RequestBody PostModel model) {
        return repo.postDataTobase(model);
    }

    @GetMapping("/posts")
    public PostModel[] getPosts() {
        return repo.getDataFrombase();
    }

}